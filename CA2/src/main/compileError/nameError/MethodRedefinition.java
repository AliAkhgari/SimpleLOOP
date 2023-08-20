package main.compileError.nameError;

import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.compileError.CompileError;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;

public class MethodRedefinition extends CompileError {
    public MethodRedefinition(int line, String methodName) {
        super(line, "Redefinition of method " + methodName);
    }
}
