package main.visitor.typeChecker;

import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.TernaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.types.NoType;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.LocalVariableSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.ast.nodes.Node;

import java.util.ArrayList;
import java.util.Set;

public class ExpressionTypeChecker extends Visitor<Type> {
    private Graph<String> classHierarchy;
    public ClassDeclaration currClassDec;
    public MethodDeclaration currMethodDec;
    public boolean isInMethodCall = false;
    public boolean LValue = false;
    public int typeErrorsNum;
    public int defaultArgsNum=0;

    public boolean doesReturn = false;
    public boolean conditionReturn = false;
    public boolean blockReturn = false;

    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public void checkClassDec(Node classDecNode, String className){
        if(!this.classHierarchy.doesGraphContainNode(className)){
            ClassNotDeclared classNotDeclaredException = new ClassNotDeclared(classDecNode.getLine(), className);
            classDecNode.addError(classNotDeclaredException);
            this.typeErrorsNum += 1;
        }
    }


    public void checkArrayDec(Node arrayDec, Type type){
        for(Expression dimExp : ((ArrayType)type).getDimensions() ) {
            if(((IntValue) dimExp).getConstant() == 0) {
                CannotHaveEmptyArray cannotHaveEmptyArrayException = new CannotHaveEmptyArray(arrayDec.getLine());
                arrayDec.addError(cannotHaveEmptyArrayException);
                this.typeErrorsNum += 1;
            }
        }
    }

    public void checkFptrDec(Node fptDec, Type type){
        if(!(type instanceof ClassType || type instanceof FptrType || type instanceof ArrayType))
            return;
        if(type instanceof ArrayType){
            checkArrayDec(fptDec, type);
        }
        if(type instanceof ClassType){
            String className = ((ClassType)type).getClassName().getName();
            checkClassDec(fptDec, className);
        }
        if(type instanceof FptrType) {
            Type returnType = ((FptrType) type).getReturnType();
            ArrayList<Type> argsType = ((FptrType) type).getArgumentsTypes();
            this.checkFptrDec(fptDec, returnType);
            for(Type argType : argsType)
                this.checkFptrDec(fptDec, argType);
        }
    }

    public boolean isLeftSubTypeOfRight(Type left, Type right){
        if(left instanceof NoType)
            return true;
        else if(left instanceof IntType && right instanceof IntType)
            return true;
        else if(left instanceof BoolType && right instanceof BoolType)
            return true;
        else if(left instanceof SetType && right instanceof SetType)
            return true;
        else if(left instanceof ArrayType && right instanceof ArrayType)
            return true;
        else if(left instanceof NullType && (right instanceof NullType || right instanceof FptrType || right instanceof ClassType || right instanceof SetType)) ///////////
            return true;
        else if(left instanceof VoidType && right instanceof VoidType)
            return true;
        else if(left instanceof ClassType && right instanceof ClassType)
            return this.classHierarchy.isSecondNodeAncestorOf(((ClassType) left).getClassName().getName(),
                    ((ClassType) right).getClassName().getName());
        else if(left instanceof ClassType)
            return false;

        else if(left instanceof FptrType && right instanceof FptrType){
            Type firstRetType = ((FptrType) left).getReturnType();
            Type secondRetType = ((FptrType) right).getReturnType();
            if(!isLeftSubTypeOfRight(firstRetType, secondRetType))
                return false;
            ArrayList<Type> firstArgsTypes = ((FptrType) left).getArgumentsTypes();
            ArrayList<Type> secondArgsTypes = ((FptrType) right).getArgumentsTypes();

            if(secondArgsTypes.size() != firstArgsTypes.size())
                return false;
            for(int i = 0; i < secondArgsTypes.size(); i++) {
                if(!isLeftSubTypeOfRight(secondArgsTypes.get(i), firstArgsTypes.get(i)))
                    return false;
            }
            return true;
        }
        else if(left instanceof FptrType)
            return false;
        return false;
    }

