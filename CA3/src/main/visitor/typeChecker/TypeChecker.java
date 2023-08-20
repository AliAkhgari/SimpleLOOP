package main.visitor.typeChecker;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
//import main.ast.nodes.expression.values.NullValue;
//import main.ast.nodes.expression.values.SetValue;
//import main.ast.nodes.expression.values.primitive.*;
import main.ast.types.array.ArrayType;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.ast.types.NoType;
//import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
//import main.symbolTable.SymbolTable;
//import main.symbolTable.exceptions.ItemNotFoundException;
//import main.symbolTable.items.ClassSymbolTableItem;
//import main.symbolTable.items.LocalVariableSymbolTableItem;
//import main.symbolTable.items.MethodSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.*;

import java.util.ArrayList;
//import java.util.Set;


public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    ExpressionTypeChecker expressionTypeChecker;

    private ClassDeclaration classDec;
    private MethodDeclaration currMethodDec;

//    private boolean doesReturn = false;
//    private boolean conditionReturn = false;
//    private boolean blockReturn = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    @Override
    public Void visit(Program program) {
        // noMainClassEception
        //todo
        boolean isMainClassExists = false;
        for(ClassDeclaration classDec : program.getClasses()){
            this.classDec = classDec;
            this.expressionTypeChecker.currClassDec = classDec;

            classDec.accept(this);
            if(classDec.getClassName().getName().equals("Main"))
                isMainClassExists = true;
        }

        if(!isMainClassExists){
            NoMainClass noMainClassEception = new NoMainClass();
            program.addError(noMainClassEception);
        }

        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        // NoConstructorInMainClass , CannotExtendFromMainClass , MainClassCantInherit
        //todo
        if(classDeclaration.getParentClassName() != null){
            this.expressionTypeChecker.checkClassDec(classDeclaration, classDeclaration.getParentClassName().getName());
        }
        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields())
            fieldDeclaration.accept(this);
        if (classDeclaration.getConstructor() != null) {
            this.expressionTypeChecker.currMethodDec = classDeclaration.getConstructor();
            this.currMethodDec = classDeclaration.getConstructor();
            classDeclaration.getConstructor().accept(this);
        }
        for (MethodDeclaration methodDeclaration : classDeclaration.getMethods()){
            this.expressionTypeChecker.currMethodDec = methodDeclaration;
            this.currMethodDec = methodDeclaration;
            methodDeclaration.accept(this);
        }

        if(classDeclaration.getConstructor() == null && classDeclaration.getClassName().getName().equals("Main")){
            NoConstructorInMainClass noConstructorInMainClassException = new NoConstructorInMainClass(classDeclaration);
            classDeclaration.addError(noConstructorInMainClassException);
        }
        if(classDeclaration.getParentClassName() != null && classDeclaration.getParentClassName().getName().equals("Main")){
            CannotExtendFromMainClass cannotExtendFromMainClass = new CannotExtendFromMainClass(classDeclaration.getLine());
            classDeclaration.addError(cannotExtendFromMainClass);
        }
        if(classDeclaration.getParentClassName() != null && classDeclaration.getClassName().getName().equals("Main")){
            MainClassCantInherit mainClassCantInherit = new MainClassCantInherit(classDeclaration.getLine());
            classDeclaration.addError(mainClassCantInherit);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        // MainConstructorCantHaveArgs
        //todo
        if(this.classDec.getClassName().getName().equals("Main") && constructorDeclaration.getArgs().size() > 0){
            MainConstructorCantHaveArgs mainConstructorCantHaveArgsException = new MainConstructorCantHaveArgs(constructorDeclaration.getLine());
            constructorDeclaration.addError(mainConstructorCantHaveArgsException);
        }
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        this.expressionTypeChecker.doesReturn = false;
        // UnsupportedOperandType , UnreachableStatements , MissingReturnStatement , VoidMethodHasReturn
        //todo
//        System.out.println("llllll : "+methodDeclaration.getLine() + "  " + methodDeclaration.getReturnType());
        if(methodDeclaration.getReturnType() instanceof ClassType) {
            this.expressionTypeChecker.checkClassDec(methodDeclaration,
                    ((ClassType) methodDeclaration.getReturnType()).getClassName().getName());
        }
        if(methodDeclaration.getReturnType() instanceof ArrayType){
            this.expressionTypeChecker.checkArrayDec(methodDeclaration, methodDeclaration.getReturnType());
        }
        if(methodDeclaration.getReturnType() instanceof FptrType){
            this.expressionTypeChecker.checkFptrDec(methodDeclaration, methodDeclaration.getReturnType());
        }

        for(VariableDeclaration variableDeclaration : methodDeclaration.getLocalVars()) {
            variableDeclaration.accept(this);
        }

        for(ArgPair argPair : methodDeclaration.getArgs()) {
            argPair.getVariableDeclaration().accept(this);
            if (argPair.getDefaultValue() != null) {
                Type defaultValueType = argPair.getDefaultValue().accept(this.expressionTypeChecker);
                Type varDecType = argPair.getVariableDeclaration().getType();
//                System.out.println(varDecType.toString());
//                System.out.println(defaultValueType.toString());

                if (!(defaultValueType instanceof NoType) && !(defaultValueType.toString().equals(varDecType.toString()))) {
                    UnsupportedOperandType unsupportedOperandTypeException = new UnsupportedOperandType(methodDeclaration.getLine(), BinaryOperator.assign.name());
                    methodDeclaration.addError(unsupportedOperandTypeException);
                }
            }
        }

        for(Statement statement : methodDeclaration.getBody()){
//            System.out.println("acc stmt : " + statement.toString() + "  "+ statement.getLine());
//            System.out.println(this.expressionTypeChecker.doesReturn);
            if(this.expressionTypeChecker.doesReturn || this.expressionTypeChecker.conditionReturn){
                UnreachableStatements unreachableStatementsException = new UnreachableStatements(statement);
                methodDeclaration.addError(unreachableStatementsException);

                this.expressionTypeChecker.conditionReturn = false;
                break;
            }
            statement.accept(this);
            if(statement instanceof ReturnStmt)
                this.expressionTypeChecker.doesReturn = true;

        }

        if(this.expressionTypeChecker.doesReturn || this.expressionTypeChecker.conditionReturn || this.expressionTypeChecker.blockReturn)
            methodDeclaration.setDoesReturn(true);
        Type methodReturnType = methodDeclaration.getReturnType();

//        System.out.println(methodDeclaration.getMethodName());
//        System.out.println(methodDeclaration.getDoesReturn());
//        System.out.println(methodReturnType);
        if(!(methodReturnType instanceof VoidType) && !(methodDeclaration.getDoesReturn()) && !(methodDeclaration instanceof ConstructorDeclaration)){
            MissingReturnStatement missingReturnStatementException = new MissingReturnStatement(methodDeclaration);
            methodDeclaration.addError(missingReturnStatementException);
        }
        if(methodReturnType instanceof VoidType && methodDeclaration.getDoesReturn()){
            VoidMethodHasReturn voidMethodHasReturnException = new VoidMethodHasReturn(methodDeclaration);
            methodDeclaration.addError(voidMethodHasReturnException);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        //todo
//        System.out.println( "field  : " + fieldDeclaration.getLine() + " " + fieldDeclaration.getVarDeclaration().getVarName().getName() + "  " + fieldDeclaration.getVarDeclaration().getType());
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        //todo
        if(varDeclaration.getType() instanceof ArrayType) {
            this.expressionTypeChecker.checkArrayDec(varDeclaration, varDeclaration.getType());
        }

        if(varDeclaration.getType() instanceof ClassType) {
            this.expressionTypeChecker.checkClassDec(varDeclaration,
                    ((ClassType) varDeclaration.getType()).getClassName().getName());
        }
        if(varDeclaration.getType() instanceof FptrType){
            this.expressionTypeChecker.checkFptrDec(varDeclaration, varDeclaration.getType());
        }
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //todo
        Type leftType = assignmentStmt.getlValue().accept(this.expressionTypeChecker);
        Type rightType = assignmentStmt.getrValue().accept(this.expressionTypeChecker);
//        System.out.println(firstType);
//        System.out.println(rightType);
//        System.out.println("assign : " + assignmentStmt.getLine() + "  " + leftType.toString() + "  " + rightType.toString());
        boolean isLeftLvalue = this.expressionTypeChecker.isLvalue(assignmentStmt.getlValue());
        if(!isLeftLvalue) {
            LeftSideNotLvalue exception = new LeftSideNotLvalue(assignmentStmt.getLine());
            assignmentStmt.addError(exception);
        }

        if(leftType instanceof NoType) {
            return null;
        }

        boolean isSubtype = this.expressionTypeChecker.isLeftSubTypeOfRight(rightType, leftType);
        if(!isSubtype) {
            UnsupportedOperandType exception = new UnsupportedOperandType(assignmentStmt.getLine(), BinaryOperator.assign.name());
            assignmentStmt.addError(exception);
            return null;
        }
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        //todo
//        boolean doesReturn = false;
//        boolean prevDoesReturn = false;
        this.expressionTypeChecker.blockReturn = false;
        for(Statement statement : blockStmt.getStatements()){
            if(this.expressionTypeChecker.blockReturn){
                UnreachableStatements unreachableStatementsException = new UnreachableStatements(statement);
                blockStmt.addError(unreachableStatementsException);
//                this.doesReturn = false;
//                this.conditionReturn = false;
                break;
            }
            statement.accept(this);
            if(statement instanceof ReturnStmt) {
                this.expressionTypeChecker.blockReturn = true;
            }
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //todo
        this.expressionTypeChecker.conditionReturn = false;
        Type conditionType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(conditionType instanceof BoolType) && !(conditionType instanceof NoType)){
            ConditionNotBool conditionNotBoolException = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(conditionNotBoolException);
        }
        if(conditionalStmt.getThenBody() instanceof ReturnStmt)
            this.expressionTypeChecker.conditionReturn = true;
        else if(conditionalStmt.getThenBody() instanceof BlockStmt) {
            boolean doesBlockReturn = false;
            for(Statement statement : ((BlockStmt) conditionalStmt.getThenBody()).getStatements())
                if(statement instanceof ReturnStmt)
                    doesBlockReturn = true;
            if(doesBlockReturn == true)
                this.expressionTypeChecker.conditionReturn = true;
        }
        else
            this.expressionTypeChecker.conditionReturn = false;
        conditionalStmt.getThenBody().accept(this);

        for(ElsifStmt elsifStmt : conditionalStmt.getElsif()){
            elsifStmt.accept(this);
        }

        if(conditionalStmt.getElseBody() != null) {

            if(!(conditionalStmt.getElseBody() instanceof ReturnStmt)) {
                if(conditionalStmt.getElseBody() instanceof BlockStmt){
                    boolean doesBlockReturn = false;
                    for(Statement statement : ((BlockStmt) conditionalStmt.getElseBody()).getStatements())
                        if(statement instanceof ReturnStmt)
                            doesBlockReturn = true;
                    if(doesBlockReturn == false)
                        this.expressionTypeChecker.conditionReturn = false;
                }
                else
                    this.expressionTypeChecker.conditionReturn = false;
            }
            conditionalStmt.getElseBody().accept(this);
        }
        else
            this.expressionTypeChecker.conditionReturn = false;

        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        //todo
//        System.out.println("ggggg");
        Type elsifConditionType = elsifStmt.getCondition().accept(expressionTypeChecker);
        if(!(elsifConditionType instanceof BoolType) && !(elsifConditionType instanceof NoType)){
            ConditionNotBool conditionNotBoolException = new ConditionNotBool(elsifStmt.getLine());
            elsifStmt.addError(conditionNotBoolException);
        }
        if(!(elsifStmt.getThenBody() instanceof ReturnStmt)) {
            if(elsifStmt.getThenBody() instanceof BlockStmt){
                boolean doesBlockReturn = false;
                for(Statement statement : ((BlockStmt) elsifStmt.getThenBody()).getStatements())
                    if(statement instanceof ReturnStmt)
                        doesBlockReturn = true;
                if(doesBlockReturn == false)
                    this.expressionTypeChecker.conditionReturn = false;
            }
            else
                this.expressionTypeChecker.conditionReturn = false;
        }

        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        //todo
        this.expressionTypeChecker.isInMethodCall = true;
        methodCallStmt.getMethodCall().accept(expressionTypeChecker);
        this.expressionTypeChecker.isInMethodCall = false;
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof IntType || argType instanceof ArrayType || argType instanceof SetType ||
                argType instanceof BoolType || argType instanceof NoType)) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //todo
        Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        Type currentMethodReturnType = this.currMethodDec.getReturnType();
