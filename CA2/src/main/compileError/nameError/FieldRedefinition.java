package main.compileError.nameError;

import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.compileError.CompileError;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;

public class FieldRedefinition extends CompileError {
    public FieldRedefinition(int line, String fieldName) {
        super(line, "Redefinition of field " + fieldName);
    }
}