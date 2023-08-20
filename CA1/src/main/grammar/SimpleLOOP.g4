grammar SimpleLOOP;

@members{
    void print(String str, Boolean... params){
        assert params.length <= 1;
        boolean inline = params.length > 0 ? params[0].booleanValue() : false;
        if (inline) {
            System.out.print(str);
        } else
            System.out.println(str);
    }
}

simpleLOOP
    : Newline* variablesScope classScope
    ;

variablesScope
    : (types identifier Newline+)*
    ;

identifier
    : varId=Identifier {print("VarDec : " + $varId.text);}
      (Comma varId=Identifier {print("VarDec : " + $varId.text);})* SemiCollon?
      ;

classScope
    : (classSignature Newline*)*
    ;

classSignature
    : Class classId=ClassIdentifier {print("ClassDec : " + $classId.text);}
      (LessThan inheritId=ClassIdentifier {print("Inheritance : " + $classId.text + " < " + $inheritId.text);})? Newline*
      LBrace Newline+ classBody RBrace SemiCollon? Newline*
    |  Class classId=ClassIdentifier {print("ClassDec : " + $classId.text);}
      (LessThan inheritId=ClassIdentifier {print("Inheritance : " + $classId.text + " < " + $inheritId.text);})? Newline* singleClassBody
      ;

classBody
    : (classVariables | classMethods)*
    ;

singleClassBody
    : (classVariables | classMethods)
    ;

classVariables
    : (Private | Public) statement SemiCollon?
    ;

classMethods
    : (Private | Public) (methodTypes methodId=Identifier {print("MethodDec : " + $methodId.text);} | Initialize) LPar methodArguments* RPar Newline* methodBody Newline*
    ;

methodArguments
    : types argId=Identifier (Assign value)? {print("ArgumentDec : " + $argId.text);} (Comma types argId=Identifier (Assign value)? {print("ArgumentDec : " + $argId.text);})*
    ;

methodBody
    : LBrace Newline* statement* Newline* RBrace SemiCollon? | Newline (statement)
    ;

returnExpression
    : Return {print("Return");} expression
    ;

array
    : id=Identifier {print("VarDec : " + $id.text);}
    | (Int | Bool | ClassIdentifier )? LBracket expression RBracket array*
    ;

fptr
    : Fptr LessThan methodTypes (Comma methodTypes)* Arrow methodTypes GreaterThan (id=Identifier {print("VarDec : " + $id.text);})? SemiCollon?
    ;

set
    : Set LessThan Int GreaterThan
    ;

block
    : LBrace Newline+ statement* Newline* RBrace
    | Newline statement Newline*
    ;

statement
    : conditionStatement (Newline)*
    | loopStatement (Newline)*
    | defaultFunctionExpression (Newline)*
    | functionCallStatement (Newline*)
    | variableStatement (Newline)*
    | assignmentExpression (Newline*)
    | returnExpression (Newline*)
    ;

functionCallArgs
    : (expression|assignmentExpression) (Comma (expression|assignmentExpression))* | ()
    ;

funcCallArgs
    : (expression) (Comma (expression))* | ()
    ;

functionCallStatement
    : {print("MethodCall");} arrayExpression ((Dot Identifier (LPar functionCallArgs RPar)+) |
      (Dot Identifier) | (LBracket expression RBracket))* ((Dot (Identifier|Initialize))? (LPar functionCallArgs RPar)+) SemiCollon?
      ;

variableStatement
    : Identifier
    | array
    | fptr
    | set
    | types identifier
    | ClassIdentifier identifier
    ;

conditionStatement
    : If {print("Conditional : if");} expression Newline* block Newline* (Elseif {print("Conditional : elsif");} expression Newline* block Newline*)* Newline* (Else {print("Conditional : else");} Newline* block)?;

loopStatement
    : (LPar expression Dot Dot expression RPar | Identifier) Dot Each {print("Loop : each");} Do OneOr Identifier OneOr block
    ;

expression
    : tripleConditionalExpression (Assign expression {print("Operator : =");})? | tripleConditionalExpression (Comma expression )?
    ;

assignmentExpression
    : tripleConditionalExpression (Assign expression {print("Operator : =");})?
    ;