//        System.out.println(returnType.toString()+"  "+ returnStmt.getLine() + "   " + currentMethodReturnType.toString());
        if(!expressionTypeChecker.isLeftSubTypeOfRight(returnType, currentMethodReturnType)){
            ReturnValueNotMatchMethodReturnType returnValueNotMatchMethodReturnTypeException = new ReturnValueNotMatchMethodReturnType(returnStmt);
            returnStmt.addError(returnValueNotMatchMethodReturnTypeException);
        }
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        //todo
        Type listType = eachStmt.getList().accept(this.expressionTypeChecker);
        Type varType = eachStmt.getVariable().accept(this.expressionTypeChecker);

        if(!(listType instanceof ArrayType) && !(listType instanceof NoType)){
            EachCantIterateNoneArray eachCantIterateNoneArrayException = new EachCantIterateNoneArray(eachStmt.getLine());
            eachStmt.addError(eachCantIterateNoneArrayException);
            return null;
        }

        if(listType instanceof ArrayType) {
            Type listElementType = ((ArrayType) listType).getType();
            if(!(varType.toString().equals(listElementType.toString()))){
                EachVarNotMatchList eachVarNotMatchListException = new EachVarNotMatchList(eachStmt);
                eachStmt.addError(eachVarNotMatchListException);
            }
        }

