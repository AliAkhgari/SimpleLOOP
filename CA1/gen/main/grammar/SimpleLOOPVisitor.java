// Generated from /Users/ali_akhgary/Desktop/Term6.tmp/Compiler/CA/1/src/main/grammar/SimpleLOOP.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLOOPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLOOPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#variablesScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesScope(SimpleLOOPParser.VariablesScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SimpleLOOPParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassScope(SimpleLOOPParser.ClassScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSignature(SimpleLOOPParser.ClassSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(SimpleLOOPParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#singleClassBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleClassBody(SimpleLOOPParser.SingleClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVariables(SimpleLOOPParser.ClassVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethods(SimpleLOOPParser.ClassMethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#returnExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(SimpleLOOPParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SimpleLOOPParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#fptr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFptr(SimpleLOOPParser.FptrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(SimpleLOOPParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#functionCallArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgs(SimpleLOOPParser.FunctionCallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#funcCallArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallArgs(SimpleLOOPParser.FuncCallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(SimpleLOOPParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(SimpleLOOPParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#conditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(SimpleLOOPParser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(SimpleLOOPParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(SimpleLOOPParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#tripleConditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTripleConditionalExpression(SimpleLOOPParser.TripleConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(SimpleLOOPParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(SimpleLOOPParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#comparisionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisionExpression(SimpleLOOPParser.ComparisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#multDivExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpression(SimpleLOOPParser.MultDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#prefixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(SimpleLOOPParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#incDecExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecExpression(SimpleLOOPParser.IncDecExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(SimpleLOOPParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#extraExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraExpression(SimpleLOOPParser.ExtraExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#defaultFunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultFunctionExpression(SimpleLOOPParser.DefaultFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SimpleLOOPParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(SimpleLOOPParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodTypes(SimpleLOOPParser.MethodTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#additiveOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperators(SimpleLOOPParser.AdditiveOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#multDivOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivOperators(SimpleLOOPParser.MultDivOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#incrementDecrementOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementDecrementOperators(SimpleLOOPParser.IncrementDecrementOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SimpleLOOPParser.BoolContext ctx);
}