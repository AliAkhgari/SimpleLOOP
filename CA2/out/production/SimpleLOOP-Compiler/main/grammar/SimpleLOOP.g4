grammar SimpleLOOP;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.classDec.classMembersDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 }

simpleLOOP returns [Program simpleLOOPProgram]:
    NEWLINE* p = program {$simpleLOOPProgram = $p.programRet;} NEWLINE* EOF;

program returns [Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (v = varDecStatement NEWLINE+
    {
        for (VariableDeclaration varDec: $v.varDecStatementRet)
            $programRet.addGlobalVariable(varDec);
    }
    )*
    (c = classDeclaration NEWLINE+ {$programRet.addClass($c.classDeclarationRet);})*;

//todo //done
constructor returns [ConstructorDeclaration constructorRet]
    :
    PUBLIC init = INITIALIZE
    {
        $constructorRet = new ConstructorDeclaration();
        $constructorRet.setLine($init.getLine());
    }
    args = methodArgsDec NEWLINE*
    {
        $constructorRet.setArgs($args.methodArgsDecRet);
    }
    mBody = methodBody
    {
        $constructorRet.setBody($mBody.statementsRet);
        $constructorRet.setLocalVars($mBody.localVarsRet);
    }
    ;

//todo //done
classDeclaration returns [ClassDeclaration classDeclarationRet]
    :
    classDef = CLASS classID = class_identifier
    {
        $classDeclarationRet = new ClassDeclaration($classID.classIdentifierRet);
        $classDeclarationRet.setLine($classDef.getLine());
    }
    (
        LESS_THAN parentClassName = class_identifier
        {
            $classDeclarationRet.setParentClassName($parentClassName.classIdentifierRet);
        }
    )?
    NEWLINE* ((LBRACE NEWLINE+
    ( f1 = field_decleration NEWLINE+
    {
        for (Declaration fieldDec: $f1.fieldDeclerationRet){
            if(fieldDec instanceof ConstructorDeclaration)
                $classDeclarationRet.setConstructor( (ConstructorDeclaration) fieldDec);
            else if(fieldDec instanceof FieldDeclaration)
                $classDeclarationRet.addField( (FieldDeclaration) fieldDec);
            else if(fieldDec instanceof MethodDeclaration)
                $classDeclarationRet.addMethod( (MethodDeclaration) fieldDec);
        }

    }
    )+ RBRACE)
    | ( f2 = field_decleration
    {
        for (Declaration fieldDec: $f2.fieldDeclerationRet){
            if(fieldDec instanceof ConstructorDeclaration)
                $classDeclarationRet.setConstructor( (ConstructorDeclaration) fieldDec);
            else if(fieldDec instanceof FieldDeclaration)
                $classDeclarationRet.addField( (FieldDeclaration) fieldDec);
            else if(fieldDec instanceof MethodDeclaration)
                $classDeclarationRet.addMethod( (MethodDeclaration) fieldDec);
        }
    }
    ))
    ;

//todo //done
field_decleration returns [ArrayList <Declaration> fieldDeclerationRet] locals [boolean isPrivate]
    :
    { $fieldDeclerationRet = new ArrayList <> (); }
    ((
    accessType = ( PUBLIC | PRIVATE)
        (
            varDecSt = varDecStatement
            {
                for (VariableDeclaration varDec: $varDecSt.varDecStatementRet){
                    if($accessType.toString() == "private"){
                        $isPrivate = true;
                    }
                    else{
                        $isPrivate = false;
                    }
                    FieldDeclaration newField = new FieldDeclaration(varDec, $isPrivate);
                    newField.setLine(varDec.getLine());
                    $fieldDeclerationRet.add(newField);
                }
            }
            |
            methodDec = method
            {
                if($accessType.toString() == "private"){
                    $isPrivate = true;
                }
                else{
                    $isPrivate = false;
                }
                MethodDeclaration newMethod = $methodDec.methodRet;
                newMethod.setPrivate($isPrivate);
                $fieldDeclerationRet.add(newMethod);
            }
        )
    )
    | cons = constructor
    {
        $fieldDeclerationRet.add($cons.constructorRet);
    })
    ;

//todo //done
method returns [MethodDeclaration methodRet] locals [Type returnType]
    :
    (t = type
    {
        $returnType = $t.typeRet;
    }
    | VOID
    {
        $returnType = new NullType();
    }
    )
    id = identifier
    {
        $methodRet = new MethodDeclaration();
        $methodRet.setMethodName($id.identifierRet);
        $methodRet.setReturnType($returnType);
        $methodRet.setLine($id.identifierRet.getLine());
    }
    args = methodArgsDec NEWLINE*
    {
        $methodRet.setArgs($args.methodArgsDecRet);
    }
    m_body = methodBody
    {
        $methodRet.setBody($m_body.statementsRet);
        $methodRet.setLocalVars($m_body.localVarsRet);
    }
    ;

//todo //done
methodBody returns [ArrayList<Statement> statementsRet, ArrayList <VariableDeclaration> localVarsRet]
    :
    {
        $statementsRet = new ArrayList<>();
        $localVarsRet = new ArrayList<>();
    }
    ((LBRACE NEWLINE+
    (varDecSt = varDecStatement NEWLINE+
    {
        for (VariableDeclaration varDec : $varDecSt.varDecStatementRet)
            $localVarsRet.add(varDec);
    }
    )*

    (s1 = singleStatement NEWLINE+
    {
        $statementsRet.add($s1.singleStatementRet);
    }
    )* RBRACE)
    |
    ((varDecSt2 = varDecStatement
    {
        for (VariableDeclaration varDec : $varDecSt2.varDecStatementRet)
            $localVarsRet.add(varDec);
    }
    )
    |
    (s2 = singleStatement
    {
        $statementsRet.add($s2.singleStatementRet);
    })));

//todo //checkkkk
methodArgsDec returns [ArrayList <VariableDeclaration> methodArgsDecRet]
    :
    {
        $methodArgsDecRet = new ArrayList<>();
    }
    LPAR (a1 = argDec
    { $methodArgsDecRet.add($a1.argDecRet); }
    ((ASSIGN orExpression)
    |
    (COMMA a2 = argDec { $methodArgsDecRet.add($a2.argDecRet); })*)
    (COMMA a3 = argDec { $methodArgsDecRet.add($a3.argDecRet); } ASSIGN orExpression)*)? RPAR
    ;

//todo //done
argDec returns [VariableDeclaration argDecRet]
    :
    t = type id = identifier
    {
        $argDecRet = new VariableDeclaration($id.identifierRet, $t.typeRet);
        $argDecRet.setLine($id.line);
    }
    ;

//todo //done
methodArgs returns [ArrayList <Expression> methodArgsRet]
    :
    {
        $methodArgsRet = new ArrayList<>();
    }
    (e1 = expression
    {
        $methodArgsRet.add($e1.expressionRet);
    }
    (COMMA e2=expression
    {
        $methodArgsRet.add($e2.expressionRet);
    }
    )*)?;

//todo //check
body returns [Statement bodyRet]
    :
     (bs = blockStatement
     {
        $bodyRet = $bs.blockStatementRet;
     }
     |
     (NEWLINE+ ss = singleStatement
     {
        $bodyRet = $ss.singleStatementRet;
     }
     )
     );

//todo //faghat sakhtaresh fargh dare
blockStatement returns [BlockStmt blockStatementRet] locals [ArrayList <Statement> StatementsRet]
    :
    {$StatementsRet = new ArrayList <> () ;}
    l = LBRACE NEWLINE+
    (st = singleStatement NEWLINE+
    {
        $StatementsRet.add($st.singleStatementRet);
    }
    )*
    RBRACE
    {
        $blockStatementRet = new BlockStmt($StatementsRet);
        $blockStatementRet.setLine($l.getLine());
    }
    ;

//todo //done
singleStatement returns [Statement singleStatementRet]
    :
    i = ifStatement
    {$singleStatementRet = $i.ifStatementRet; }
    | p = printStatement
    {$singleStatementRet = $p.printStatementRet; }
    | m = methodCallStmt
    {$singleStatementRet = $m.methodCallStmtRet; }
    | r = returnStatement
    {$singleStatementRet = $r.returnStatementRet; }
    | a = assignmentStatement
    {$singleStatementRet = $a.assignmentStatementRet; }
    | l = loopStatement
    {$singleStatementRet = $l.loopStatementRet; }
    | ad = addStatement
    {$singleStatementRet = $ad.addStatementRet; }
    | me = mergeStatement
    {$singleStatementRet = $me.mergeStatementRet; }
    | d = deleteStatement
    {$singleStatementRet = $d.deleteStatementRet; }
    ;

//todo //check
addStatement returns [Statement addStatementRet]
    :
    setArg = expression DOT a = ADD LPAR elementArg = orExpression RPAR
    {
        $addStatementRet = new SetAdd($setArg.expressionRet, $elementArg.orExpressionRet);
        $addStatementRet.setLine($a.getLine());
    }
    ;

//todo //check
mergeStatement returns [Statement mergeStatementRet] locals [ArrayList <Expression> elementArgs]
    :
    { $elementArgs = new ArrayList<> () ;}
    setArg = expression DOT m = MERGE LPAR
    e1 = orExpression
    {
        $elementArgs.add($e1.orExpressionRet);
    }
    (COMMA e2 = orExpression
    {
        $elementArgs.add($e2.orExpressionRet);
    }
    )* RPAR
    {
        $mergeStatementRet = new SetMerge($setArg.expressionRet, $elementArgs);
        $mergeStatementRet.setLine($m.getLine());
    }
    ;

//todo //check
deleteStatement returns [Statement deleteStatementRet]
    :
    setArg = expression DOT d = DELETE LPAR elementArg = orExpression RPAR
    {
        $deleteStatementRet = new SetDelete($setArg.expressionRet, $elementArg.orExpressionRet);
        $deleteStatementRet.setLine($d.getLine());
    }
    ;

//todo //done
varDecStatement returns [ArrayList <VariableDeclaration> varDecStatementRet, int line]
    :
    { $varDecStatementRet = new ArrayList<VariableDeclaration> (); }
    t = type id1 = identifier
    {
        VariableDeclaration varDec1 = new VariableDeclaration($id1.identifierRet, $t.typeRet);
        varDec1.setLine($id1.line);
        $varDecStatementRet.add(varDec1);
        $line = $id1.line;
    }
    (COMMA id2 = identifier
    {
        VariableDeclaration varDec2 = new VariableDeclaration($id2.identifierRet, $t.typeRet);
        varDec2.setLine($id2.line);
        $varDecStatementRet.add(varDec2);
        $line = $id2.line;
    }
    )*
    ;

//todo //check
ifStatement returns [ConditionalStmt ifStatementRet]
    :
    i = IF c = condition b = body
    {
        $ifStatementRet = new ConditionalStmt($c.conditionRet, $b.bodyRet);
        $ifStatementRet.setLine($i.getLine());
    }
    (else_if = elsifStatement
    {
        $ifStatementRet.addElsif($else_if.elsifStatementRet);
    }
    )*
    (else_st = elseStatement
    {
        $ifStatementRet.setElseBody($else_st.elseStatementRet);
    }
    )?
    ;

//todo //check
elsifStatement returns [ElsifStmt elsifStatementRet]
    :
     NEWLINE* e = ELSIF c = condition b = body
     {
        $elsifStatementRet = new ElsifStmt($c.conditionRet, $b.bodyRet);
        $elsifStatementRet.setLine($e.getLine());
     }
     ;

//todo //check
condition returns [Expression conditionRet]
    :
     (LPAR e1 = expression RPAR
     {
        $conditionRet = $e1.expressionRet;
     }
     )
     | (e2 = expression
     {
        $conditionRet = $e2.expressionRet;
     }
     )
    ;

//todo //check
elseStatement returns [Statement elseStatementRet]
    :
    NEWLINE* ELSE b = body
    {
        $elseStatementRet = $b.bodyRet;
    }
    ;

//todo //done
printStatement returns [PrintStmt printStatementRet]
    :
    p = PRINT LPAR e = expression RPAR
    {
        $printStatementRet = new PrintStmt($e.expressionRet);
        $printStatementRet.setLine($p.getLine());
    }
    ;

//todo //almost done, faghat set line tahesh
methodCallStmt returns [MethodCallStmt methodCallStmtRet] locals [Expression objAccess]
    :
    acc_expr = accessExpression
    {
        $objAccess = $acc_expr.accessExpressionRet;
    }
    (DOT (init = INITIALIZE
    {
        Identifier new_id = new Identifier($init.text);
        $objAccess = new ObjectMemberAccess($objAccess, new_id);
        new_id.setLine($init.getLine());

    }

    | id = identifier
    {
        Identifier new_id = new Identifier($id.text);
        $objAccess = new ObjectMemberAccess($objAccess, new_id);
        new_id.setLine($id.line);
    }
    ))*
    ((l = LPAR m = methodArgs
    {
        MethodCall methodCall = new MethodCall($objAccess, $m.methodArgsRet);
        methodCall.setLine($l.getLine());
        $methodCallStmtRet = new MethodCallStmt(methodCall);
        $methodCallStmtRet.setLine($l.getLine());
    }
    RPAR));  //((LPAR methodArgs RPAR) | ((INC | DEC)))

//todo // done
returnStatement returns [ReturnStmt returnStatementRet]
    :
    r = RETURN
    {
        $returnStatementRet = new ReturnStmt();
        $returnStatementRet.setLine($r.getLine());
    }
    (e = expression
    {
        $returnStatementRet.setReturnedExpr($e.expressionRet);

    }
    )?
    {
        if($returnStatementRet.getReturnedExpr() instanceof NullValue) {
            NullValue null_value = new NullValue();
            null_value.setLine($r.getLine());
            $returnStatementRet.setReturnedExpr(null_value);
        }
    }
    ;

//todo //done
assignmentStatement returns [AssignmentStmt assignmentStatementRet]
    :
    l = orExpression a = ASSIGN r = expression
    {
        $assignmentStatementRet = new AssignmentStmt($l.orExpressionRet, $r.expressionRet);
        $assignmentStatementRet.setLine($a.getLine());
    }
    ;

//todo //set bodyyy
loopStatement returns [EachStmt loopStatementRet] locals [Expression listExpr]
    :
    ((acc_expr = accessExpression { $listExpr = $acc_expr.accessExpressionRet; })
    |
    (l = LPAR e1 = expression DOT DOT e2 = expression RPAR
    {
        RangeExpression rangeExpr = new RangeExpression($e1.expressionRet, $e2.expressionRet);
        rangeExpr.setLine($l.getLine());
        $listExpr = rangeExpr;

    }
    )) DOT each = EACH DO BAR id = identifier BAR each_body = body
    {
        $loopStatementRet = new EachStmt($id.identifierRet, $listExpr);
        $loopStatementRet.setBody($each_body.bodyRet);
        $loopStatementRet.setLine($each.getLine());
    }
    ;

//todo //done faghat set line tahesh
expression returns [Expression expressionRet]
    :
    tern_expr = ternaryExpression
    {
        $expressionRet = $tern_expr.ternaryExpressionRet;
    }
    (a = ASSIGN e = expression
    {
        BinaryOperator operator = BinaryOperator.assign;
        $expressionRet = new BinaryExpression($tern_expr.ternaryExpressionRet, $e.expressionRet, operator);
        $expressionRet.setLine($a.getLine());
    }
    )?
    (DOT inc=INCLUDE LPAR oe=orExpression RPAR
    {
        $expressionRet = new SetInclude($expressionRet, $oe.orExpressionRet);
        $expressionRet.setLine($inc.getLine());
    }
    )?;

//todo //done
ternaryExpression returns [Expression ternaryExpressionRet]
    :
    or_expr = orExpression
    {
        $ternaryExpressionRet = $or_expr.orExpressionRet;
    }
    (
    t = TIF true_expr = ternaryExpression TELSE false_expr = ternaryExpression
    {
        TernaryOperator ter_op = TernaryOperator.ternary;
        $ternaryExpressionRet = new TernaryExpression($ternaryExpressionRet, $true_expr.ternaryExpressionRet, $false_expr.ternaryExpressionRet);
        $ternaryExpressionRet.setLine($t.getLine());
    }
    )?;

//todo //checkk
orExpression returns [Expression orExpressionRet] locals [BinaryOperator operator, int line]
    :
    and_f = andExpression
    {
        $orExpressionRet = $and_f.andExpressionRet;
    }
    (o = OR
    {
        $operator = BinaryOperator.or;
        $line = $o.getLine();
    }
    and_s = andExpression
    {
        $orExpressionRet = new BinaryExpression($orExpressionRet, $and_s.andExpressionRet, $operator);
        $orExpressionRet.setLine($line);
    }
    )*
    ;

//todo //check
andExpression returns [Expression andExpressionRet] locals [BinaryOperator operator, int line]
    :
    eq_f = equalityExpression
    {
        $andExpressionRet = $eq_f.equalityExpressionRet;
    }
    (a = AND
    {
        $operator = BinaryOperator.and;
        $line = $a.getLine();
    }
    eq_s = equalityExpression
    {
        $andExpressionRet = new BinaryExpression($andExpressionRet, $eq_s.equalityExpressionRet, $operator);
        $andExpressionRet.setLine($line);
    }
    )*;

//todo //done
equalityExpression returns [Expression equalityExpressionRet] locals [BinaryOperator operator, int line]
    :
    rel_f = relationalExpression
    {
        $equalityExpressionRet = $rel_f.relationalExpressionRet;
    }
    (e = EQUAL
    {
        $operator = BinaryOperator.eq;
        $line = $e.getLine();
    }
    rel_s = relationalExpression
    {
        $equalityExpressionRet = new BinaryExpression($equalityExpressionRet, $rel_s.relationalExpressionRet, $operator);
        $equalityExpressionRet.setLine($line);
    }
    )*;

//todo //done
relationalExpression returns [Expression relationalExpressionRet] locals [BinaryOperator operator, int line]
    :
    add_f = additiveExpression
    {
        $relationalExpressionRet = $add_f.additiveExpressionRet;
    }
    (
    (g = GREATER_THAN
    {
        $operator = BinaryOperator.gt;
        $line = $g.getLine();
    }
    |
    l = LESS_THAN
    {
        $operator = BinaryOperator.lt;
        $line = $l.getLine();
    }
    ) add_s = additiveExpression
    {
        $relationalExpressionRet = new BinaryExpression($relationalExpressionRet, $add_s.additiveExpressionRet, $operator);
        $relationalExpressionRet.setLine($line);
    }
    )*;

//todo //done
additiveExpression returns [Expression additiveExpressionRet] locals [BinaryOperator operator, int line]
    :
    mul_f = multiplicativeExpression
    {
        $additiveExpressionRet = $mul_f.multiplicativeExpressionRet;
    }
    (
    (p = PLUS
    {
        $operator = BinaryOperator.add;
        $line = $p.getLine();
    }
    |
    m = MINUS
    {
        $operator = BinaryOperator.sub;
        $line = $m.getLine();
    }
    ) mul_s = multiplicativeExpression
    {
        $additiveExpressionRet = new BinaryExpression($additiveExpressionRet, $mul_s.multiplicativeExpressionRet, $operator);
        $additiveExpressionRet.setLine($line);
    }
    )*
    ;

//todo //done
multiplicativeExpression returns [Expression multiplicativeExpressionRet] locals [BinaryOperator operator, int line]
    :
    pre_f = preUnaryExpression
    {
        $multiplicativeExpressionRet = $pre_f.multiplicativeExpressionRet;
    }
    ((
    m = MULT
    {
        $operator = BinaryOperator.mult;
        $line = $m.getLine();
    }
    |
    d = DIVIDE
    {
        $operator = BinaryOperator.div;
        $line = $d.getLine();
    }
    )
    pre_s = preUnaryExpression
    {
        $multiplicativeExpressionRet = new BinaryExpression($multiplicativeExpressionRet, $pre_s.multiplicativeExpressionRet, $operator);
        $multiplicativeExpressionRet.setLine($line);
    }
    )*;

//todo //done
preUnaryExpression returns [Expression multiplicativeExpressionRet] locals [UnaryOperator operator, int line]
    :
    ((
        n = NOT
        {
            $operator = UnaryOperator.not;
            $line = $n.getLine();
        }
        |
        m = MINUS
        {
            $operator = UnaryOperator.minus;
            $line = $m.getLine();
        }
    )
    pre = preUnaryExpression
    {
        $multiplicativeExpressionRet = new UnaryExpression($pre.multiplicativeExpressionRet, $operator);
        $multiplicativeExpressionRet.setLine($line);
    }
    )
    | post = postUnaryExpression
    {
        $multiplicativeExpressionRet = $post.postUnaryExpressionRet;
    }
    ;

//todo //done
postUnaryExpression returns [Expression postUnaryExpressionRet]
    :
    a_expr = accessExpression
    {
        $postUnaryExpressionRet = $a_expr.accessExpressionRet;
    }
    (
        (post_inc = INC
        {
            UnaryOperator operator = UnaryOperator.postinc;
            $postUnaryExpressionRet = new UnaryExpression($postUnaryExpressionRet, operator);
            $postUnaryExpressionRet.setLine($post_inc.getLine());
        }
        |
        post_dec = DEC
        {
            UnaryOperator operator = UnaryOperator.postdec;
            $postUnaryExpressionRet = new UnaryExpression($postUnaryExpressionRet, operator);
            $postUnaryExpressionRet.setLine($post_dec.getLine());
        }
        )
    )?
    ;

//todo
accessExpression returns [Expression accessExpressionRet]
    :
    o_expr = otherExpression
    {
        $accessExpressionRet = $o_expr.otherExpressionRet;
    }
    ((l = LPAR m_args = methodArgs
     {
        if ($accessExpressionRet instanceof NewClassInstance)
            ((NewClassInstance) $accessExpressionRet).setArgs($m_args.methodArgsRet);
        else{
             $accessExpressionRet = new MethodCall($accessExpressionRet, $m_args.methodArgsRet);
             $accessExpressionRet.setLine($l.getLine());
        }

     }RPAR)

    |
        (DOT
            (i = identifier
            {
                $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, $i.identifierRet);
                $accessExpressionRet.setLine($i.line);
            }
            |
            n = NEW ////
            {
                ClassType new_class_type = new ClassType((Identifier) $accessExpressionRet);
                $accessExpressionRet = new NewClassInstance(new_class_type);
                $accessExpressionRet.setLine($n.getLine());
            }
            |
            init = INITIALIZE
            {
                Identifier new_id = new Identifier($init.text);
                $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, new_id);
                new_id.setLine($init.getLine());
                $accessExpressionRet.setLine($init.getLine());
            }

            )
        )
    )*
    ((DOT (id = identifier))
    {
        $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, $id.identifierRet);
        $accessExpressionRet.setLine($id.line);
    }
    |
    (l = LBRACK e = expression RBRACK)
    {
        $accessExpressionRet = new ArrayAccessByIndex($accessExpressionRet, $e.expressionRet);
        $accessExpressionRet.setLine($l.getLine());
    }
    )*;