    public boolean isLvalue(Expression expression) {
        boolean prevIsCatchErrorsActive = Node.isCatchErrorsActive;
        boolean prevLValue = this.LValue;
        Node.isCatchErrorsActive = false;
        this.LValue = false;
        expression.accept(this);
        boolean isLvalue = !this.LValue;
        this.LValue = prevLValue;
        Node.isCatchErrorsActive = prevIsCatchErrorsActive;
        return isLvalue;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        //Todo
        // = , | , & , == , < , > , + , - , * , /
        this.LValue = true;
        BinaryOperator binaryOperator = binaryExpression.getBinaryOperator();
//        System.out.println(binaryOperator.name());
        Type leftType = binaryExpression.getFirstOperand().accept(this);
        Type rightType = binaryExpression.getSecondOperand().accept(this);
//        System.out.println("assign : " + binaryExpression.getLine() + "  "+ binaryOperator.name());
        if(binaryOperator != BinaryOperator.assign) {
            if (leftType instanceof NoType && rightType instanceof NoType)
                return new NoType();
        }
        if(binaryOperator == BinaryOperator.assign){
//            System.out.println("assign : " + leftType.toString() + rightType.toString());
            boolean isFirstLvalue = this.isLvalue(binaryExpression.getFirstOperand());
            if(!isFirstLvalue) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
            }
            if(leftType instanceof NoType || rightType instanceof NoType) {
                return new NoType();
            }
            boolean isSubtype = this.isLeftSubTypeOfRight(rightType, leftType);
            if(isSubtype) {
                if(isFirstLvalue)
                    return rightType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
            binaryExpression.addError(exception);
            return new NoType();
        }

        if(binaryOperator == BinaryOperator.eq){
            if((leftType instanceof NoType && (rightType instanceof ArrayType || rightType instanceof SetType)) ||
               (rightType instanceof NoType && (leftType instanceof ArrayType || leftType instanceof SetType))){
                UnsupportedOperandType unsupportedOperandTypeException =
                        new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
                binaryExpression.addError(unsupportedOperandTypeException);
                return new NoType();
            }
            else if(leftType instanceof NoType || rightType instanceof NoType)
                return new NoType();

            if(leftType instanceof IntType && rightType instanceof IntType)
                return new BoolType();
            if(leftType instanceof BoolType && rightType instanceof BoolType)
                return new BoolType();

            if(leftType instanceof ClassType && rightType instanceof ClassType) {
                String leftClassName = ((ClassType)leftType).getClassName().getName();
                String rightClassName = ((ClassType)rightType).getClassName().getName();
                if(leftClassName.equals(rightClassName))
                    return new BoolType();
            }
            if(leftType instanceof ClassType && rightType instanceof NullType)
                return new BoolType();
            if(leftType instanceof NullType && rightType instanceof ClassType)
                return new BoolType();
            if(leftType instanceof NullType && rightType instanceof NullType)
                return new BoolType();

            if(leftType instanceof FptrType && rightType instanceof FptrType)
                return new BoolType();
            if(leftType instanceof FptrType && rightType instanceof NullType)
                return new BoolType();
            if(leftType instanceof NullType && rightType instanceof FptrType)
                return new BoolType();
        }

        if(binaryOperator == BinaryOperator.gt || binaryOperator == BinaryOperator.lt){
            if(leftType instanceof IntType && rightType instanceof IntType)
                return new BoolType();

            if((leftType instanceof NoType && !(rightType instanceof IntType)) ||
                (rightType instanceof NoType && !(leftType instanceof IntType))){
                UnsupportedOperandType unsupportedOperandTypeException = new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
                binaryExpression.addError(unsupportedOperandTypeException);
                return new NoType();
            }
            else if(leftType instanceof NoType || rightType instanceof NoType)
                return new NoType();
        }

        if((binaryOperator == BinaryOperator.add) || (binaryOperator == BinaryOperator.sub) ||
                (binaryOperator == BinaryOperator.mult) || (binaryOperator == BinaryOperator.div)) {
            if((leftType instanceof IntType) && (rightType instanceof IntType))
                return new IntType();

            if((leftType instanceof NoType && !(rightType instanceof IntType)) ||
                    (rightType instanceof NoType && !(leftType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(leftType instanceof NoType || rightType instanceof NoType)
                return new NoType();
        }

        if((binaryOperator == BinaryOperator.or) || (binaryOperator == BinaryOperator.and)) {
            if((leftType instanceof BoolType) && (rightType instanceof BoolType))
                return new BoolType();

            if((leftType instanceof NoType && !(rightType instanceof BoolType)) ||
                    (rightType instanceof NoType && !(leftType instanceof BoolType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(leftType instanceof NoType || rightType instanceof NoType)
                return new NoType();
        }

        UnsupportedOperandType unsupportedOperandTypeException = new UnsupportedOperandType(binaryExpression.getLine(), binaryOperator.name());
        binaryExpression.addError(unsupportedOperandTypeException);
        return new NoType();
    }

    @Override
    public Type visit(NewClassInstance newClassInstance) {
        //todo
        this.LValue = true;
        ArrayList <Type> argsTypes = new ArrayList<>();

        for(Expression expression : newClassInstance.getArgs()) {
            Type expressionType = expression.accept(this);
            argsTypes.add(expressionType);
        }

        String className = newClassInstance.getClassType().getClassName().getName();
        if(!(this.classHierarchy.doesGraphContainNode(className))){
            ClassNotDeclared classNotDeclaredException = new ClassNotDeclared(newClassInstance.getLine(), className);
            newClassInstance.addError(classNotDeclaredException);
            return new NoType();
        }
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true);
            MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTableItem.getClassSymbolTable().getItem(MethodSymbolTableItem.START_KEY + "initialize", true);
            ArrayList<Type> constructorActualTypes = methodSymbolTableItem.getArgTypes();

            for(ArgPair argPair : methodSymbolTableItem.getMethodDeclaration().getArgs())
                if(argPair.getDefaultValue() != null)
                    this.defaultArgsNum += 1;
            if(argsTypes.size() < constructorActualTypes.size() - this.defaultArgsNum || argsTypes.size() > constructorActualTypes.size()){
                ConstructorArgsNotMatchDefinition constructorArgsNotMatchDefinitionException = new ConstructorArgsNotMatchDefinition(newClassInstance);
                newClassInstance.addError(constructorArgsNotMatchDefinitionException);
                return new NoType();
            }
            this.defaultArgsNum = 0;
            for(int i = 0; i < argsTypes.size(); i++) {
                if(!isLeftSubTypeOfRight(argsTypes.get(i), constructorActualTypes.get(i))){
                    ConstructorArgsNotMatchDefinition constructorArgsNotMatchDefinitionException = new ConstructorArgsNotMatchDefinition(newClassInstance);
                    newClassInstance.addError(constructorArgsNotMatchDefinitionException);
                    return new NoType();
                }
            }
            return newClassInstance.getClassType();

        } catch (ItemNotFoundException ignored){
            if(argsTypes.size() != 0) {
//                System.out.println("constructor : " + newClassInstance.getLine() + " ");
                ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                newClassInstance.addError(exception);
                return new NoType();
            }
            else {
                return newClassInstance.getClassType();
            }
        }
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        //Todo
        this.LValue = true;
        Type type = unaryExpression.getOperand().accept(this);
        UnaryOperator unaryOperator = unaryExpression.getOperator();

        if(type instanceof NoType)
            return new NoType();

        if(unaryOperator == UnaryOperator.not) {
            if(type instanceof BoolType)
                return type;
            UnsupportedOperandType UnsupportedOperandTypeException = new UnsupportedOperandType(unaryExpression.getLine(), unaryOperator.name());
            unaryExpression.addError(UnsupportedOperandTypeException);
            return new NoType();
        }
        if(unaryOperator == UnaryOperator.minus) {
            if(type instanceof IntType)
                return type;
            UnsupportedOperandType UnsupportedOperandTypeException = new UnsupportedOperandType(unaryExpression.getLine(), unaryOperator.name());
            unaryExpression.addError(UnsupportedOperandTypeException);
            return new NoType();
        }

        if(unaryOperator == UnaryOperator.postdec || unaryOperator == UnaryOperator.postinc){
//            System.out.println(unaryOperator);
            boolean isOperandLvalue = this.isLvalue(unaryExpression.getOperand());
//            System.out.println(isOperandLvalue);
            if(!isOperandLvalue) {
                IncDecOperandNotLvalue exception = new IncDecOperandNotLvalue(unaryExpression.getLine(), unaryOperator.name());
                unaryExpression.addError(exception);
            }
            if(type instanceof IntType) {
                if(isOperandLvalue)
                    return type;
                return new NoType();
            }
        }
        UnsupportedOperandType UnsupportedOperandTypeException = new UnsupportedOperandType(unaryExpression.getLine(), unaryOperator.name());
        unaryExpression.addError(UnsupportedOperandTypeException);
        return new NoType();
    }

    @Override
    public Type visit(MethodCall methodCall) {
        //Todo
        this.LValue = true;
        Type instanceType = methodCall.getInstance().accept(this);
//        System.out.println(methodCall.getInstance());
        boolean prevIsInMethodCallStmt = this.isInMethodCall;
        this.isInMethodCall = false;
        ArrayList<Type> argsTypes = new ArrayList<>();
        for(Expression arg : methodCall.getArgs()) {
            argsTypes.add(arg.accept(this));
        }
        this.isInMethodCall = prevIsInMethodCallStmt;
        if(instanceType instanceof NoType) {
            return new NoType();
        }
        if(!(instanceType instanceof FptrType) && !(instanceType instanceof ClassType)) {
            CallOnNoneCallable exception = new CallOnNoneCallable(methodCall.getLine());
            methodCall.addError(exception);
            return new NoType();
        }
        else {
            ArrayList<Type> actualArgsTypes = ((FptrType) instanceType).getArgumentsTypes();
            Type returnType = ((FptrType) instanceType).getReturnType();
            boolean hasError = false;
            if(!this.isInMethodCall && (returnType instanceof VoidType)) {
                CantUseValueOfVoidMethod exception = new CantUseValueOfVoidMethod(methodCall.getLine());
                methodCall.addError(exception);
            }
//            System.out.println(argsTypes.size() + " " + actualArgsTypes.size() + " " + this.defaultArgsNum);
            if(argsTypes.size() < actualArgsTypes.size() - this.defaultArgsNum || argsTypes.size() > actualArgsTypes.size()) {
                MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                methodCall.addError(exception);
//                return new NoType();
            }

            for(int i = 0; i < argsTypes.size(); i++) {
                if(!isLeftSubTypeOfRight(argsTypes.get(i), actualArgsTypes.get(i))) {
                    MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                    methodCall.addError(exception);
//                    return new NoType();
                }
            }
            if(hasError)
                return new NoType();

            this.typeErrorsNum = 0;
            if(returnType instanceof ArrayType)
                this.checkArrayDec(new NullValue(), returnType);
            if(returnType instanceof ClassType)
                this.checkClassDec(new NullValue(), ((ClassType) returnType).getClassName().getName());
            if(returnType instanceof FptrType)
                this.checkFptrDec(new NullValue(), returnType);
            if(this.typeErrorsNum > 0)
                return new NoType();
            return returnType;
        }
    }

    @Override
    public Type visit(Identifier identifier) {
        //Todo
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + this.currClassDec.getClassName().getName(), true);
            SymbolTable classSymbolTable = classSymbolTableItem.getClassSymbolTable();
            MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + this.currMethodDec.getMethodName().getName(), true);
            SymbolTable methodSymbolTable = methodSymbolTableItem.getMethodSymbolTable();
            LocalVariableSymbolTableItem localVariableSymbolTableItem = (LocalVariableSymbolTableItem) methodSymbolTable.getItem(LocalVariableSymbolTableItem.START_KEY + identifier.getName(), true);

            this.typeErrorsNum = 0;
            Type varType = localVariableSymbolTableItem.getType();
            if(varType instanceof ArrayType)
                this.checkArrayDec(new NullValue(), varType);
            if(varType instanceof ClassType)
                this.checkClassDec(new NullValue(), ((ClassType) varType).getClassName().getName());
            if(varType instanceof FptrType)
                this.checkFptrDec(new NullValue(), varType);

            if(this.typeErrorsNum > 0)
                return new NoType();
//            System.out.println("id : " + identifier.getLine() + " " + identifier.getName() + " " + varType.toString());
            return varType;
        } catch (ItemNotFoundException e) {
            VarNotDeclared exception = new VarNotDeclared(identifier.getLine(), identifier.getName());
            identifier.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(ArrayAccessByIndex arrayAccessByIndex) {
        //Todo
        Type instanceType = arrayAccessByIndex.getInstance().accept(this);
        boolean prevLValue = this.LValue;
        Type indexType = arrayAccessByIndex.getIndex().accept(this);
        this.LValue = prevLValue;
        if(!(indexType instanceof NoType) && !(indexType instanceof IntType)) {
            ArrayIndexNotInt exception = new ArrayIndexNotInt(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
//            return new NoType();
        }
        if(instanceType instanceof ArrayType){
            return ((ArrayType) instanceType).getType();
        }
        else if(!(instanceType instanceof NoType)) {
            AccessByIndexOnNoneArray exception = new AccessByIndexOnNoneArray(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(ObjectMemberAccess objectMemberAccess) {
        //Todo
        boolean prevLValue = this.LValue;
        Type instanceType = objectMemberAccess.getInstance().accept(this);
        if(objectMemberAccess.getInstance() instanceof SelfClass)
            this.LValue = prevLValue;
        String memberName = objectMemberAccess.getMemberName().getName();
        if(instanceType instanceof NoType)
            return new NoType();

        if(instanceType instanceof ClassType) {
            String className = ((ClassType) instanceType).getClassName().getName();

            SymbolTable classSymbolTable;
            try {
                classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true)).getClassSymbolTable();
            } catch (ItemNotFoundException classNotFound) {
                return new NoType();
            }
            ///////////////
            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem) classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + memberName, true);

                Type fieldtype = fieldSymbolTableItem.getType();
                this.typeErrorsNum = 0;
                if(fieldtype instanceof ArrayType)
                    this.checkArrayDec(new NullValue(), fieldtype);
                if(fieldtype instanceof ClassType)
                    this.checkClassDec(new NullValue(), ((ClassType) fieldtype).getClassName().getName());
                if(fieldtype instanceof FptrType)
                    this.checkFptrDec(new NullValue(), fieldtype);
                if(this.typeErrorsNum > 0)
                    return new NoType();
                return fieldtype;

            }
            catch (ItemNotFoundException memberNotField) {
                try {
                    MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + memberName, true);
                    this.LValue = true;
                    this.defaultArgsNum = 0;
                    for(ArgPair argPair : methodSymbolTableItem.getMethodDeclaration().getArgs()){
                        if (argPair.getDefaultValue() != null) {
                            this.defaultArgsNum += 1;
                        }
                    }
                    return new FptrType(methodSymbolTableItem.getArgTypes(), methodSymbolTableItem.getReturnType());
                } catch (ItemNotFoundException memberNotFound) {
                    if(memberName.equals(className)) {
                        this.LValue = true;
                        return new FptrType(new ArrayList<>(), new NullType());
                    }
                    MemberNotAvailableInClass exception = new MemberNotAvailableInClass(objectMemberAccess.getLine(), memberName, className);
                    objectMemberAccess.addError(exception);
                    return new NoType();
                }
            }
        }
        AccessOnNonClass exception = new AccessOnNonClass(objectMemberAccess.getLine());
        objectMemberAccess.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(SetNew setNew) {
        //Todo
        for(Expression expression : setNew.getArgs()){
            Type type = expression.accept(this);
            if(!(type instanceof IntType) && !(type instanceof NoType)){
                NewInputNotSet newInputNotSetException = new NewInputNotSet(setNew.getLine());
                setNew.addError(newInputNotSetException);
                return new NoType();
            }
        }
        return new SetType();
    }

    @Override
    public Type visit(SetInclude setInclude) {
        //Todo
        setInclude.getSetArg().accept(this);
        Type type = setInclude.getElementArg().accept(this);

//        System.out.println(setInclude.getElementArg().getLine());
//        System.out.println(type.toString());
//        System.out.println(setInclude.getElementArg().toString());
        if(!(type instanceof IntType) && !(type instanceof NoType)){
            SetIncludeInputNotInt setIncludeInputNotIntException = new SetIncludeInputNotInt(setInclude.getLine());
            setInclude.addError(setIncludeInputNotIntException);
            return new NoType();
        }
        return new BoolType();
    }

    @Override
    public Type visit(RangeExpression rangeExpression) {
        //Todo
//        System.out.println("range");
        ArrayList <Expression> arr = new ArrayList<>();
        ArrayType arrayType = new ArrayType(new IntType(), arr);
        Type leftExprType = rangeExpression.getLeftExpression().accept(this);
        Type rightExprType = rangeExpression.getRightExpression().accept(this);
        if(leftExprType instanceof NoType || rightExprType instanceof NoType)
            return new NoType();
        if(!(leftExprType instanceof IntType) || !(rightExprType instanceof IntType)){
            EachRangeNotInt eachRangeNotIntException = new EachRangeNotInt(rangeExpression.getLine());
            rangeExpression.addError(eachRangeNotIntException);
            return new NoType();
        }
        else
            return arrayType; ////////////////////////////////////////////////////
    }

    @Override
    public Type visit(TernaryExpression ternaryExpression) {
        //Todo
        Type conditionOperandType = ternaryExpression.getCondition().accept(this);
        if(!(conditionOperandType instanceof BoolType) && !(conditionOperandType instanceof NoType)){
            ConditionNotBool conditionNotBoolException = new ConditionNotBool(ternaryExpression.getLine());
            ternaryExpression.addError(conditionNotBoolException);
            return new NoType();
        }

        Type trueOperandType = ternaryExpression.getTrueExpression().accept(this);
        Type falseOperandType = ternaryExpression.getFalseExpression().accept(this);

        if(trueOperandType instanceof NoType || falseOperandType instanceof NoType)
            return new NoType();
        if(!(trueOperandType.toString().equals(falseOperandType.toString()))){
            UnsupportedOperandType unsupportedOperandTypeException = new UnsupportedOperandType(ternaryExpression.getLine(), TernaryOperator.ternary.name());
            ternaryExpression.addError(unsupportedOperandTypeException);
            return new NoType();
        }
        else {
            return trueOperandType;
        }
    }

    @Override
    public Type visit(IntValue intValue) {
        //Todo
        this.LValue = true;
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        //Todo
        this.LValue = true;
        return new BoolType();
    }

    @Override
    public Type visit(SelfClass selfClass) {
        //todo
        this.LValue = true;
        return new ClassType(this.currClassDec.getClassName());
    }

    @Override
    public Type visit(SetValue setValue) {
        //todo
        this.LValue = true;
        return new SetType();
    }

    @Override
    public Type visit(NullValue nullValue) {
        //todo
        this.LValue = true;
        return new NullType();
    }
}
