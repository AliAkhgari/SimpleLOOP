package main.visitor.codeGenerator;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.EachStmt;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.visitor.typeChecker.ExpressionTypeChecker;

import java.io.*;
import java.util.ArrayList;

public class CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker;
    Graph<String> classHierarchy;
    private String outputPath;
    private FileWriter currentFile;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private Integer labelCount = 0;
    private int last_slot = 0;
    private ArrayList <VariableDeclaration> globals = new ArrayList<>();

    public CodeGenerator(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
        this.prepareOutputFolder();
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String arrayClassPath = "utilities/codeGenerationUtilityClasses/Array.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(arrayClassPath, this.outputPath + "Array.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            this.currentFile = fileWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String id) { //
        int cnt = 1;
        for(ArgPair argPair: currentMethod.getArgs()){
            if(argPair.getVariableDeclaration().getVarName().getName().equals(id))
                return cnt;
            cnt++;
        }
        for(VariableDeclaration variableDeclaration: currentMethod.getLocalVars()){
            if(variableDeclaration.getVarName().getName().equals(id))
                return cnt;
            cnt++;
        }
        if(id.equals("")){
            if(this.last_slot == 0)
                this.last_slot = cnt;
            else
                this.last_slot++;
        }
        return this.last_slot;
    }

    private String defnieTypeSignature(Type t) { //
        String typeString = "";
        if (t instanceof IntType)
            typeString += "Ljava/lang/Integer;";
        else if (t instanceof BoolType)
            typeString += "Ljava/lang/Boolean;";
        else if (t instanceof FptrType)
            typeString += "LFptr;";
        else if (t instanceof ArrayType)
            typeString += "LArray;";
        else if (t instanceof ClassType)
            typeString += "L" + ((ClassType) t).getClassName().getName() + ";";
        else
            typeString += "V";
        return typeString;
    }

    private String init(Type t) { //
        String command = "";
        if (t instanceof IntType) {
            command += "ldc 0\n";
            command += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        } else if (t instanceof BoolType) {
            command += "ldc 0\n";
            command += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        } else if (t instanceof ClassType || t instanceof FptrType)
            command += "aconst_null\n";
        else if (t instanceof ArrayType) {
            command += "new Array\ndup\nnew java/util/ArrayList\ndup\ninvokespecial java/util/ArrayList/<init>()V\n";
            for(Expression e : ((ArrayType) t).getDimensions()) {
                command += "new Array\n";
                command += ("dup\n");
                command += e.accept(this) + "\n";
            }
            command += init(((ArrayType) t).getType());
            for(int i = 0; i < ((ArrayType) t).getDimensions().size(); i++){
                command += ("invokespecial Array/<init>(ILjava/lang/Object;)V\n");
            }
        }
        return command;
    }

    private String generateLabel(){
        labelCount += 1;
        return "Label" + labelCount;
    }

    private void addDefaultConstructor() { //
        String command = ".method public <init>()V\n.limit stack 128\n.limit locals 128\naload 0\ninvokespecial ";
        if(this.currentClass.getParentClassName() == null)
            command += "java/lang/Object/<init>()V\n";
        else
            command += currentClass.getParentClassName().getName() + "/<init>()V\n";
        for(FieldDeclaration field: currentClass.getFields()){
            command += "aload 0\n";
            Type t = field.getVarDeclaration().getType();
            command += init(t);
            command += "putfield " + currentClass.getClassName().getName() + "/" + field.getVarDeclaration().getVarName().getName() + " " + defnieTypeSignature(t) + "\n";
        }
        command += "return\n.end method";
        addCommand(command);
    }

    public void addDefaultConstructor(ClassDeclaration globalClassDec) {
        String command = ".method public <init>()V\n.limit stack 128\n.limit locals 128\naload 0\ninvokespecial ";
        command += "java/lang/Object/<init>()V\n";

        for(FieldDeclaration field: globalClassDec.getFields()){
            command += "aload_0\n";
            Type t = field.getVarDeclaration().getType();
            command += init(t);
            command += "putstatic " + globalClassDec.getClassName().getName() + "/" + field.getVarDeclaration().getVarName().getName() + " " + defnieTypeSignature(t) + "\n";
        }
        command += "return\n.end method";
        addCommand(command);
    }

    private String convertToPremitive(Type type) { //
        if (type instanceof IntType)
            return "invokevirtual java/lang/Integer/intValue()I\n";
        else
            return "invokevirtual java/lang/Boolean/booleanValue()Z\n";
    }

    @Override
    public String visit(Program program) {
        //todo
        //generate new class for global variables
        //using .field, add global variables as static fields to the class
        if(program.getGlobalVariables().size() > 0) {
            String globalClassName = "Global";
            createFile(globalClassName);
            addCommand(".class public " + globalClassName);
            addCommand(".super java/lang/Object");
            ClassDeclaration classDeclaration = new ClassDeclaration(new Identifier(globalClassName));
            for (VariableDeclaration variableDeclaration : program.getGlobalVariables()) {
                this.globals.add(variableDeclaration);
                addCommand(".field static " + variableDeclaration.getVarName().getName() + " " + defnieTypeSignature(variableDeclaration.getType()) + "\n");
                classDeclaration.addField(new FieldDeclaration(variableDeclaration, false));
            }
            addDefaultConstructor(classDeclaration);
        }

        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ClassDeclaration classDeclaration) {
        String name = classDeclaration.getClassName().getName();
        createFile(name);
        //todo
        addCommand(".class public " + classDeclaration.getClassName().getName());
        if(classDeclaration.getParentClassName() == null)
            addCommand(".super java/lang/Object");
        else
            addCommand(".super " + classDeclaration.getParentClassName().getName());
        for(FieldDeclaration field: classDeclaration.getFields()){
            field.accept(this);
        }
        if(classDeclaration.getConstructor() == null)
            addDefaultConstructor();
        else{
            this.last_slot = 0;
            currentMethod = classDeclaration.getConstructor();
            expressionTypeChecker.setCurrentMethod(currentMethod);
            classDeclaration.getConstructor().accept(this);
        }
        for(MethodDeclaration method: classDeclaration.getMethods()) {
            this.last_slot = 0;
            currentMethod = method;
            expressionTypeChecker.setCurrentMethod(currentMethod);
            method.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ConstructorDeclaration constructorDeclaration) {
        //todo
        if(this.currentClass.getClassName().getName().equals("Main"))
            addStaticMainMethod();
        if(constructorDeclaration.getArgs().size() != 0)
            addDefaultConstructor();
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    ///////////////////////////////////////

    @Override
    public String visit(MethodDeclaration methodDeclaration) {
        //todo
        String commands = ".method public ";
        String args = "";
        String locals = ".limit stack 128\n.limit locals 128\n";
        for(ArgPair var: methodDeclaration.getArgs()) {
            args += defnieTypeSignature(var.getVariableDeclaration().getType());
        }
        if(methodDeclaration instanceof ConstructorDeclaration) {
            commands += "<init>(";
            commands += args;
            commands += ")V\n";
            commands += locals;
            commands += "aload 0\ninvokespecial ";
            if(this.currentClass.getParentClassName() == null)
                commands += "java/lang/Object/<init>()V\n";
            else
                commands += currentClass.getParentClassName().getName() + "/<init>()V\n";

            for(FieldDeclaration field: currentClass.getFields()){
                commands += "aload 0\n";
                Type t = field.getVarDeclaration().getType();
                commands += init(t);
                commands += "putfield " + currentClass.getClassName().getName() + "/" + field.getVarDeclaration().getVarName().getName() + " " + defnieTypeSignature(t) + "\n";
            }
        }
        else {
            commands += methodDeclaration.getMethodName().getName() + "(" + args + ")" + defnieTypeSignature(methodDeclaration.getReturnType()) + "\n" + locals;
        }
        addCommand(commands);
        commands = "";
        for(VariableDeclaration var: methodDeclaration.getLocalVars()){
            var.accept(this);
        }
        addCommand(commands);
        commands = "";
        for(Statement stmt: methodDeclaration.getBody())
            stmt.accept(this);
        if(!currentMethod.getDoesReturn())
            commands += "return\n";
        commands += ".end method";
        addCommand(commands);
        return null;
    }

    @Override
    public String visit(FieldDeclaration fieldDeclaration) {
        //todo
        String command = "";
        command += ".field ";
        command += fieldDeclaration.getVarDeclaration().getVarName().getName() + ' ';
        command += defnieTypeSignature(fieldDeclaration.getVarDeclaration().getType());
        addCommand(command);
        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        //todo
        addCommand(init(variableDeclaration.getType()));
        int slot = slotOf(variableDeclaration.getVarName().getName());
        boolean isGlobal = false;
        addCommand(";varDec\n");
        for(VariableDeclaration var : this.globals){
            if(variableDeclaration.getVarName().getName().equals(var.getVarName().getName())){
                addCommand("putstatic " + "Global" + "/" + variableDeclaration.getVarName().getName() + " " + defnieTypeSignature(variableDeclaration.getType()) + "\n");
                isGlobal = true;
            }
        }
        if (isGlobal == false)
            addCommand("astore "+slot);
        addCommand(";end varDec\n");
        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        //todo
        BinaryExpression assignExpr = new BinaryExpression(assignmentStmt.getlValue(),
                                            assignmentStmt.getrValue(), BinaryOperator.assign);
        addCommand(assignExpr.accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {
        //todo
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        //todo
        Expression condition = conditionalStmt.getCondition();
        Statement ifBody = conditionalStmt.getThenBody();
        ArrayList <String> elsifLabels = new ArrayList<>();
        for(ElsifStmt elsifStmt : conditionalStmt.getElsif()){
            elsifLabels.add(generateLabel());
        }
        Statement elseBody = conditionalStmt.getElseBody();
        String Else = generateLabel();
        String After = generateLabel();
        addCommand(condition.accept(this));

        if(conditionalStmt.getElsif().size() == 0){
            addCommand("ifeq " + Else);
            if(ifBody != null)
                ifBody.accept(this);
            addCommand("goto "+After);
        }
        for(int i = 0; i < elsifLabels.size(); i++) {
            if(i == 0){
                addCommand("ifeq " + elsifLabels.get(i));
                if(ifBody != null)
                    ifBody.accept(this);
                addCommand("goto "+After);
            }
            addCommand(elsifLabels.get(i) + ":");

            conditionalStmt.getElsif().get(i).accept(this);
            if(i == elsifLabels.size()-1)
                addCommand("ifeq " + Else);
            else
                addCommand("ifeq " + elsifLabels.get(i+1));
            Statement elsifBody = conditionalStmt.getElsif().get(i).getThenBody();
            if (elsifBody != null) {
                elsifBody.accept(this);
            }
            addCommand("goto "+After);
        }

        addCommand(Else +":");
        if(elseBody != null)
            elseBody.accept(this);
        addCommand(After+":");
        return null;
    }

    @Override
    public String visit(ElsifStmt elsifStmt) {
        //todo
        addCommand(elsifStmt.getCondition().accept(this));
        return null;
    }

    @Override
    public String visit(MethodCallStmt methodCallStmt) {
        //todo
        this.expressionTypeChecker.setIsInMethodCallStmt(true);
        addCommand(methodCallStmt.getMethodCall().accept(this));
        this.expressionTypeChecker.setIsInMethodCallStmt(false);
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(PrintStmt print) {
        //todo
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        addCommand(print.getArg().accept(this));
        Type t = print.getArg().accept(expressionTypeChecker);
        String arg;
        if(t instanceof IntType)
            arg = "I";
        else if(t instanceof BoolType)
            arg = "Z";
        else
            arg = "Ljava/lang/String;";
        addCommand("invokevirtual java/io/PrintStream/println(" + arg + ")V");
        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        //todo
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(type instanceof NullType)
            addCommand("return");
        else {
            addCommand(returnStmt.getReturnedExpr().accept(this));
            if(type instanceof IntType)
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            else if(type instanceof BoolType)
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            addCommand("areturn");
        }
        return null;
    }

    ////////////////////////////
    @Override
    public String visit(EachStmt eachStmt) {
        //todo
        String loopStartLabel = generateLabel();
        String loopExitLabel = generateLabel();
        int tempVar = slotOf("");
        int forVarSlot = slotOf(eachStmt.getVariable().getName());
        String listCommands = eachStmt.getList().accept(this);

        addCommand("ldc 0");
        addCommand("istore " + tempVar);

        addCommand(loopStartLabel + ":");
        addCommand("iload " + tempVar);
        addCommand(listCommands);
        addCommand("getfield Array/elements Ljava/util/ArrayList;");
        addCommand("invokevirtual java/util/ArrayList/size()I");
        addCommand("if_icmpge " + loopExitLabel);

        addCommand(listCommands);
        addCommand("iload " + tempVar);
        addCommand("invokevirtual Array/getElement(I)Ljava/lang/Object;");
        Type varType = eachStmt.getVariable().accept(expressionTypeChecker);
        addCommand("checkcast " + getTypeClass(varType));

        addCommand(";each");
        boolean isGlobal = false;
        for(VariableDeclaration var : this.globals){
            if(eachStmt.getVariable().getName().equals(var.getVarName().getName())){
                addCommand("putstatic " + "Global" + "/" + eachStmt.getVariable().getName() + " " + defnieTypeSignature(eachStmt.getVariable().accept(expressionTypeChecker)) + "\n");
                isGlobal = true;
            }
        }
        if (isGlobal == false)
            addCommand("astore " + forVarSlot);
        addCommand(";end each");

        addCommand("iinc " + tempVar + " 1");

        eachStmt.getBody().accept(this);
        addCommand("goto " + loopStartLabel);
        addCommand(loopExitLabel + ":");
        return null;
    }

    @Override
    public String visit(TernaryExpression ternaryExpression) {
        //todo
        String commands = "";
        Expression condition = ternaryExpression.getCondition();
        Expression trueExpression = ternaryExpression.getTrueExpression();
        Expression falseExpression = ternaryExpression.getFalseExpression();
        String Else = generateLabel();
        String After = generateLabel();
        commands += (condition.accept(this)) + "\n";
        commands += ("ifeq "+Else + "\n");
        if(trueExpression != null) {
            commands += trueExpression.accept(this) + "\n";
        }
        commands += ("goto "+After+"\n");
        commands += (Else +":\n");
        if(falseExpression != null) {
            commands += falseExpression.accept(this) +"\n";
        }
        commands += (After+":") + "\n";
        return commands;
    }

    @Override
    public String visit(RangeExpression rangeExpression) {
        //todo
        String commands = "";
        Expression leftExpr =  rangeExpression.getLeftExpression();
        Expression rightExpr = rangeExpression.getRightExpression();
        commands += "new Array\n";
        commands += "dup\n";
        if(leftExpr != null){
            commands += leftExpr.accept(this);
        }
        if(rightExpr != null) {
            commands += rightExpr.accept(this);
        }
        commands += "invokespecial Array/<init>(II)V\n";
        return commands;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        //todo
        String commands = "";
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        if (operator == BinaryOperator.add) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "iadd\n";
        }
        else if (operator == BinaryOperator.sub) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "isub\n";
        }
        else if (operator == BinaryOperator.mult) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "imul\n";
        }
        else if (operator == BinaryOperator.div) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "idiv\n";
        }
        else if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            String label1 = generateLabel();
            if(operator == BinaryOperator.gt)
                commands += "if_icmple ";
            else
                commands += "if_icmpge ";
            commands += label1 + "\n";
            commands += "ldc 1\n";
            String end = generateLabel();
            commands += "goto " + end + "\n" + label1 + ":\n";
            commands += "ldc 0 \n";
            commands += end + ":\n";
        }

        else if(operator == BinaryOperator.eq) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            Type t = binaryExpression.getFirstOperand().accept(this.expressionTypeChecker);
            String Else = generateLabel();
            String After = generateLabel();
            if (t instanceof IntType || t instanceof BoolType) {
                commands += "if_icmpeq " + Else + "\n";
            }
            else {
                commands += "if_acmpeq " + Else + "\n";
            }
            commands += "ldc 0\n";
            commands += "goto " + After + "\n";
            commands += Else + ":" + "\n";
            commands += "ldc 1\n";
            commands += After + ":" + "\n";
        }
        else if(operator == BinaryOperator.and) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq ";
            String label1 = generateLabel();
            commands += label1 + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifeq " + label1 + "\n";
            String end = generateLabel();
            commands += "ldc 1\ngoto " + end + "\n" + label1 + ":\n" + "ldc 0\n" + end + ":\n";
        }
        else if(operator == BinaryOperator.or) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifne ";
            String label1 = generateLabel();
            commands += label1 + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifne " + label1 + "\n";
            String end = generateLabel();
            commands += "ldc 0\ngoto " + end + "\n" + label1 + ":\n" + "ldc 1\n" + end + ":\n";
        }
        else if(operator == BinaryOperator.assign) {
            Type firstType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type secondType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String secondOperandCommands = binaryExpression.getSecondOperand().accept(this);
            if(firstType instanceof ArrayType)
                secondOperandCommands = "new Array\ndup\n" + secondOperandCommands + "invokespecial Array/<init>(LArray;)V\n";
            if(binaryExpression.getFirstOperand() instanceof Identifier) {
                commands += secondOperandCommands;
                String id = ((Identifier) binaryExpression.getFirstOperand()).getName();
//                commands += "dup\n";
                if(secondType instanceof IntType)
                    commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                if(secondType instanceof BoolType)
                    commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
                Integer slot = slotOf(id);
                boolean isGlobal = false;
                commands += ";binar\n";

                for(VariableDeclaration variableDeclaration : this.globals){
                    if(((Identifier) binaryExpression.getFirstOperand()).getName().equals(variableDeclaration.getVarName().getName())){
                        commands += "putstatic " + "Global" + "/" + variableDeclaration.getVarName().getName() + " " + defnieTypeSignature(variableDeclaration.getType()) + "\n";
                        isGlobal = true;
                    }
                }
                if(isGlobal == false)
                    commands += "astore " + slot.toString() + "\n";
                commands += ";end binar\n";

                commands += binaryExpression.getFirstOperand().accept(this);
            }
            else if(binaryExpression.getFirstOperand() instanceof ArrayAccessByIndex) {
                ArrayAccessByIndex la = (ArrayAccessByIndex) binaryExpression.getFirstOperand();
                commands += la.getInstance().accept(this);
                commands += la.getIndex().accept(this);
                commands += secondOperandCommands;
                if(secondType instanceof IntType)
                    commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                if(secondType instanceof BoolType)
                    commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
                commands += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";
                commands += binaryExpression.getFirstOperand().accept(this);
            }
            else if(binaryExpression.getFirstOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getInstance();
                Type memberType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ClassType) {
                    ObjectMemberAccess firstOperand = (ObjectMemberAccess) binaryExpression.getFirstOperand();
                    String className = ((ClassType) instanceType).getClassName().getName();
                    commands += firstOperand.getInstance().accept(this);
                    commands += secondOperandCommands;
                    commands += "dup_x1\n";
                    if(secondType instanceof IntType)
                        commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    if(secondType instanceof BoolType)
                        commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
                    commands += "putfield " + className + "/" + memberName + " " + defnieTypeSignature(memberType) + "\n";
                    commands += binaryExpression.getFirstOperand().accept(this);
                }
            }
        }
        return commands;
    }

    private String getTypeClass(Type t) {
        if(t instanceof ArrayType)
            return "Array";
        else if(t instanceof IntType)
            return "java/lang/Integer";
        else if(t instanceof FptrType)
            return "Fptr";
        else if(t instanceof BoolType)
            return "java/lang/Boolean";
        else if(t instanceof ClassType){
            return ((ClassType) t).getClassName().getName();
        }
        return "";
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        //todo
        UnaryOperator operator = unaryExpression.getOperator();
        String commands = "";
        if(operator == UnaryOperator.minus) {
            commands += unaryExpression.getOperand().accept(this);
            commands += "ineg\n";
        }
        else if(operator == UnaryOperator.not) {
            commands += unaryExpression.getOperand().accept(this);
            commands += "ifne ";
            String label1 = generateLabel();
            commands += label1 + "\n" + "ldc 1\n";
            commands += "goto ";
            String end = generateLabel();
            commands += end + "\n" + label1 + ":\nldc 0\n" + end + ":\n";
        }
        else if((operator == UnaryOperator.postdec) || (operator == UnaryOperator.postinc)) {
            commands += unaryExpression.getOperand().accept(this);
            if(unaryExpression.getOperand() instanceof Identifier) {
                commands += "dup\n" + "ldc 1\n";
                Integer slot = slotOf(((Identifier) unaryExpression.getOperand()).getName());
                if(operator == UnaryOperator.postdec)
                    commands += "isub\n";
                else
                    commands += "iadd\n";

                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                boolean isGlobal = false;
                for(VariableDeclaration variableDeclaration : this.globals){
                    if(((Identifier) unaryExpression.getOperand()).getName().equals(variableDeclaration.getVarName().getName())){
                        commands += "putstatic " + "Global" + "/" + variableDeclaration.getVarName().getName() + " " + defnieTypeSignature(variableDeclaration.getType()) + "\n";
                        isGlobal = true;
                    }
                }
                if(!isGlobal)
                    commands += "astore " + slot.toString()  + "\n";
            }

            else if(unaryExpression.getOperand() instanceof ArrayAccessByIndex) {
                ArrayAccessByIndex la = (ArrayAccessByIndex)unaryExpression.getOperand();
                commands += la.getInstance().accept(this);
                commands += la.getIndex().accept(this);
                commands += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                commands += "checkcast java/lang/Integer\n";
                commands += "invokevirtual java/lang/Integer/intValue()I\n";
                commands += "ldc 1\n";
                if(operator == UnaryOperator.postdec)
                    commands += "isub\n";
                else
                    commands += "iadd\n";
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                Integer slot = slotOf("");

                commands += "astore " + slot.toString() + "\n";
                commands += la.getInstance().accept(this);
                commands += la.getIndex().accept(this);
                commands += "aload " + slot.toString() + "\n";
                commands += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";
                commands += "aload " + slot.toString() + "\n" + "invokevirtual java/lang/Integer/intValue()I\n";
                commands += "ldc 1\n";
                if(operator == UnaryOperator.postdec)
                    commands += "iadd\n";
                else
                    commands += "isub\n";
            }
            else if(unaryExpression.getOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) unaryExpression.getOperand()).getInstance();
                Type memberType = unaryExpression.getOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ClassType) {
                    String temp = instance.accept(this);
                    commands += temp;
                    temp += "getfield " + ((ClassType)instanceType).getClassName().getName() + "/" + memberName + " " + defnieTypeSignature(memberType) + "\n";
                    temp += "invokevirtual java/lang/Integer/intValue()I\n";
                    temp += "ldc 1\n";
                    if(operator == UnaryOperator.postdec)
                        temp += "isub\n";
                    else
                        temp += "iadd\n";
                    commands += temp;
                    commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    commands += "putfield " + ((ClassType)instanceType).getClassName().getName() + "/" + memberName + " " + defnieTypeSignature(memberType) + "\n";
                    commands += instance.accept(this);
                    commands += "getfield " + ((ClassType)instanceType).getClassName().getName() + "/" + memberName + " " + defnieTypeSignature(memberType) + "\n";
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                    commands += "ldc 1\n";
                    if(operator == UnaryOperator.postdec)
                        commands += "iadd\n";
                    else
                        commands += "isub\n";
                    commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    commands += "putfield " + ((ClassType)instanceType).getClassName().getName() + "/" + memberName + " L" + getTypeClass(memberType) + ";\n";
                }
            }
        }
        return commands;
    }

    @Override
    public String visit(ObjectMemberAccess objectMemberAccess) {
        //todo
        Type memberType = objectMemberAccess.accept(expressionTypeChecker);
        Type instanceType = objectMemberAccess.getInstance().accept(expressionTypeChecker);
        String memberName = objectMemberAccess.getMemberName().getName();
        String commands = "";
        if(instanceType instanceof ClassType) {
            String className = ((ClassType) instanceType).getClassName().getName();
            try {
                SymbolTable classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true)).getClassSymbolTable();
                try {
                    classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + memberName, true);
                    commands += objectMemberAccess.getInstance().accept(this);
                    commands += "getfield " + className + "/" + memberName + " " + defnieTypeSignature(memberType) + "\n";
                    if (memberType instanceof IntType || memberType instanceof BoolType)
                        commands += convertToPremitive(memberType);
                } catch (ItemNotFoundException memberIsMethod) {
                    commands += "new Fptr\ndup\n";
                    commands += objectMemberAccess.getInstance().accept(this);
                    commands += "ldc \"" + memberName + "\"\n";
                    commands += "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
                }
            } catch (ItemNotFoundException classNotFound) {
            }
        }
        return commands;
    }

    @Override
    public String visit(Identifier identifier) {
        //todo
        String commands = "";
        boolean isGlobal = false;
        for(VariableDeclaration variableDeclaration : this.globals){
            if(identifier.getName().equals(variableDeclaration.getVarName().getName())){
                commands += "getstatic " + "Global" + "/" + variableDeclaration.getVarName().getName() + " " + defnieTypeSignature(variableDeclaration.getType()) + "\n";
                isGlobal = true;
            }
        }
        Type idType = identifier.accept(this.expressionTypeChecker);
        int slot = slotOf(identifier.getName());
        if(!isGlobal)
            commands += "aload " + slot + "\n";
        if(idType instanceof IntType || idType instanceof BoolType)
            commands += convertToPremitive(idType);
        return commands;
    }

    @Override
    public String visit(ArrayAccessByIndex arrayAccessByIndex) {
        //todo
        String commands = "";
        Type memberType = arrayAccessByIndex.accept(this.expressionTypeChecker);
        commands += arrayAccessByIndex.getInstance().accept(this);
        commands += arrayAccessByIndex.getIndex().accept(this);
        commands += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
        if(memberType instanceof IntType) {
            commands += "checkcast java/lang/Integer\n";
            commands += convertToPremitive(memberType);
        }
        else if(memberType instanceof BoolType) {
            commands += "checkcast java/lang/Boolean\n";
            commands += convertToPremitive(memberType);
        }
        else if(memberType instanceof ArrayType)
            commands += "checkcast Array\n";
        else if(memberType instanceof FptrType)
            commands += "checkcast Fptr\n";
        else if(memberType instanceof ClassType)
            commands += "checkcast " + ((ClassType) memberType).getClassName().getName() + "\n";
        return commands;
    }

    @Override
    public String visit(MethodCall methodCall) {
        //todo
        String commands = "";
        int tempIndex = slotOf("");
        ArrayList<Expression> args = methodCall.getArgs();
        Type returnType = ((FptrType) methodCall.getInstance().accept(expressionTypeChecker)).getReturnType();
        commands += methodCall.getInstance().accept(this);
        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";
        commands += "astore " + tempIndex + "\n";

        for(Expression arg : args){
            commands += "aload " + tempIndex + "\n";
            Type argType = arg.accept(expressionTypeChecker);
            if(argType instanceof ArrayType) {
                commands += "new Array\n";
                commands += "dup\n";
            }
            commands += arg.accept(this);
            if(argType instanceof IntType)
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            if(argType instanceof BoolType)
                commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
            if(argType instanceof ArrayType) {
                commands += "invokespecial Array/<init>(LArray;)V\n";
            }
            commands += "\ninvokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }
        commands += "aload " + tempIndex + "\n";
        commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";
        if(!(returnType instanceof NullType) && !(returnType instanceof VoidType))
            commands += "checkcast " + getTypeClass(returnType) + "\n";
        if (returnType instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if (returnType instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(NewClassInstance newClassInstance) {
        //todo
        String commands = "new " + newClassInstance.getClassType().getClassName().getName() + "\n";
        commands += "dup\n";
        String args = "";
        for(Expression expression : newClassInstance.getArgs()){
            commands += expression.accept(this);
            Type argType = expression.accept(this.expressionTypeChecker);

            if(argType instanceof IntType)
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            if(argType instanceof BoolType)
                commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";

            args += defnieTypeSignature(argType);
        }
        commands += "invokespecial " + newClassInstance.getClassType().getClassName().getName() + "/<init>(" + args + ")V\n";
        return commands;
    }

    @Override
    public String visit(SelfClass selfClass) {
        //todo
        return "aload 0\n";
    }

    @Override
    public String visit(NullValue nullValue) {
        //todo
        String commands = "";
        commands += "aconst_null\n";
        return commands;
    }

    @Override
    public String visit(IntValue intValue) {
        //todo
        String commands = "";
        commands += "ldc " + intValue.getConstant() + "\n";
        return commands;
    }

    @Override
    public String visit(BoolValue boolValue) {
        //todo
        String commands = "";
        if(boolValue.getConstant())
            commands += "ldc 1\n";
        else
            commands += "ldc 0\n";
        return commands;
    }

}
