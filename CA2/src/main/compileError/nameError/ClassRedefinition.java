package main.compileError.nameError;

import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.compileError.CompileError;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.ClassSymbolTableItem;

public class ClassRedefinition extends CompileError {
    public ClassRedefinition(int line, String className) {
        super(line, "Redefinition of class " + className);
    }

    public void exceptionHandling(ClassDeclaration classDeclaration) {
        String newName = classDeclaration.getClassName().getName() + "_";
        classDeclaration.getClassName().setName(newName);
        ClassSymbolTableItem symbolTableItem = new ClassSymbolTableItem(classDeclaration);
        symbolTableItem.setClassSymbolTable(SymbolTable.top);
        try {
            SymbolTable.root.put(symbolTableItem);
        } catch (ItemAlreadyExistsException exception) {
            this.exceptionHandling(classDeclaration);
        }
    }
}