//todo //almost done, faghat expression akharesh
otherExpression returns [Expression otherExpressionRet]
    :
    s = SELF
    {
        $otherExpressionRet = new SelfClass();
        $otherExpressionRet.setLine($s.getLine());
    }
    | c = class_identifier
    {
        $otherExpressionRet = $c.classIdentifierRet;
    }
    | v = value
    {
        $otherExpressionRet = $v.valueRet;
    }
    | i = identifier
    {
        $otherExpressionRet = $i.identifierRet;
    }
    | s_new = setNew
    {
        $otherExpressionRet = $s_new.setNewRet;
    }
    |
    LPAR e = expression RPAR
    {
        $otherExpressionRet = $e.expressionRet;
    }
    ;

//todo //done
setNew returns [SetNew setNewRet] locals [ArrayList <Expression> exprArray]
    :
    { $exprArray = new ArrayList<> ();}
    SET DOT n = NEW LPAR
    (LPAR e1 = orExpression
    {
        $exprArray.add($e1.orExpressionRet);
    }
        (
        COMMA e2 = orExpression
        {
            $exprArray.add($e2.orExpressionRet);
        }
        )* RPAR
    )?
    {
        $setNewRet = new SetNew($exprArray);
        $setNewRet.setLine($n.getLine());
    }
    RPAR
    ;

