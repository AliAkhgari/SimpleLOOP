// Generated from /Users/ali_akhgary/Desktop/Term6.tmp/Compiler/CA/1/src/main/grammar/SimpleLOOP.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLOOPParser}.
 */
public interface SimpleLOOPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#variablesScope}.
	 * @param ctx the parse tree
	 */
	void enterVariablesScope(SimpleLOOPParser.VariablesScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#variablesScope}.
	 * @param ctx the parse tree
	 */
	void exitVariablesScope(SimpleLOOPParser.VariablesScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SimpleLOOPParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SimpleLOOPParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classScope}.
	 * @param ctx the parse tree
	 */
	void enterClassScope(SimpleLOOPParser.ClassScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classScope}.
	 * @param ctx the parse tree
	 */
	void exitClassScope(SimpleLOOPParser.ClassScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classSignature}.
	 * @param ctx the parse tree
	 */
	void enterClassSignature(SimpleLOOPParser.ClassSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classSignature}.
	 * @param ctx the parse tree
	 */
	void exitClassSignature(SimpleLOOPParser.ClassSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(SimpleLOOPParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(SimpleLOOPParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#singleClassBody}.
	 * @param ctx the parse tree
	 */
	void enterSingleClassBody(SimpleLOOPParser.SingleClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#singleClassBody}.
	 * @param ctx the parse tree
	 */
	void exitSingleClassBody(SimpleLOOPParser.SingleClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classVariables}.
	 * @param ctx the parse tree
	 */
	void enterClassVariables(SimpleLOOPParser.ClassVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classVariables}.
	 * @param ctx the parse tree
	 */
	void exitClassVariables(SimpleLOOPParser.ClassVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classMethods}.
	 * @param ctx the parse tree
	 */
	void enterClassMethods(SimpleLOOPParser.ClassMethodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classMethods}.
	 * @param ctx the parse tree
	 */
	void exitClassMethods(SimpleLOOPParser.ClassMethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(SimpleLOOPParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(SimpleLOOPParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(SimpleLOOPParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(SimpleLOOPParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#fptr}.
	 * @param ctx the parse tree
	 */
	void enterFptr(SimpleLOOPParser.FptrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#fptr}.
	 * @param ctx the parse tree
	 */
	void exitFptr(SimpleLOOPParser.FptrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(SimpleLOOPParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(SimpleLOOPParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#functionCallArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgs(SimpleLOOPParser.FunctionCallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#functionCallArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgs(SimpleLOOPParser.FunctionCallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallArgs(SimpleLOOPParser.FuncCallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallArgs(SimpleLOOPParser.FuncCallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(SimpleLOOPParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(SimpleLOOPParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(SimpleLOOPParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(SimpleLOOPParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(SimpleLOOPParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(SimpleLOOPParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(SimpleLOOPParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(SimpleLOOPParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(SimpleLOOPParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(SimpleLOOPParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#tripleConditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterTripleConditionalExpression(SimpleLOOPParser.TripleConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#tripleConditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitTripleConditionalExpression(SimpleLOOPParser.TripleConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(SimpleLOOPParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(SimpleLOOPParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(SimpleLOOPParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(SimpleLOOPParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#comparisionExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisionExpression(SimpleLOOPParser.ComparisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#comparisionExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisionExpression(SimpleLOOPParser.ComparisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#multDivExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpression(SimpleLOOPParser.MultDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#multDivExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpression(SimpleLOOPParser.MultDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#prefixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(SimpleLOOPParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#prefixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(SimpleLOOPParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#incDecExpression}.
	 * @param ctx the parse tree
	 */
	void enterIncDecExpression(SimpleLOOPParser.IncDecExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#incDecExpression}.
	 * @param ctx the parse tree
	 */
	void exitIncDecExpression(SimpleLOOPParser.IncDecExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(SimpleLOOPParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(SimpleLOOPParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#extraExpression}.
	 * @param ctx the parse tree
	 */
	void enterExtraExpression(SimpleLOOPParser.ExtraExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#extraExpression}.
	 * @param ctx the parse tree
	 */
	void exitExtraExpression(SimpleLOOPParser.ExtraExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#defaultFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefaultFunctionExpression(SimpleLOOPParser.DefaultFunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#defaultFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefaultFunctionExpression(SimpleLOOPParser.DefaultFunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SimpleLOOPParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SimpleLOOPParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(SimpleLOOPParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(SimpleLOOPParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodTypes}.
	 * @param ctx the parse tree
	 */
	void enterMethodTypes(SimpleLOOPParser.MethodTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodTypes}.
	 * @param ctx the parse tree
	 */
	void exitMethodTypes(SimpleLOOPParser.MethodTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#additiveOperators}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperators(SimpleLOOPParser.AdditiveOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#additiveOperators}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperators(SimpleLOOPParser.AdditiveOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#multDivOperators}.
	 * @param ctx the parse tree
	 */
	void enterMultDivOperators(SimpleLOOPParser.MultDivOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#multDivOperators}.
	 * @param ctx the parse tree
	 */
	void exitMultDivOperators(SimpleLOOPParser.MultDivOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#incrementDecrementOperators}.
	 * @param ctx the parse tree
	 */
	void enterIncrementDecrementOperators(SimpleLOOPParser.IncrementDecrementOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#incrementDecrementOperators}.
	 * @param ctx the parse tree
	 */
	void exitIncrementDecrementOperators(SimpleLOOPParser.IncrementDecrementOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(SimpleLOOPParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(SimpleLOOPParser.BoolContext ctx);
}