//        System.out.println("body accept " + eachStmt.getBody().getLine());
//        System.out.println(eachStmt.getBody().toString());
//                this.eachReturn = false;
        eachStmt.getBody().accept(this);
        if(eachStmt.getBody() instanceof ReturnStmt) {
            this.expressionTypeChecker.doesReturn = true;
        }
        else {
            if(eachStmt.getBody() instanceof BlockStmt){
                boolean doesBlockReturn = false;
                for(Statement statement : ((BlockStmt) eachStmt.getBody()).getStatements())
                    if(statement instanceof ReturnStmt)
                        doesBlockReturn = true;
                if(doesBlockReturn == true)
                    this.expressionTypeChecker.doesReturn = true;
            }
            else
                this.expressionTypeChecker.doesReturn = false;
        }


        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        //todo
        setDelete.getSetArg().accept(this.expressionTypeChecker);
        setDelete.getElementArg().accept(this.expressionTypeChecker);
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        //todo
        boolean hasError = false;
        if(setMerge.getElementArgs().size() == 1) {
            Type type = setMerge.getElementArgs().get(0).accept(this.expressionTypeChecker);
            if(!(type instanceof IntType) && !(type instanceof NoType) && !(type instanceof SetType)){
                MergeInputNotSet mergeInputNotSetException = new MergeInputNotSet(setMerge.getLine());
                setMerge.addError(mergeInputNotSetException);
            }
        }
        else {
            for (Expression expression : setMerge.getElementArgs()) {
                Type type = expression.accept(this.expressionTypeChecker);

                if (!(type instanceof IntType) && !(type instanceof NoType)) {
                    MergeInputNotSet mergeInputNotSetException = new MergeInputNotSet(setMerge.getLine());
                    setMerge.addError(mergeInputNotSetException);
                    hasError = true;
                }

            }
        }
        if(hasError)
            return null;
        setMerge.getSetArg().accept(this.expressionTypeChecker);
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        //todo
        setAdd.getSetArg().accept(this.expressionTypeChecker);
        Type type = setAdd.getElementArg().accept(this.expressionTypeChecker);
        if(!(type instanceof IntType) && !(type instanceof NoType)){
            AddInputNotInt addInputNotIntException = new AddInputNotInt(setAdd.getLine());
            setAdd.addError(addInputNotIntException);
        }
        return null;
    }

}