//todo //done
value returns [Value valueRet]
    :
    b = boolValue
    {
        $valueRet = new BoolValue($b.boolValueRet);
        $valueRet.setLine($b.line);
    }
    |
    i = INT_VALUE
    {
        $valueRet = new IntValue($i.int);
        $valueRet.setLine($i.getLine());
    }
    ;

//todo //done
boolValue returns [boolean boolValueRet, int line]
    :
    t = TRUE
    {
        $boolValueRet = true;
        $line = $t.getLine();
    }
    |
    f = FALSE
    {
        $boolValueRet = false;
        $line = $f.getLine();
    }
    ;

//todo //done
class_identifier returns [Identifier classIdentifierRet]
    :
    classID = CLASS_IDENTIFIER
    {
        $classIdentifierRet = new Identifier($classID.text);
        $classIdentifierRet.setLine($classID.getLine());
    }
    ;

//todo //done
identifier returns [Identifier identifierRet, int line]
    :
    id = IDENTIFIER
    {
        $identifierRet = new Identifier($id.text);
        $identifierRet.setLine($id.getLine());
        $line = $identifierRet.getLine();
    }
    ;

//todo //done
type returns [Type typeRet]
    :
    INT
    {
        $typeRet = new IntType();
    }
    | BOOL
    {
        $typeRet = new BoolType();
    }
    | arrayType = array_type
    {
        $typeRet = $arrayType.arrayTypeRet;
    }
    | fptrType = fptr_type
    {
        $typeRet = $fptrType.fptrTypeRet;
    }
    | setType = set_type
    {
        $typeRet = $setType.setTypeRet;
    }
    | classID = class_identifier
    {
        $typeRet = new ClassType($classID.classIdentifierRet);
    }
    ;

