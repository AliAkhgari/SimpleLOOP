package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.compileError.CompileError;
import main.visitor.*;

import java.util.ArrayList;

public class ErrorAnnouncer extends Visitor<Integer> {

    private int errorsPrinter(Node node) {
        ArrayList<CompileError> errors = node.flushErrors();
        for (CompileError compileErrorExp : errors) {
            System.out.println(compileErrorExp.getMessage());
        }
        return errors.size();
    }

    @Override
    public Integer visit(Program program) {
        int errorsNum = errorsPrinter(program);
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables())
            errorsNum += variableDeclaration.accept(this);
        for (ClassDeclaration classDeclaration: program.getClasses())
            errorsNum += classDeclaration.accept(this);
        return errorsNum;
    }
    @Override
    public Integer visit(ClassDeclaration classDeclaration) {
        //todo //done
        int errorNum = errorsPrinter(classDeclaration);
        errorNum += classDeclaration.getClassName().accept(this);
        if(classDeclaration.getParentClassName() != null) {
            errorNum += classDeclaration.getParentClassName().accept(this);
        }
        for(FieldDeclaration fieldDec : classDeclaration.getFields()) {
            errorNum += fieldDec.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            errorNum += classDeclaration.getConstructor().accept(this);
        }
        for(MethodDeclaration methodDec : classDeclaration.getMethods()) {
            errorNum += methodDec.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(ConstructorDeclaration constructorDeclaration) {
        //todo //done
        int errorNum = errorsPrinter(constructorDeclaration);
        errorNum += constructorDeclaration.getMethodName().accept(this);
        for(VariableDeclaration variableDec : constructorDeclaration.getArgs()) {
            errorNum += variableDec.accept(this);
        }
        for(VariableDeclaration variableDec : constructorDeclaration.getLocalVars()) {
            errorNum += variableDec.accept(this);
        }
        for(Statement stmt : constructorDeclaration.getBody()) {
            errorNum += stmt.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(MethodDeclaration methodDeclaration) {
        //todo //done
        int errorNum = errorsPrinter(methodDeclaration);
        errorNum += methodDeclaration.getMethodName().accept(this);
        for(VariableDeclaration variableDeclaration : methodDeclaration.getArgs()) {
            errorNum += variableDeclaration.accept(this);
        }
        for(VariableDeclaration variableDeclaration : methodDeclaration.getLocalVars()) {
            errorNum += variableDeclaration.accept(this);
        }
        for(Statement stmt : methodDeclaration.getBody()) {
            errorNum += stmt.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(FieldDeclaration fieldDeclaration) {
        //todo //done
        int errorNum = errorsPrinter(fieldDeclaration);
        errorNum += fieldDeclaration.getVarDeclaration().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(VariableDeclaration varDeclaration) {
        //todo //done
        int errorNum = errorsPrinter(varDeclaration);
        errorNum += varDeclaration.getVarName().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(AssignmentStmt assignmentStmt) {
        //todo //done
        int errorNum = errorsPrinter(assignmentStmt);
        errorNum += assignmentStmt.getlValue().accept(this);
        errorNum += assignmentStmt.getrValue().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(BlockStmt blockStmt) {
        //todo //done
        int errorNum = errorsPrinter(blockStmt);
        for(Statement statement : blockStmt.getStatements()) {
            errorNum += statement.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(ConditionalStmt conditionalStmt) {
        //todo //done
        int errorNum = errorsPrinter(conditionalStmt);
        errorNum += conditionalStmt.getCondition().accept(this);
        errorNum += conditionalStmt.getThenBody().accept(this);
        for(ElsifStmt elseIfSmt : conditionalStmt.getElsif()){
            errorNum += elseIfSmt.accept(this);
        }
        if(conditionalStmt.getElseBody() != null) {
            errorNum += conditionalStmt.getElseBody().accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(ElsifStmt elsifStmt) {
        //todo //check
        int errorNum = errorsPrinter(elsifStmt);
        errorNum += elsifStmt.getCondition().accept(this);
        errorNum += elsifStmt.getThenBody().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(MethodCallStmt methodCallStmt) {
        //todo //done
        int errorNum = errorsPrinter(methodCallStmt);
        errorNum += methodCallStmt.getMethodCall().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(PrintStmt print) {
        //todo //done
        int errorNum = errorsPrinter(print);
        errorNum += print.getArg().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(ReturnStmt returnStmt) {
        //todo //done
        int errorNum = errorsPrinter(returnStmt);
        errorNum += returnStmt.getReturnedExpr().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(EachStmt eachStmt) {
        //todo //done
        int errorNum = errorsPrinter(eachStmt);
        errorNum += eachStmt.getVariable().accept(this);
        errorNum += eachStmt.getList().accept(this);
        errorNum += eachStmt.getBody().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(BinaryExpression binaryExpression) {
        //todo //done
        int errorNum = errorsPrinter(binaryExpression);
        errorNum += binaryExpression.getFirstOperand().accept(this);
        errorNum += binaryExpression.getSecondOperand().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(UnaryExpression unaryExpression) {
        //todo //done
        int errorNum = errorsPrinter(unaryExpression);
        errorNum += unaryExpression.getOperand().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(TernaryExpression ternaryExpression) {
        //todo //done
        int errorNum = errorsPrinter(ternaryExpression);
        errorNum += ternaryExpression.getCondition().accept(this);
        errorNum += ternaryExpression.getTrueExpression().accept(this);
        errorNum += ternaryExpression.getTrueExpression().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(ObjectMemberAccess objectOrListMemberAccess) {
        //todo //done
        int errorNum = errorsPrinter(objectOrListMemberAccess);
        errorNum += objectOrListMemberAccess.getInstance().accept(this);
        errorNum += objectOrListMemberAccess.getMemberName().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(Identifier identifier) {
        //todo //done
        int errorNum = errorsPrinter(identifier);
        return errorNum;
    }

    @Override
    public Integer visit(ArrayAccessByIndex arrayAccessByIndex) {
        //todo //done
        int errorNum = errorsPrinter(arrayAccessByIndex);
        errorNum += arrayAccessByIndex.getInstance().accept(this);
        errorNum += arrayAccessByIndex.getIndex().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(MethodCall methodCall) {
        //todo //done
        int errorNum = errorsPrinter(methodCall);
        errorNum += methodCall.getInstance().accept(this);
        for(Expression expression : methodCall.getArgs()) {
            errorNum += expression.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(NewClassInstance newClassInstance) {
        //todo //done
        int errorNum = errorsPrinter(newClassInstance);
        for(Expression expression : newClassInstance.getArgs()) {
            errorNum += expression.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(SelfClass selfClass) {
        //todo //done
        int errorNum = errorsPrinter(selfClass);
        return errorNum;
    }

    @Override
    public Integer visit(NullValue nullValue) {
        //todo //done
        int errorNum = errorsPrinter(nullValue);
        return errorNum;
    }

    @Override
    public Integer visit(IntValue intValue) {
        //todo //done
        int errorNum = errorsPrinter(intValue);
        return errorNum;
    }

    @Override
    public Integer visit(BoolValue boolValue) {
        //todo //done
        int errorNum = errorsPrinter(boolValue);
        return errorNum;
    }

    @Override
    public Integer visit(SetInclude setAdd) {
        //todo //check
        int errorNum = errorsPrinter(setAdd);
        errorNum += setAdd.getSetArg().accept(this);
        errorNum += setAdd.getElementArg().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(SetValue setValue) {
        //todo //check
        int errorNum = errorsPrinter(setValue);
        for(IntValue intVal : setValue.getElements()){
            errorNum += intVal.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(SetNew setMerge) {
        //todo //check
        int errorNum = errorsPrinter(setMerge);
        for(Expression expression : setMerge.getArgs()) {
            errorNum += expression.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(SetDelete setDelete) {
        //todo //check
        int errorNum = errorsPrinter(setDelete);
        errorNum += setDelete.getSetArg().accept(this);
        errorNum += setDelete.getElementArg().accept(this);
        return errorNum;
    }

    @Override
    public Integer visit(SetMerge setAdd) {
        //todo //check
        int errorNum = errorsPrinter(setAdd);
        errorNum += setAdd.getSetArg().accept(this);
        for(Expression expression : setAdd.getElementArgs()) {
            errorNum += expression.accept(this);
        }
        return errorNum;
    }

    @Override
    public Integer visit(RangeExpression rangeExpression) {
        //todo //done
        int errorNum = errorsPrinter(rangeExpression);
        errorNum += rangeExpression.getLeftExpression().accept(this);
        errorNum += rangeExpression.getRightExpression().accept(this);
        return errorNum;
    }
}