tripleConditionalExpression
    : logicalOrExpression (QuestionMark expression Colon expression {print("Operator : ?:");})*
    ;

logicalOrExpression
    : logicalAndExpression (Or logicalAndExpression {print("Operator : ||");})*
    ;

logicalAndExpression
    : equalityExpression (And equalityExpression {print("Operator : &&");})*
    ;

equalityExpression
    : comparisionExpression (Equals comparisionExpression {print("Operator : ==");})*
    ;

comparisionExpression
    : additiveExpression ((opId=(LessThan | GreaterThan)) additiveExpression {print("Operator : " + $opId.getText());})*
    ;

additiveExpression
    : multDivExpression ((opId=(Plus | Minus)) multDivExpression {print("Operator : " + $opId.getText());})*
    ;

multDivExpression
    : prefixExpression ((opId=(Mult | Div) ) prefixExpression {print("Operator : " + $opId.getText());})*
    ;

prefixExpression
    : op=(Not | Minus) prefixExpression {print("Operator : " + $op.getText());} | incDecExpression
    ;

incDecExpression
    : arrayExpression (Increment {print("Operator : ++");} | Decrement {print("Operator : --");})?
    ;

arrayExpression
    : extraExpression (((Dot Identifier)? LPar funcCallArgs RPar) | (Dot Identifier) | (LBracket expression RBracket))* SemiCollon?
    ;

extraExpression: value | defaultFunctionExpression | Identifier | LPar expression RPar | Identifier LBracket expression RBracket
;

defaultFunctionExpression
    : Print {print("Built-in : print");} LPar (expression) RPar (SemiCollon)?
    | (ClassIdentifier | Set) Dot New {print("NEW");} LPar expression? RPar (SemiCollon)?
    | Identifier Dot Add {print("ADD");} LPar (expression) RPar (SemiCollon)?
    | Identifier Dot Merge {print("MERGE");} LPar expression? RPar (SemiCollon)?
    | Identifier Dot (Delete {print("DELETE");}| Include {print("INCLUDE");}) LPar (expression) RPar (SemiCollon)?
    ;

value
    : Number
    | Self
    | Identifier
    | bool
    | Newline
    | ClassIdentifier
    | Set
    | Initialize
    ;

types: Int | Bool | fptr | set | array;

methodTypes: Int | Bool | Void | fptr | Set | array;
additiveOperators: Plus | Minus;
multDivOperators: Mult | Div;
incrementDecrementOperators: Increment | Decrement;
bool: True | False;

Class: 'class';
Private: 'private';
Public: 'public';
Int: 'int';
Bool: 'bool';
Fptr: 'fptr';
Set: 'Set';
Self: 'self';
Initialize: 'initialize';
True: 'true';
False: 'false';
Return: 'return';
Print: 'print';
Each: 'each';
Do: 'do';
New: 'new';
If: 'if';
Else: 'else';
Elseif: 'elsif';
Void: 'void';
Null: 'null';
Delete: 'delete';
Include: 'include';
Add: 'add';
Merge: 'merge';

Dot: '.';
Plus: '+';
Minus: '-';
Mult: '*';
Div: '/';
DoubleSlash: '//';
Assign: '=';
Increment: '++';
Decrement: '--';
GreaterThan: '>';
LessThan: '<';
Equals: '==';
And: '&&';
Or: '||';
Not: '!';
QuestionMark: '?';
Colon: ':';
LPar: '(';
RPar: ')';
LBracket: '[';
RBracket: ']';
LBrace: '{';
RBrace: '}';
Comma: ',';
SemiCollon: ';';
Hashtag: '#';
Arrow: '->';
OneOr: '|';
CommentBegin: '=begin';
CommentEnd: '=end';

Newline: [\n\r];
WS: [ \t]+ -> skip;
ClassIdentifier: [A-Z] [a-zA-Z0-9_]*;
Identifier: [A-Za-z_] [a-zA-Z0-9_]*;

Number: [0-9]+;

COMMENT : '=begin' (COMMENT|.)*? '=end' -> skip ;
LINE_COMMENT : '#' .*? '\n' -> skip ;
NEWLINE_SKIP : '//' .*? '\n' -> skip ;