//todo //done
array_type returns [ArrayType arrayTypeRet] locals [ArrayList <Expression> exprArray, Type elementType]
    :
    { $exprArray = new ArrayList<> (); }
    ( INT
    {
        $elementType = new IntType();
    }
    | BOOL
    {
        $elementType = new BoolType();
    }
    | classID = class_identifier
    {
        $elementType = new ClassType($classID.classIdentifierRet);
    }
    )

    (
        LBRACK e = expression
        {
            $exprArray.add($e.expressionRet);
        }
        RBRACK
    )+
    {
        $arrayTypeRet = new ArrayType($elementType, $exprArray);
    }
    ;
//todo //done
fptr_type returns [FptrType fptrTypeRet] locals [ArrayList <Type> types]
    :
    FPTR
    {
        $fptrTypeRet = new FptrType();
    }
    LESS_THAN
    (VOID
        {
            $fptrTypeRet.setArgumentsTypes(new ArrayList<Type>());
        }
    |
        (
        t1 = type
        {
            $types.add($t1.typeRet);
        }
            (
                COMMA t2 = type
                {
                    $types.add($t2.typeRet);
                }
            )*
        )
    {
        $fptrTypeRet.setArgumentsTypes($types);
    }
    )
    ARROW
    (
        returnType = type
        {
            $fptrTypeRet.setReturnType($returnType.typeRet);
        }
        |
        VOID
        {
            $fptrTypeRet.setReturnType(new NullType());
        }
    ) GREATER_THAN
    ;

