package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.compileError.nameError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import main.symbolTable.utils.graph.Graph;
import main.symbolTable.utils.graph.exceptions.GraphDoesNotContainNodeException;
import main.symbolTable.utils.graph.exceptions.NodeAlreadyExistsException;
import main.visitor.Visitor;

public class NameAnalyzer {
    private Program program;
    private Graph<String> classGraph;

    public NameAnalyzer(Program program) {
        this.program = program;
    }

    public void analyze() {
        NameCreator collector = new NameCreator();
        this.program.accept(collector);
        this.inheritenceSymbolTables();
        NameInvestigator checker = new NameInvestigator(classGraph);
        this.program.accept(checker);
    }

    private void inheritenceSymbolTables() {
        Graph<String> classGraph = new Graph<>();
        for (ClassDeclaration classDec : this.program.getClasses()) {
            String className = classDec.getClassName().getName();
            try {
                classGraph.addNode(className);
            } catch (NodeAlreadyExistsException ignored) { }
            if (classDec.getParentClassName() == null)
                continue;
            String classParentName = classDec.getParentClassName().getName();
            try {
                classGraph.addNodeAsParentOf(className, classParentName);
                ClassSymbolTableItem symbolTableOfParent = (ClassSymbolTableItem) SymbolTable.root
                        .getItem(ClassSymbolTableItem.START_KEY + classParentName, true);
                ClassSymbolTableItem symbolTableOfCurr = (ClassSymbolTableItem) SymbolTable.root
                        .getItem(ClassSymbolTableItem.START_KEY + className, true);
                symbolTableOfCurr.getClassSymbolTable().pre = symbolTableOfParent.getClassSymbolTable();
            } catch (ItemNotFoundException | GraphDoesNotContainNodeException ignored) { }
        }
        this.classGraph = classGraph;
    }

}

class NameInvestigator extends Visitor<Void> {
    private String classCurrName;
    private Graph<String> classGraph;
    Program root;

    public NameInvestigator(Graph<String> classGraph) {
        this.classGraph = classGraph;
    }

    private SymbolTable getCurrentClassSymbolTable() {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + this.classCurrName, true);
            return classSymbolTableItem.getClassSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }

    @Override
    public Void visit(Program program) {
        this.root = program;
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.classCurrName = classDeclaration.getClassName().getName();
            classDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if(classDeclaration.getParentClassName() != null) {
            if (this.classGraph.isSecondNodeAncestorOf(classDeclaration.getParentClassName().getName(), classDeclaration.getClassName().getName())) {
                ClassInCyclicInheritance exception = new ClassInCyclicInheritance(classDeclaration.getLine(), classDeclaration.getClassName().getName());
                classDeclaration.addError(exception);
            }
        }
        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }
        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            methodDeclaration.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        if(!methodDeclaration.hasError()) {
            try {
                SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
                classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), false);
                MethodRedefinition exception = new MethodRedefinition(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
                methodDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored) {
            }
        }
        boolean not_errored = true;
        try {
            SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
            classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), true);
            MethodNameConflictWithField exception = new MethodNameConflictWithField(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
            methodDeclaration.addError(exception);
            not_errored = false;
        } catch (ItemNotFoundException ignored) {
        }
        if(not_errored)
            for(ClassDeclaration classDeclaration : root.getClasses()) {
                String childName = classDeclaration.getClassName().getName();
                if(classGraph.isSecondNodeAncestorOf(childName, classCurrName)) {
                    try {
                        ClassSymbolTableItem childSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + childName, true);
                        SymbolTable childSymbolTable = childSymbolTableItem.getClassSymbolTable();
                        childSymbolTable.getItem(FieldSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), true);
                        MethodNameConflictWithField exception = new MethodNameConflictWithField(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
                        methodDeclaration.addError(exception);
                        break;
                    } catch (ItemNotFoundException ignored) {
                    }
                }
            }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        if(!fieldDeclaration.hasError()) {
            try {
                SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
                classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + fieldDeclaration.getVarDeclaration().getVarName().getName(), false);
                FieldRedefinition exception = new FieldRedefinition(fieldDeclaration.getLine(), fieldDeclaration.getVarDeclaration().getVarName().getName());
                fieldDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored) {
            }
        }
        return null;
    }
}

class NameCreator extends Visitor<Void> {

    @Override
    public Void visit(Program program) {
        SymbolTable.push(new SymbolTable());
        SymbolTable.root = SymbolTable.top;
        for(VariableDeclaration variableDeclaration : program.getGlobalVariables()){

            try {
                SymbolTable.top.put(new GlobalVariableSymbolTableItem(variableDeclaration));
            } catch (ItemAlreadyExistsException e) {
                GlobalVarRedefinition exception = new GlobalVarRedefinition(variableDeclaration.getLine(), variableDeclaration.getVarName().getName());
                variableDeclaration.addError(exception);
            }
        }

        for(ClassDeclaration classDeclaration : program.getClasses()) {
            classDeclaration.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        ClassSymbolTableItem classSymbolTableItem = new ClassSymbolTableItem(classDeclaration);
        SymbolTable.push(new SymbolTable(SymbolTable.top));
        classSymbolTableItem.setClassSymbolTable(SymbolTable.top);
        try {
            SymbolTable.root.put(classSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            ClassRedefinition exception = new ClassRedefinition(classDeclaration.getLine(), classDeclaration.getClassName().getName());
            classDeclaration.addError(exception);
            exception.exceptionHandling(classDeclaration);
        }
        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }
        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            methodDeclaration.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        MethodSymbolTableItem methodSymbolTableItem = new MethodSymbolTableItem(methodDeclaration);
        SymbolTable methodSymbolTable = new SymbolTable(SymbolTable.top);
        methodSymbolTableItem.setMethodSymbolTable(methodSymbolTable);
        try {
            SymbolTable.top.put(methodSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            MethodRedefinition exception = new MethodRedefinition(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
            methodDeclaration.addError(exception);
        }
        SymbolTable.push(methodSymbolTable);
        for(VariableDeclaration varDeclaration : methodDeclaration.getArgs()) {
            varDeclaration.accept(this);
        }
        for(VariableDeclaration varDeclaration : methodDeclaration.getLocalVars()) {
            varDeclaration.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        try {
            SymbolTable.top.put(new FieldSymbolTableItem(fieldDeclaration));
        } catch (ItemAlreadyExistsException e) {
            FieldRedefinition exception = new FieldRedefinition(fieldDeclaration.getLine(), fieldDeclaration.getVarDeclaration().getVarName().getName());
            fieldDeclaration.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {

        try {
            SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + varDeclaration.getVarName().getName(), true);
            LocalVarConflictWithGlobalVar exception = new LocalVarConflictWithGlobalVar(varDeclaration.getLine(), varDeclaration.getVarName().getName());
            varDeclaration.addError(exception);
        } catch (ItemNotFoundException ignored) {
            try {
                SymbolTable.top.put(new LocalVariableSymbolTableItem(varDeclaration));
            } catch (ItemAlreadyExistsException i) {
                LocalVarRedefinition exception = new LocalVarRedefinition(varDeclaration.getLine(), varDeclaration.getVarName().getName());
                varDeclaration.addError(exception);
            }
        }
        return null;
    }

}