//todo //done
set_type returns [SetType setTypeRet]
    :
    SET LESS_THAN (INT) GREATER_THAN { $setTypeRet = new SetType(); }
    ;


LINE_BREAK: ('//\n') -> skip;

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
NEW: 'new';
SELF: 'self';


RETURN: 'return';
VOID: 'void';


DELETE: 'delete';
INCLUDE: 'include';
ADD: 'add';
MERGE: 'merge';
PRINT: 'print';


IF: 'if';
ELSE: 'else';
ELSIF: 'elsif';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';
INC: '++';
DEC: '--';

EQUAL: '==';
GREATER_THAN: '>';
LESS_THAN: '<';

ARROW: '->';
BAR: '|';

AND: '&&';
OR: '||';
NOT: '!';

TIF: '?';
TELSE: ':';

TRUE: 'true';
FALSE: 'false';
NULL: 'null';

BEGIN: '=begin';
END: '=end';

INT: 'int';
BOOL: 'bool';
FPTR: 'fptr';
SET: 'Set';
EACH: 'each';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
SEMICOLON: ';' -> skip;
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_IDENTIFIER: [A-Z][A-Za-z0-9_]*;

COMMENT: '#' .*? '\n' -> skip;
MLCOMMENT: ('=begin' .*? '=end') -> skip;
WS: ([ \t\r]) -> skip;

