// Generated from /Users/ali_akhgary/Desktop/Term6.tmp/Compiler/CA/1/src/main/grammar/SimpleLOOP.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLOOPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Class=1, Private=2, Public=3, Int=4, Bool=5, Fptr=6, Set=7, Self=8, Initialize=9, 
		True=10, False=11, Return=12, Print=13, Each=14, Do=15, New=16, If=17, 
		Else=18, Elseif=19, Void=20, Null=21, Delete=22, Include=23, Add=24, Merge=25, 
		Dot=26, Plus=27, Minus=28, Mult=29, Div=30, DoubleSlash=31, Assign=32, 
		Increment=33, Decrement=34, GreaterThan=35, LessThan=36, Equals=37, And=38, 
		Or=39, Not=40, QuestionMark=41, Colon=42, LPar=43, RPar=44, LBracket=45, 
		RBracket=46, LBrace=47, RBrace=48, Comma=49, SemiCollon=50, Hashtag=51, 
		Arrow=52, OneOr=53, CommentBegin=54, CommentEnd=55, Newline=56, WS=57, 
		ClassIdentifier=58, Identifier=59, Number=60, COMMENT=61, LINE_COMMENT=62, 
		NEWLINE_SKIP=63;
	public static final int
		RULE_simpleLOOP = 0, RULE_variablesScope = 1, RULE_identifier = 2, RULE_classScope = 3, 
		RULE_classSignature = 4, RULE_classBody = 5, RULE_singleClassBody = 6, 
		RULE_classVariables = 7, RULE_classMethods = 8, RULE_methodArguments = 9, 
		RULE_methodBody = 10, RULE_returnExpression = 11, RULE_array = 12, RULE_fptr = 13, 
		RULE_set = 14, RULE_block = 15, RULE_statement = 16, RULE_functionCallArgs = 17, 
		RULE_funcCallArgs = 18, RULE_functionCallStatement = 19, RULE_variableStatement = 20, 
		RULE_conditionStatement = 21, RULE_loopStatement = 22, RULE_expression = 23, 
		RULE_assignmentExpression = 24, RULE_tripleConditionalExpression = 25, 
		RULE_logicalOrExpression = 26, RULE_logicalAndExpression = 27, RULE_equalityExpression = 28, 
		RULE_comparisionExpression = 29, RULE_additiveExpression = 30, RULE_multDivExpression = 31, 
		RULE_prefixExpression = 32, RULE_incDecExpression = 33, RULE_arrayExpression = 34, 
		RULE_extraExpression = 35, RULE_defaultFunctionExpression = 36, RULE_value = 37, 
		RULE_types = 38, RULE_methodTypes = 39, RULE_additiveOperators = 40, RULE_multDivOperators = 41, 
		RULE_incrementDecrementOperators = 42, RULE_bool = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"simpleLOOP", "variablesScope", "identifier", "classScope", "classSignature", 
			"classBody", "singleClassBody", "classVariables", "classMethods", "methodArguments", 
			"methodBody", "returnExpression", "array", "fptr", "set", "block", "statement", 
			"functionCallArgs", "funcCallArgs", "functionCallStatement", "variableStatement", 
			"conditionStatement", "loopStatement", "expression", "assignmentExpression", 
			"tripleConditionalExpression", "logicalOrExpression", "logicalAndExpression", 
			"equalityExpression", "comparisionExpression", "additiveExpression", 
			"multDivExpression", "prefixExpression", "incDecExpression", "arrayExpression", 
			"extraExpression", "defaultFunctionExpression", "value", "types", "methodTypes", 
			"additiveOperators", "multDivOperators", "incrementDecrementOperators", 
			"bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'private'", "'public'", "'int'", "'bool'", "'fptr'", 
			"'Set'", "'self'", "'initialize'", "'true'", "'false'", "'return'", "'print'", 
			"'each'", "'do'", "'new'", "'if'", "'else'", "'elsif'", "'void'", "'null'", 
			"'delete'", "'include'", "'add'", "'merge'", "'.'", "'+'", "'-'", "'*'", 
			"'/'", "'//'", "'='", "'++'", "'--'", "'>'", "'<'", "'=='", "'&&'", "'||'", 
			"'!'", "'?'", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "','", 
			"';'", "'#'", "'->'", "'|'", "'=begin'", "'=end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Class", "Private", "Public", "Int", "Bool", "Fptr", "Set", "Self", 
			"Initialize", "True", "False", "Return", "Print", "Each", "Do", "New", 
			"If", "Else", "Elseif", "Void", "Null", "Delete", "Include", "Add", "Merge", 
			"Dot", "Plus", "Minus", "Mult", "Div", "DoubleSlash", "Assign", "Increment", 
			"Decrement", "GreaterThan", "LessThan", "Equals", "And", "Or", "Not", 
			"QuestionMark", "Colon", "LPar", "RPar", "LBracket", "RBracket", "LBrace", 
			"RBrace", "Comma", "SemiCollon", "Hashtag", "Arrow", "OneOr", "CommentBegin", 
			"CommentEnd", "Newline", "WS", "ClassIdentifier", "Identifier", "Number", 
			"COMMENT", "LINE_COMMENT", "NEWLINE_SKIP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLOOP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    void print(String str, Boolean... params){
	        assert params.length <= 1;
	        boolean inline = params.length > 0 ? params[0].booleanValue() : false;
	        if (inline) {
	            System.out.print(str);
	        } else
	            System.out.println(str);
	    }

	public SimpleLOOPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SimpleLOOPContext extends ParserRuleContext {
		public VariablesScopeContext variablesScope() {
			return getRuleContext(VariablesScopeContext.class,0);
		}
		public ClassScopeContext classScope() {
			return getRuleContext(ClassScopeContext.class,0);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public SimpleLOOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLOOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSimpleLOOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSimpleLOOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSimpleLOOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLOOPContext simpleLOOP() throws RecognitionException {
		SimpleLOOPContext _localctx = new SimpleLOOPContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simpleLOOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Newline) {
				{
				{
				setState(88);
				match(Newline);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			variablesScope();
			setState(95);
			classScope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariablesScopeContext extends ParserRuleContext {
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public VariablesScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterVariablesScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitVariablesScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitVariablesScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesScopeContext variablesScope() throws RecognitionException {
		VariablesScopeContext _localctx = new VariablesScopeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variablesScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Fptr) | (1L << Set) | (1L << LBracket) | (1L << ClassIdentifier) | (1L << Identifier))) != 0)) {
				{
				{
				setState(97);
				types();
				setState(98);
				identifier();
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					match(Newline);
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Newline );
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Token varId;
		public List<TerminalNode> Identifier() { return getTokens(SimpleLOOPParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLOOPParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLOOPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLOOPParser.Comma, i);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			((IdentifierContext)_localctx).varId = match(Identifier);
			print("VarDec : " + (((IdentifierContext)_localctx).varId!=null?((IdentifierContext)_localctx).varId.getText():null));
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(111);
				match(Comma);
				setState(112);
				((IdentifierContext)_localctx).varId = match(Identifier);
				print("VarDec : " + (((IdentifierContext)_localctx).varId!=null?((IdentifierContext)_localctx).varId.getText():null));
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(119);
				match(SemiCollon);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassScopeContext extends ParserRuleContext {
		public List<ClassSignatureContext> classSignature() {
			return getRuleContexts(ClassSignatureContext.class);
		}
		public ClassSignatureContext classSignature(int i) {
			return getRuleContext(ClassSignatureContext.class,i);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public ClassScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassScopeContext classScope() throws RecognitionException {
		ClassScopeContext _localctx = new ClassScopeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Class) {
				{
				{
				setState(122);
				classSignature();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(123);
					match(Newline);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassSignatureContext extends ParserRuleContext {
		public Token classId;
		public Token inheritId;
		public TerminalNode Class() { return getToken(SimpleLOOPParser.Class, 0); }
		public TerminalNode LBrace() { return getToken(SimpleLOOPParser.LBrace, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(SimpleLOOPParser.RBrace, 0); }
		public List<TerminalNode> ClassIdentifier() { return getTokens(SimpleLOOPParser.ClassIdentifier); }
		public TerminalNode ClassIdentifier(int i) {
			return getToken(SimpleLOOPParser.ClassIdentifier, i);
		}
		public TerminalNode LessThan() { return getToken(SimpleLOOPParser.LessThan, 0); }
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public SingleClassBodyContext singleClassBody() {
			return getRuleContext(SingleClassBodyContext.class,0);
		}
		public ClassSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassSignatureContext classSignature() throws RecognitionException {
		ClassSignatureContext _localctx = new ClassSignatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classSignature);
		int _la;
		try {
			int _alt;
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(Class);
				setState(135);
				((ClassSignatureContext)_localctx).classId = match(ClassIdentifier);
				print("ClassDec : " + (((ClassSignatureContext)_localctx).classId!=null?((ClassSignatureContext)_localctx).classId.getText():null));
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LessThan) {
					{
					setState(137);
					match(LessThan);
					setState(138);
					((ClassSignatureContext)_localctx).inheritId = match(ClassIdentifier);
					print("Inheritance : " + (((ClassSignatureContext)_localctx).classId!=null?((ClassSignatureContext)_localctx).classId.getText():null) + " < " + (((ClassSignatureContext)_localctx).inheritId!=null?((ClassSignatureContext)_localctx).inheritId.getText():null));
					}
				}

				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(142);
					match(Newline);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				match(LBrace);
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					match(Newline);
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Newline );
				setState(154);
				classBody();
				setState(155);
				match(RBrace);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiCollon) {
					{
					setState(156);
					match(SemiCollon);
					}
				}

				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(159);
						match(Newline);
						}
						} 
					}
					setState(164);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(Class);
				setState(166);
				((ClassSignatureContext)_localctx).classId = match(ClassIdentifier);
				print("ClassDec : " + (((ClassSignatureContext)_localctx).classId!=null?((ClassSignatureContext)_localctx).classId.getText():null));
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LessThan) {
					{
					setState(168);
					match(LessThan);
					setState(169);
					((ClassSignatureContext)_localctx).inheritId = match(ClassIdentifier);
					print("Inheritance : " + (((ClassSignatureContext)_localctx).classId!=null?((ClassSignatureContext)_localctx).classId.getText():null) + " < " + (((ClassSignatureContext)_localctx).inheritId!=null?((ClassSignatureContext)_localctx).inheritId.getText():null));
					}
				}

				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(173);
					match(Newline);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				singleClassBody();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassVariablesContext> classVariables() {
			return getRuleContexts(ClassVariablesContext.class);
		}
		public ClassVariablesContext classVariables(int i) {
			return getRuleContext(ClassVariablesContext.class,i);
		}
		public List<ClassMethodsContext> classMethods() {
			return getRuleContexts(ClassMethodsContext.class);
		}
		public ClassMethodsContext classMethods(int i) {
			return getRuleContext(ClassMethodsContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Private || _la==Public) {
				{
				setState(184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(182);
					classVariables();
					}
					break;
				case 2:
					{
					setState(183);
					classMethods();
					}
					break;
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleClassBodyContext extends ParserRuleContext {
		public ClassVariablesContext classVariables() {
			return getRuleContext(ClassVariablesContext.class,0);
		}
		public ClassMethodsContext classMethods() {
			return getRuleContext(ClassMethodsContext.class,0);
		}
		public SingleClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleClassBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSingleClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSingleClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSingleClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleClassBodyContext singleClassBody() throws RecognitionException {
		SingleClassBodyContext _localctx = new SingleClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleClassBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(189);
				classVariables();
				}
				break;
			case 2:
				{
				setState(190);
				classMethods();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassVariablesContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Private() { return getToken(SimpleLOOPParser.Private, 0); }
		public TerminalNode Public() { return getToken(SimpleLOOPParser.Public, 0); }
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public ClassVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassVariablesContext classVariables() throws RecognitionException {
		ClassVariablesContext _localctx = new ClassVariablesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==Private || _la==Public) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(194);
			statement();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SemiCollon) {
				{
				setState(195);
				match(SemiCollon);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodsContext extends ParserRuleContext {
		public Token methodId;
		public TerminalNode LPar() { return getToken(SimpleLOOPParser.LPar, 0); }
		public TerminalNode RPar() { return getToken(SimpleLOOPParser.RPar, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode Private() { return getToken(SimpleLOOPParser.Private, 0); }
		public TerminalNode Public() { return getToken(SimpleLOOPParser.Public, 0); }
		public MethodTypesContext methodTypes() {
			return getRuleContext(MethodTypesContext.class,0);
		}
		public TerminalNode Initialize() { return getToken(SimpleLOOPParser.Initialize, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public List<MethodArgumentsContext> methodArguments() {
			return getRuleContexts(MethodArgumentsContext.class);
		}
		public MethodArgumentsContext methodArguments(int i) {
			return getRuleContext(MethodArgumentsContext.class,i);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public ClassMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassMethods(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodsContext classMethods() throws RecognitionException {
		ClassMethodsContext _localctx = new ClassMethodsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classMethods);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_la = _input.LA(1);
			if ( !(_la==Private || _la==Public) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case Fptr:
			case Set:
			case Void:
			case LBracket:
			case ClassIdentifier:
			case Identifier:
				{
				setState(199);
				methodTypes();
				setState(200);
				((ClassMethodsContext)_localctx).methodId = match(Identifier);
				print("MethodDec : " + (((ClassMethodsContext)_localctx).methodId!=null?((ClassMethodsContext)_localctx).methodId.getText():null));
				}
				break;
			case Initialize:
				{
				setState(203);
				match(Initialize);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(206);
			match(LPar);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << Fptr) | (1L << Set) | (1L << LBracket) | (1L << ClassIdentifier) | (1L << Identifier))) != 0)) {
				{
				{
				setState(207);
				methodArguments();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			match(RPar);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(Newline);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(220);
			methodBody();
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					match(Newline);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodArgumentsContext extends ParserRuleContext {
		public Token argId;
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SimpleLOOPParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLOOPParser.Identifier, i);
		}
		public List<TerminalNode> Assign() { return getTokens(SimpleLOOPParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(SimpleLOOPParser.Assign, i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLOOPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLOOPParser.Comma, i);
		}
		public MethodArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgumentsContext methodArguments() throws RecognitionException {
		MethodArgumentsContext _localctx = new MethodArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			types();
			setState(228);
			((MethodArgumentsContext)_localctx).argId = match(Identifier);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(229);
				match(Assign);
				setState(230);
				value();
				}
			}

			print("ArgumentDec : " + (((MethodArgumentsContext)_localctx).argId!=null?((MethodArgumentsContext)_localctx).argId.getText():null));
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(234);
				match(Comma);
				setState(235);
				types();
				setState(236);
				((MethodArgumentsContext)_localctx).argId = match(Identifier);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(237);
					match(Assign);
					setState(238);
					value();
					}
				}

				print("ArgumentDec : " + (((MethodArgumentsContext)_localctx).argId!=null?((MethodArgumentsContext)_localctx).argId.getText():null));
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(SimpleLOOPParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SimpleLOOPParser.RBrace, 0); }
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodBody);
		int _la;
		try {
			int _alt;
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(LBrace);
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(249);
						match(Newline);
						}
						} 
					}
					setState(254);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(255);
						statement();
						}
						} 
					}
					setState(260);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(261);
					match(Newline);
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267);
				match(RBrace);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiCollon) {
					{
					setState(268);
					match(SemiCollon);
					}
				}

				}
				break;
			case Newline:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				match(Newline);
				{
				setState(272);
				statement();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnExpressionContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(SimpleLOOPParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitReturnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitReturnExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnExpressionContext returnExpression() throws RecognitionException {
		ReturnExpressionContext _localctx = new ReturnExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(Return);
			print("Return");
			setState(277);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public TerminalNode LBracket() { return getToken(SimpleLOOPParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(SimpleLOOPParser.RBracket, 0); }
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public TerminalNode Int() { return getToken(SimpleLOOPParser.Int, 0); }
		public TerminalNode Bool() { return getToken(SimpleLOOPParser.Bool, 0); }
		public TerminalNode ClassIdentifier() { return getToken(SimpleLOOPParser.ClassIdentifier, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			int _alt;
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				((ArrayContext)_localctx).id = match(Identifier);
				print("VarDec : " + (((ArrayContext)_localctx).id!=null?((ArrayContext)_localctx).id.getText():null));
				}
				break;
			case Int:
			case Bool:
			case LBracket:
			case ClassIdentifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << ClassIdentifier))) != 0)) {
					{
					setState(281);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << ClassIdentifier))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(284);
				match(LBracket);
				setState(285);
				expression();
				setState(286);
				match(RBracket);
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(287);
						array();
						}
						} 
					}
					setState(292);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FptrContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Fptr() { return getToken(SimpleLOOPParser.Fptr, 0); }
		public TerminalNode LessThan() { return getToken(SimpleLOOPParser.LessThan, 0); }
		public List<MethodTypesContext> methodTypes() {
			return getRuleContexts(MethodTypesContext.class);
		}
		public MethodTypesContext methodTypes(int i) {
			return getRuleContext(MethodTypesContext.class,i);
		}
		public TerminalNode Arrow() { return getToken(SimpleLOOPParser.Arrow, 0); }
		public TerminalNode GreaterThan() { return getToken(SimpleLOOPParser.GreaterThan, 0); }
		public List<TerminalNode> Comma() { return getTokens(SimpleLOOPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLOOPParser.Comma, i);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public FptrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFptr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFptr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFptr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FptrContext fptr() throws RecognitionException {
		FptrContext _localctx = new FptrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fptr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(Fptr);
			setState(296);
			match(LessThan);
			setState(297);
			methodTypes();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(298);
				match(Comma);
				setState(299);
				methodTypes();
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(305);
			match(Arrow);
			setState(306);
			methodTypes();
			setState(307);
			match(GreaterThan);
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(308);
				((FptrContext)_localctx).id = match(Identifier);
				print("VarDec : " + (((FptrContext)_localctx).id!=null?((FptrContext)_localctx).id.getText():null));
				}
				break;
			}
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(312);
				match(SemiCollon);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public TerminalNode Set() { return getToken(SimpleLOOPParser.Set, 0); }
		public TerminalNode LessThan() { return getToken(SimpleLOOPParser.LessThan, 0); }
		public TerminalNode Int() { return getToken(SimpleLOOPParser.Int, 0); }
		public TerminalNode GreaterThan() { return getToken(SimpleLOOPParser.GreaterThan, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(Set);
			setState(316);
			match(LessThan);
			setState(317);
			match(Int);
			setState(318);
			match(GreaterThan);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(SimpleLOOPParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SimpleLOOPParser.RBrace, 0); }
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			int _alt;
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(LBrace);
				setState(322); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(321);
						match(Newline);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(324); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(326);
						statement();
						}
						} 
					}
					setState(331);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(332);
					match(Newline);
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(338);
				match(RBrace);
				}
				break;
			case Newline:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(Newline);
				setState(340);
				statement();
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(341);
						match(Newline);
						}
						} 
					}
					setState(346);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ConditionStatementContext conditionStatement() {
			return getRuleContext(ConditionStatementContext.class,0);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public DefaultFunctionExpressionContext defaultFunctionExpression() {
			return getRuleContext(DefaultFunctionExpressionContext.class,0);
		}
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ReturnExpressionContext returnExpression() {
			return getRuleContext(ReturnExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		try {
			int _alt;
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				conditionStatement();
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(350);
						match(Newline);
						}
						} 
					}
					setState(355);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				loopStatement();
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(357);
						match(Newline);
						}
						} 
					}
					setState(362);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				defaultFunctionExpression();
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(364);
						match(Newline);
						}
						} 
					}
					setState(369);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				functionCallStatement();
				{
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(371);
						match(Newline);
						}
						} 
					}
					setState(376);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(377);
				variableStatement();
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(378);
						match(Newline);
						}
						} 
					}
					setState(383);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(384);
				assignmentExpression();
				{
				setState(388);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(385);
						match(Newline);
						}
						} 
					}
					setState(390);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				}
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(391);
				returnExpression();
				{
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(392);
						match(Newline);
						}
						} 
					}
					setState(397);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLOOPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLOOPParser.Comma, i);
		}
		public FunctionCallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFunctionCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFunctionCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFunctionCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallArgsContext functionCallArgs() throws RecognitionException {
		FunctionCallArgsContext _localctx = new FunctionCallArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionCallArgs);
		int _la;
		try {
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Set:
			case Self:
			case Initialize:
			case True:
			case False:
			case Print:
			case Minus:
			case Not:
			case LPar:
			case Newline:
			case ClassIdentifier:
			case Identifier:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(400);
					expression();
					}
					break;
				case 2:
					{
					setState(401);
					assignmentExpression();
					}
					break;
				}
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(404);
					match(Comma);
					setState(407);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(405);
						expression();
						}
						break;
					case 2:
						{
						setState(406);
						assignmentExpression();
						}
						break;
					}
					}
					}
					setState(413);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPar:
				enterOuterAlt(_localctx, 2);
				{
				{
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLOOPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLOOPParser.Comma, i);
		}
		public FuncCallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFuncCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFuncCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFuncCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallArgsContext funcCallArgs() throws RecognitionException {
		FuncCallArgsContext _localctx = new FuncCallArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcCallArgs);
		int _la;
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Set:
			case Self:
			case Initialize:
			case True:
			case False:
			case Print:
			case Minus:
			case Not:
			case LPar:
			case Newline:
			case ClassIdentifier:
			case Identifier:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(417);
				expression();
				}
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(418);
					match(Comma);
					{
					setState(419);
					expression();
					}
					}
					}
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPar:
				enterOuterAlt(_localctx, 2);
				{
				{
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public List<TerminalNode> Dot() { return getTokens(SimpleLOOPParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(SimpleLOOPParser.Dot, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SimpleLOOPParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLOOPParser.Identifier, i);
		}
		public List<TerminalNode> LBracket() { return getTokens(SimpleLOOPParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(SimpleLOOPParser.LBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(SimpleLOOPParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(SimpleLOOPParser.RBracket, i);
		}
		public List<TerminalNode> LPar() { return getTokens(SimpleLOOPParser.LPar); }
		public TerminalNode LPar(int i) {
			return getToken(SimpleLOOPParser.LPar, i);
		}
		public List<FunctionCallArgsContext> functionCallArgs() {
			return getRuleContexts(FunctionCallArgsContext.class);
		}
		public FunctionCallArgsContext functionCallArgs(int i) {
			return getRuleContext(FunctionCallArgsContext.class,i);
		}
		public List<TerminalNode> RPar() { return getTokens(SimpleLOOPParser.RPar); }
		public TerminalNode RPar(int i) {
			return getToken(SimpleLOOPParser.RPar, i);
		}
		public TerminalNode Initialize() { return getToken(SimpleLOOPParser.Initialize, 0); }
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionCallStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			print("MethodCall");
			setState(429);
			arrayExpression();
			setState(448);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(446);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						{
						setState(430);
						match(Dot);
						setState(431);
						match(Identifier);
						setState(436); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(432);
								match(LPar);
								setState(433);
								functionCallArgs();
								setState(434);
								match(RPar);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(438); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						break;
					case 2:
						{
						{
						setState(440);
						match(Dot);
						setState(441);
						match(Identifier);
						}
						}
						break;
					case 3:
						{
						{
						setState(442);
						match(LBracket);
						setState(443);
						expression();
						setState(444);
						match(RBracket);
						}
						}
						break;
					}
					} 
				}
				setState(450);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			{
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Dot) {
				{
				setState(451);
				match(Dot);
				setState(452);
				_la = _input.LA(1);
				if ( !(_la==Initialize || _la==Identifier) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(459); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(455);
					match(LPar);
					setState(456);
					functionCallArgs();
					setState(457);
					match(RPar);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(461); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(463);
				match(SemiCollon);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public FptrContext fptr() {
			return getRuleContext(FptrContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ClassIdentifier() { return getToken(SimpleLOOPParser.ClassIdentifier, 0); }
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variableStatement);
		try {
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(468);
				fptr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(469);
				set();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(470);
				types();
				setState(471);
				identifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(473);
				match(ClassIdentifier);
				setState(474);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(SimpleLOOPParser.If, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> Newline() { return getTokens(SimpleLOOPParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(SimpleLOOPParser.Newline, i);
		}
		public List<TerminalNode> Elseif() { return getTokens(SimpleLOOPParser.Elseif); }
		public TerminalNode Elseif(int i) {
			return getToken(SimpleLOOPParser.Elseif, i);
		}
		public TerminalNode Else() { return getToken(SimpleLOOPParser.Else, 0); }
		public ConditionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterConditionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitConditionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitConditionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionStatementContext conditionStatement() throws RecognitionException {
		ConditionStatementContext _localctx = new ConditionStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_conditionStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(If);
			print("Conditional : if");
			setState(479);
			expression();
			setState(483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(480);
					match(Newline);
					}
					} 
				}
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(486);
			block();
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(487);
					match(Newline);
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(511);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(493);
					match(Elseif);
					print("Conditional : elsif");
					setState(495);
					expression();
					setState(499);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(496);
							match(Newline);
							}
							} 
						}
						setState(501);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					}
					setState(502);
					block();
					setState(506);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(503);
							match(Newline);
							}
							} 
						}
						setState(508);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
					}
					}
					} 
				}
				setState(513);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			setState(517);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(514);
					match(Newline);
					}
					} 
				}
				setState(519);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			}
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(520);
				match(Else);
				print("Conditional : else");
				setState(525);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(522);
						match(Newline);
						}
						} 
					}
					setState(527);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				}
				setState(528);
				block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public List<TerminalNode> Dot() { return getTokens(SimpleLOOPParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(SimpleLOOPParser.Dot, i);
		}
		public TerminalNode Each() { return getToken(SimpleLOOPParser.Each, 0); }
		public TerminalNode Do() { return getToken(SimpleLOOPParser.Do, 0); }
		public List<TerminalNode> OneOr() { return getTokens(SimpleLOOPParser.OneOr); }
		public TerminalNode OneOr(int i) {
			return getToken(SimpleLOOPParser.OneOr, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SimpleLOOPParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLOOPParser.Identifier, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LPar() { return getToken(SimpleLOOPParser.LPar, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPar() { return getToken(SimpleLOOPParser.RPar, 0); }
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPar:
				{
				setState(531);
				match(LPar);
				setState(532);
				expression();
				setState(533);
				match(Dot);
				setState(534);
				match(Dot);
				setState(535);
				expression();
				setState(536);
				match(RPar);
				}
				break;
			case Identifier:
				{
				setState(538);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(541);
			match(Dot);
			setState(542);
			match(Each);
			print("Loop : each");
			setState(544);
			match(Do);
			setState(545);
			match(OneOr);
			setState(546);
			match(Identifier);
			setState(547);
			match(OneOr);
			setState(548);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TripleConditionalExpressionContext tripleConditionalExpression() {
			return getRuleContext(TripleConditionalExpressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLOOPParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLOOPParser.Comma, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				tripleConditionalExpression();
				setState(555);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(551);
					match(Assign);
					setState(552);
					expression();
					print("Operator : =");
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				tripleConditionalExpression();
				setState(560);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(558);
					match(Comma);
					setState(559);
					expression();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public TripleConditionalExpressionContext tripleConditionalExpression() {
			return getRuleContext(TripleConditionalExpressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLOOPParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			tripleConditionalExpression();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(565);
				match(Assign);
				setState(566);
				expression();
				print("Operator : =");
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TripleConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public List<TerminalNode> QuestionMark() { return getTokens(SimpleLOOPParser.QuestionMark); }
		public TerminalNode QuestionMark(int i) {
			return getToken(SimpleLOOPParser.QuestionMark, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(SimpleLOOPParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(SimpleLOOPParser.Colon, i);
		}
		public TripleConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tripleConditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterTripleConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitTripleConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitTripleConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TripleConditionalExpressionContext tripleConditionalExpression() throws RecognitionException {
		TripleConditionalExpressionContext _localctx = new TripleConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tripleConditionalExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			logicalOrExpression();
			setState(580);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(572);
					match(QuestionMark);
					setState(573);
					expression();
					setState(574);
					match(Colon);
					setState(575);
					expression();
					print("Operator : ?:");
					}
					} 
				}
				setState(582);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(SimpleLOOPParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(SimpleLOOPParser.Or, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitLogicalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			logicalAndExpression();
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(584);
				match(Or);
				setState(585);
				logicalAndExpression();
				print("Operator : ||");
				}
				}
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(SimpleLOOPParser.And); }
		public TerminalNode And(int i) {
			return getToken(SimpleLOOPParser.And, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitLogicalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			equalityExpression();
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(594);
				match(And);
				setState(595);
				equalityExpression();
				print("Operator : &&");
				}
				}
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<ComparisionExpressionContext> comparisionExpression() {
			return getRuleContexts(ComparisionExpressionContext.class);
		}
		public ComparisionExpressionContext comparisionExpression(int i) {
			return getRuleContext(ComparisionExpressionContext.class,i);
		}
		public List<TerminalNode> Equals() { return getTokens(SimpleLOOPParser.Equals); }
		public TerminalNode Equals(int i) {
			return getToken(SimpleLOOPParser.Equals, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			comparisionExpression();
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Equals) {
				{
				{
				setState(604);
				match(Equals);
				setState(605);
				comparisionExpression();
				print("Operator : ==");
				}
				}
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisionExpressionContext extends ParserRuleContext {
		public Token opId;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> LessThan() { return getTokens(SimpleLOOPParser.LessThan); }
		public TerminalNode LessThan(int i) {
			return getToken(SimpleLOOPParser.LessThan, i);
		}
		public List<TerminalNode> GreaterThan() { return getTokens(SimpleLOOPParser.GreaterThan); }
		public TerminalNode GreaterThan(int i) {
			return getToken(SimpleLOOPParser.GreaterThan, i);
		}
		public ComparisionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterComparisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitComparisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitComparisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisionExpressionContext comparisionExpression() throws RecognitionException {
		ComparisionExpressionContext _localctx = new ComparisionExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_comparisionExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			additiveExpression();
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GreaterThan || _la==LessThan) {
				{
				{
				{
				setState(614);
				((ComparisionExpressionContext)_localctx).opId = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==GreaterThan || _la==LessThan) ) {
					((ComparisionExpressionContext)_localctx).opId = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				setState(615);
				additiveExpression();
				print("Operator : " + ((ComparisionExpressionContext)_localctx).opId.getText());
				}
				}
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Token opId;
		public List<MultDivExpressionContext> multDivExpression() {
			return getRuleContexts(MultDivExpressionContext.class);
		}
		public MultDivExpressionContext multDivExpression(int i) {
			return getRuleContext(MultDivExpressionContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(SimpleLOOPParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(SimpleLOOPParser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(SimpleLOOPParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(SimpleLOOPParser.Minus, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			multDivExpression();
			setState(630);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					{
					setState(624);
					((AdditiveExpressionContext)_localctx).opId = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
						((AdditiveExpressionContext)_localctx).opId = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					setState(625);
					multDivExpression();
					print("Operator : " + ((AdditiveExpressionContext)_localctx).opId.getText());
					}
					} 
				}
				setState(632);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultDivExpressionContext extends ParserRuleContext {
		public Token opId;
		public List<PrefixExpressionContext> prefixExpression() {
			return getRuleContexts(PrefixExpressionContext.class);
		}
		public PrefixExpressionContext prefixExpression(int i) {
			return getRuleContext(PrefixExpressionContext.class,i);
		}
		public List<TerminalNode> Mult() { return getTokens(SimpleLOOPParser.Mult); }
		public TerminalNode Mult(int i) {
			return getToken(SimpleLOOPParser.Mult, i);
		}
		public List<TerminalNode> Div() { return getTokens(SimpleLOOPParser.Div); }
		public TerminalNode Div(int i) {
			return getToken(SimpleLOOPParser.Div, i);
		}
		public MultDivExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multDivExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMultDivExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMultDivExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMultDivExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultDivExpressionContext multDivExpression() throws RecognitionException {
		MultDivExpressionContext _localctx = new MultDivExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multDivExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			prefixExpression();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mult || _la==Div) {
				{
				{
				{
				setState(634);
				((MultDivExpressionContext)_localctx).opId = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Mult || _la==Div) ) {
					((MultDivExpressionContext)_localctx).opId = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				setState(635);
				prefixExpression();
				print("Operator : " + ((MultDivExpressionContext)_localctx).opId.getText());
				}
				}
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixExpressionContext extends ParserRuleContext {
		public Token op;
		public PrefixExpressionContext prefixExpression() {
			return getRuleContext(PrefixExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(SimpleLOOPParser.Not, 0); }
		public TerminalNode Minus() { return getToken(SimpleLOOPParser.Minus, 0); }
		public IncDecExpressionContext incDecExpression() {
			return getRuleContext(IncDecExpressionContext.class,0);
		}
		public PrefixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPrefixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExpressionContext prefixExpression() throws RecognitionException {
		PrefixExpressionContext _localctx = new PrefixExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_prefixExpression);
		int _la;
		try {
			setState(648);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Minus:
			case Not:
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				((PrefixExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Minus || _la==Not) ) {
					((PrefixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(644);
				prefixExpression();
				print("Operator : " + ((PrefixExpressionContext)_localctx).op.getText());
				}
				break;
			case Set:
			case Self:
			case Initialize:
			case True:
			case False:
			case Print:
			case LPar:
			case Newline:
			case ClassIdentifier:
			case Identifier:
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				incDecExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncDecExpressionContext extends ParserRuleContext {
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public TerminalNode Increment() { return getToken(SimpleLOOPParser.Increment, 0); }
		public TerminalNode Decrement() { return getToken(SimpleLOOPParser.Decrement, 0); }
		public IncDecExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDecExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIncDecExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIncDecExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncDecExpressionContext incDecExpression() throws RecognitionException {
		IncDecExpressionContext _localctx = new IncDecExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_incDecExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			arrayExpression();
			setState(655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Increment:
				{
				setState(651);
				match(Increment);
				print("Operator : ++");
				}
				break;
			case Decrement:
				{
				setState(653);
				match(Decrement);
				print("Operator : --");
				}
				break;
			case EOF:
			case Class:
			case Private:
			case Public:
			case Int:
			case Bool:
			case Fptr:
			case Set:
			case Self:
			case Initialize:
			case True:
			case False:
			case Return:
			case Print:
			case If:
			case Else:
			case Elseif:
			case Dot:
			case Plus:
			case Minus:
			case Mult:
			case Div:
			case Assign:
			case GreaterThan:
			case LessThan:
			case Equals:
			case And:
			case Or:
			case Not:
			case QuestionMark:
			case Colon:
			case LPar:
			case RPar:
			case LBracket:
			case RBracket:
			case LBrace:
			case RBrace:
			case Comma:
			case SemiCollon:
			case Newline:
			case ClassIdentifier:
			case Identifier:
			case Number:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayExpressionContext extends ParserRuleContext {
		public ExtraExpressionContext extraExpression() {
			return getRuleContext(ExtraExpressionContext.class,0);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public List<TerminalNode> LPar() { return getTokens(SimpleLOOPParser.LPar); }
		public TerminalNode LPar(int i) {
			return getToken(SimpleLOOPParser.LPar, i);
		}
		public List<FuncCallArgsContext> funcCallArgs() {
			return getRuleContexts(FuncCallArgsContext.class);
		}
		public FuncCallArgsContext funcCallArgs(int i) {
			return getRuleContext(FuncCallArgsContext.class,i);
		}
		public List<TerminalNode> RPar() { return getTokens(SimpleLOOPParser.RPar); }
		public TerminalNode RPar(int i) {
			return getToken(SimpleLOOPParser.RPar, i);
		}
		public List<TerminalNode> Dot() { return getTokens(SimpleLOOPParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(SimpleLOOPParser.Dot, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SimpleLOOPParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLOOPParser.Identifier, i);
		}
		public List<TerminalNode> LBracket() { return getTokens(SimpleLOOPParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(SimpleLOOPParser.LBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(SimpleLOOPParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(SimpleLOOPParser.RBracket, i);
		}
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_arrayExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			extraExpression();
			setState(674);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(672);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
					case 1:
						{
						{
						setState(660);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Dot) {
							{
							setState(658);
							match(Dot);
							setState(659);
							match(Identifier);
							}
						}

						setState(662);
						match(LPar);
						setState(663);
						funcCallArgs();
						setState(664);
						match(RPar);
						}
						}
						break;
					case 2:
						{
						{
						setState(666);
						match(Dot);
						setState(667);
						match(Identifier);
						}
						}
						break;
					case 3:
						{
						{
						setState(668);
						match(LBracket);
						setState(669);
						expression();
						setState(670);
						match(RBracket);
						}
						}
						break;
					}
					} 
				}
				setState(676);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			}
			setState(678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(677);
				match(SemiCollon);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtraExpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DefaultFunctionExpressionContext defaultFunctionExpression() {
			return getRuleContext(DefaultFunctionExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public TerminalNode LPar() { return getToken(SimpleLOOPParser.LPar, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPar() { return getToken(SimpleLOOPParser.RPar, 0); }
		public TerminalNode LBracket() { return getToken(SimpleLOOPParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(SimpleLOOPParser.RBracket, 0); }
		public ExtraExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterExtraExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitExtraExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitExtraExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraExpressionContext extraExpression() throws RecognitionException {
		ExtraExpressionContext _localctx = new ExtraExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_extraExpression);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(680);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(681);
				defaultFunctionExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(682);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(683);
				match(LPar);
				setState(684);
				expression();
				setState(685);
				match(RPar);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(687);
				match(Identifier);
				setState(688);
				match(LBracket);
				setState(689);
				expression();
				setState(690);
				match(RBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultFunctionExpressionContext extends ParserRuleContext {
		public TerminalNode Print() { return getToken(SimpleLOOPParser.Print, 0); }
		public TerminalNode LPar() { return getToken(SimpleLOOPParser.LPar, 0); }
		public TerminalNode RPar() { return getToken(SimpleLOOPParser.RPar, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiCollon() { return getToken(SimpleLOOPParser.SemiCollon, 0); }
		public TerminalNode Dot() { return getToken(SimpleLOOPParser.Dot, 0); }
		public TerminalNode New() { return getToken(SimpleLOOPParser.New, 0); }
		public TerminalNode ClassIdentifier() { return getToken(SimpleLOOPParser.ClassIdentifier, 0); }
		public TerminalNode Set() { return getToken(SimpleLOOPParser.Set, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public TerminalNode Add() { return getToken(SimpleLOOPParser.Add, 0); }
		public TerminalNode Merge() { return getToken(SimpleLOOPParser.Merge, 0); }
		public TerminalNode Delete() { return getToken(SimpleLOOPParser.Delete, 0); }
		public TerminalNode Include() { return getToken(SimpleLOOPParser.Include, 0); }
		public DefaultFunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultFunctionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterDefaultFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitDefaultFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitDefaultFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultFunctionExpressionContext defaultFunctionExpression() throws RecognitionException {
		DefaultFunctionExpressionContext _localctx = new DefaultFunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_defaultFunctionExpression);
		int _la;
		try {
			setState(750);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(694);
				match(Print);
				print("Built-in : print");
				setState(696);
				match(LPar);
				{
				setState(697);
				expression();
				}
				setState(698);
				match(RPar);
				setState(700);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(699);
					match(SemiCollon);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(702);
				_la = _input.LA(1);
				if ( !(_la==Set || _la==ClassIdentifier) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(703);
				match(Dot);
				setState(704);
				match(New);
				print("NEW");
				setState(706);
				match(LPar);
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Set) | (1L << Self) | (1L << Initialize) | (1L << True) | (1L << False) | (1L << Print) | (1L << Minus) | (1L << Not) | (1L << LPar) | (1L << Newline) | (1L << ClassIdentifier) | (1L << Identifier) | (1L << Number))) != 0)) {
					{
					setState(707);
					expression();
					}
				}

				setState(710);
				match(RPar);
				setState(712);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(711);
					match(SemiCollon);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(714);
				match(Identifier);
				setState(715);
				match(Dot);
				setState(716);
				match(Add);
				print("ADD");
				setState(718);
				match(LPar);
				{
				setState(719);
				expression();
				}
				setState(720);
				match(RPar);
				setState(722);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(721);
					match(SemiCollon);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(724);
				match(Identifier);
				setState(725);
				match(Dot);
				setState(726);
				match(Merge);
				print("MERGE");
				setState(728);
				match(LPar);
				setState(730);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Set) | (1L << Self) | (1L << Initialize) | (1L << True) | (1L << False) | (1L << Print) | (1L << Minus) | (1L << Not) | (1L << LPar) | (1L << Newline) | (1L << ClassIdentifier) | (1L << Identifier) | (1L << Number))) != 0)) {
					{
					setState(729);
					expression();
					}
				}

				setState(732);
				match(RPar);
				setState(734);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(733);
					match(SemiCollon);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(736);
				match(Identifier);
				setState(737);
				match(Dot);
				setState(742);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Delete:
					{
					setState(738);
					match(Delete);
					print("DELETE");
					}
					break;
				case Include:
					{
					setState(740);
					match(Include);
					print("INCLUDE");
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(744);
				match(LPar);
				{
				setState(745);
				expression();
				}
				setState(746);
				match(RPar);
				setState(748);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(747);
					match(SemiCollon);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(SimpleLOOPParser.Number, 0); }
		public TerminalNode Self() { return getToken(SimpleLOOPParser.Self, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLOOPParser.Identifier, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode Newline() { return getToken(SimpleLOOPParser.Newline, 0); }
		public TerminalNode ClassIdentifier() { return getToken(SimpleLOOPParser.ClassIdentifier, 0); }
		public TerminalNode Set() { return getToken(SimpleLOOPParser.Set, 0); }
		public TerminalNode Initialize() { return getToken(SimpleLOOPParser.Initialize, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_value);
		try {
			setState(760);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				match(Number);
				}
				break;
			case Self:
				enterOuterAlt(_localctx, 2);
				{
				setState(753);
				match(Self);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(754);
				match(Identifier);
				}
				break;
			case True:
			case False:
				enterOuterAlt(_localctx, 4);
				{
				setState(755);
				bool();
				}
				break;
			case Newline:
				enterOuterAlt(_localctx, 5);
				{
				setState(756);
				match(Newline);
				}
				break;
			case ClassIdentifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(757);
				match(ClassIdentifier);
				}
				break;
			case Set:
				enterOuterAlt(_localctx, 7);
				{
				setState(758);
				match(Set);
				}
				break;
			case Initialize:
				enterOuterAlt(_localctx, 8);
				{
				setState(759);
				match(Initialize);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(SimpleLOOPParser.Int, 0); }
		public TerminalNode Bool() { return getToken(SimpleLOOPParser.Bool, 0); }
		public FptrContext fptr() {
			return getRuleContext(FptrContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_types);
		try {
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(762);
				match(Int);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(763);
				match(Bool);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(764);
				fptr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(765);
				set();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(766);
				array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypesContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(SimpleLOOPParser.Int, 0); }
		public TerminalNode Bool() { return getToken(SimpleLOOPParser.Bool, 0); }
		public TerminalNode Void() { return getToken(SimpleLOOPParser.Void, 0); }
		public FptrContext fptr() {
			return getRuleContext(FptrContext.class,0);
		}
		public TerminalNode Set() { return getToken(SimpleLOOPParser.Set, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public MethodTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodTypesContext methodTypes() throws RecognitionException {
		MethodTypesContext _localctx = new MethodTypesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_methodTypes);
		try {
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(769);
				match(Int);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(770);
				match(Bool);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(771);
				match(Void);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				fptr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(773);
				match(Set);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(774);
				array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveOperatorsContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(SimpleLOOPParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLOOPParser.Minus, 0); }
		public AdditiveOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAdditiveOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAdditiveOperators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAdditiveOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveOperatorsContext additiveOperators() throws RecognitionException {
		AdditiveOperatorsContext _localctx = new AdditiveOperatorsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_additiveOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultDivOperatorsContext extends ParserRuleContext {
		public TerminalNode Mult() { return getToken(SimpleLOOPParser.Mult, 0); }
		public TerminalNode Div() { return getToken(SimpleLOOPParser.Div, 0); }
		public MultDivOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multDivOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMultDivOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMultDivOperators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMultDivOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultDivOperatorsContext multDivOperators() throws RecognitionException {
		MultDivOperatorsContext _localctx = new MultDivOperatorsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_multDivOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			_la = _input.LA(1);
			if ( !(_la==Mult || _la==Div) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncrementDecrementOperatorsContext extends ParserRuleContext {
		public TerminalNode Increment() { return getToken(SimpleLOOPParser.Increment, 0); }
		public TerminalNode Decrement() { return getToken(SimpleLOOPParser.Decrement, 0); }
		public IncrementDecrementOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementDecrementOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIncrementDecrementOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIncrementDecrementOperators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIncrementDecrementOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementDecrementOperatorsContext incrementDecrementOperators() throws RecognitionException {
		IncrementDecrementOperatorsContext _localctx = new IncrementDecrementOperatorsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_incrementDecrementOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			_la = _input.LA(1);
			if ( !(_la==Increment || _la==Decrement) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(SimpleLOOPParser.True, 0); }
		public TerminalNode False() { return getToken(SimpleLOOPParser.False, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u0314\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\7\2\\\n\2\f\2\16\2_\13\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3g\n"+
		"\3\r\3\16\3h\7\3k\n\3\f\3\16\3n\13\3\3\4\3\4\3\4\3\4\3\4\7\4u\n\4\f\4"+
		"\16\4x\13\4\3\4\5\4{\n\4\3\5\3\5\7\5\177\n\5\f\5\16\5\u0082\13\5\7\5\u0084"+
		"\n\5\f\5\16\5\u0087\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008f\n\6\3\6\7\6"+
		"\u0092\n\6\f\6\16\6\u0095\13\6\3\6\3\6\6\6\u0099\n\6\r\6\16\6\u009a\3"+
		"\6\3\6\3\6\5\6\u00a0\n\6\3\6\7\6\u00a3\n\6\f\6\16\6\u00a6\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00ae\n\6\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4\13\6\3"+
		"\6\5\6\u00b7\n\6\3\7\3\7\7\7\u00bb\n\7\f\7\16\7\u00be\13\7\3\b\3\b\5\b"+
		"\u00c2\n\b\3\t\3\t\3\t\5\t\u00c7\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00cf"+
		"\n\n\3\n\3\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\n\3\n\7\n\u00da\n\n\f"+
		"\n\16\n\u00dd\13\n\3\n\3\n\7\n\u00e1\n\n\f\n\16\n\u00e4\13\n\3\13\3\13"+
		"\3\13\3\13\5\13\u00ea\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f2\n"+
		"\13\3\13\3\13\7\13\u00f6\n\13\f\13\16\13\u00f9\13\13\3\f\3\f\7\f\u00fd"+
		"\n\f\f\f\16\f\u0100\13\f\3\f\7\f\u0103\n\f\f\f\16\f\u0106\13\f\3\f\7\f"+
		"\u0109\n\f\f\f\16\f\u010c\13\f\3\f\3\f\5\f\u0110\n\f\3\f\3\f\5\f\u0114"+
		"\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u011d\n\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0123\n\16\f\16\16\16\u0126\13\16\5\16\u0128\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u012f\n\17\f\17\16\17\u0132\13\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0139\n\17\3\17\5\17\u013c\n\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\6\21\u0145\n\21\r\21\16\21\u0146\3\21\7\21\u014a\n\21\f\21\16"+
		"\21\u014d\13\21\3\21\7\21\u0150\n\21\f\21\16\21\u0153\13\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0159\n\21\f\21\16\21\u015c\13\21\5\21\u015e\n\21\3\22"+
		"\3\22\7\22\u0162\n\22\f\22\16\22\u0165\13\22\3\22\3\22\7\22\u0169\n\22"+
		"\f\22\16\22\u016c\13\22\3\22\3\22\7\22\u0170\n\22\f\22\16\22\u0173\13"+
		"\22\3\22\3\22\7\22\u0177\n\22\f\22\16\22\u017a\13\22\3\22\3\22\7\22\u017e"+
		"\n\22\f\22\16\22\u0181\13\22\3\22\3\22\7\22\u0185\n\22\f\22\16\22\u0188"+
		"\13\22\3\22\3\22\7\22\u018c\n\22\f\22\16\22\u018f\13\22\5\22\u0191\n\22"+
		"\3\23\3\23\5\23\u0195\n\23\3\23\3\23\3\23\5\23\u019a\n\23\7\23\u019c\n"+
		"\23\f\23\16\23\u019f\13\23\3\23\5\23\u01a2\n\23\3\24\3\24\3\24\7\24\u01a7"+
		"\n\24\f\24\16\24\u01aa\13\24\3\24\5\24\u01ad\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\6\25\u01b7\n\25\r\25\16\25\u01b8\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\7\25\u01c1\n\25\f\25\16\25\u01c4\13\25\3\25\3\25\5\25\u01c8"+
		"\n\25\3\25\3\25\3\25\3\25\6\25\u01ce\n\25\r\25\16\25\u01cf\3\25\5\25\u01d3"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01de\n\26\3\27"+
		"\3\27\3\27\3\27\7\27\u01e4\n\27\f\27\16\27\u01e7\13\27\3\27\3\27\7\27"+
		"\u01eb\n\27\f\27\16\27\u01ee\13\27\3\27\3\27\3\27\3\27\7\27\u01f4\n\27"+
		"\f\27\16\27\u01f7\13\27\3\27\3\27\7\27\u01fb\n\27\f\27\16\27\u01fe\13"+
		"\27\7\27\u0200\n\27\f\27\16\27\u0203\13\27\3\27\7\27\u0206\n\27\f\27\16"+
		"\27\u0209\13\27\3\27\3\27\3\27\7\27\u020e\n\27\f\27\16\27\u0211\13\27"+
		"\3\27\5\27\u0214\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u021e"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u022e\n\31\3\31\3\31\3\31\5\31\u0233\n\31\5\31\u0235\n\31\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u023c\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0245\n\33\f\33\16\33\u0248\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u024f\n\34\f\34\16\34\u0252\13\34\3\35\3\35\3\35\3\35\3\35\7\35"+
		"\u0259\n\35\f\35\16\35\u025c\13\35\3\36\3\36\3\36\3\36\3\36\7\36\u0263"+
		"\n\36\f\36\16\36\u0266\13\36\3\37\3\37\3\37\3\37\3\37\7\37\u026d\n\37"+
		"\f\37\16\37\u0270\13\37\3 \3 \3 \3 \3 \7 \u0277\n \f \16 \u027a\13 \3"+
		"!\3!\3!\3!\3!\7!\u0281\n!\f!\16!\u0284\13!\3\"\3\"\3\"\3\"\3\"\5\"\u028b"+
		"\n\"\3#\3#\3#\3#\3#\5#\u0292\n#\3$\3$\3$\5$\u0297\n$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\7$\u02a3\n$\f$\16$\u02a6\13$\3$\5$\u02a9\n$\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\5%\u02b7\n%\3&\3&\3&\3&\3&\3&\5&\u02bf\n&\3&"+
		"\3&\3&\3&\3&\3&\5&\u02c7\n&\3&\3&\5&\u02cb\n&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\5&\u02d5\n&\3&\3&\3&\3&\3&\3&\5&\u02dd\n&\3&\3&\5&\u02e1\n&\3&\3&\3&"+
		"\3&\3&\3&\5&\u02e9\n&\3&\3&\3&\3&\5&\u02ef\n&\5&\u02f1\n&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u02fb\n\'\3(\3(\3(\3(\3(\5(\u0302\n(\3)\3)\3"+
		")\3)\3)\3)\5)\u030a\n)\3*\3*\3+\3+\3,\3,\3-\3-\3-\2\2.\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\f\3\2"+
		"\4\5\4\2\6\7<<\4\2\13\13==\3\2%&\3\2\35\36\3\2\37 \4\2\36\36**\4\2\t\t"+
		"<<\3\2#$\3\2\f\r\2\u036c\2]\3\2\2\2\4l\3\2\2\2\6o\3\2\2\2\b\u0085\3\2"+
		"\2\2\n\u00b6\3\2\2\2\f\u00bc\3\2\2\2\16\u00c1\3\2\2\2\20\u00c3\3\2\2\2"+
		"\22\u00c8\3\2\2\2\24\u00e5\3\2\2\2\26\u0113\3\2\2\2\30\u0115\3\2\2\2\32"+
		"\u0127\3\2\2\2\34\u0129\3\2\2\2\36\u013d\3\2\2\2 \u015d\3\2\2\2\"\u0190"+
		"\3\2\2\2$\u01a1\3\2\2\2&\u01ac\3\2\2\2(\u01ae\3\2\2\2*\u01dd\3\2\2\2,"+
		"\u01df\3\2\2\2.\u021d\3\2\2\2\60\u0234\3\2\2\2\62\u0236\3\2\2\2\64\u023d"+
		"\3\2\2\2\66\u0249\3\2\2\28\u0253\3\2\2\2:\u025d\3\2\2\2<\u0267\3\2\2\2"+
		">\u0271\3\2\2\2@\u027b\3\2\2\2B\u028a\3\2\2\2D\u028c\3\2\2\2F\u0293\3"+
		"\2\2\2H\u02b6\3\2\2\2J\u02f0\3\2\2\2L\u02fa\3\2\2\2N\u0301\3\2\2\2P\u0309"+
		"\3\2\2\2R\u030b\3\2\2\2T\u030d\3\2\2\2V\u030f\3\2\2\2X\u0311\3\2\2\2Z"+
		"\\\7:\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2"+
		"`a\5\4\3\2ab\5\b\5\2b\3\3\2\2\2cd\5N(\2df\5\6\4\2eg\7:\2\2fe\3\2\2\2g"+
		"h\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jc\3\2\2\2kn\3\2\2\2lj\3\2\2\2"+
		"lm\3\2\2\2m\5\3\2\2\2nl\3\2\2\2op\7=\2\2pv\b\4\1\2qr\7\63\2\2rs\7=\2\2"+
		"su\b\4\1\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2"+
		"y{\7\64\2\2zy\3\2\2\2z{\3\2\2\2{\7\3\2\2\2|\u0080\5\n\6\2}\177\7:\2\2"+
		"~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083|\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\t\3\2\2\2\u0087\u0085\3"+
		"\2\2\2\u0088\u0089\7\3\2\2\u0089\u008a\7<\2\2\u008a\u008e\b\6\1\2\u008b"+
		"\u008c\7&\2\2\u008c\u008d\7<\2\2\u008d\u008f\b\6\1\2\u008e\u008b\3\2\2"+
		"\2\u008e\u008f\3\2\2\2\u008f\u0093\3\2\2\2\u0090\u0092\7:\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\7\61\2\2\u0097\u0099\7"+
		":\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\5\f\7\2\u009d\u009f\7\62"+
		"\2\2\u009e\u00a0\7\64\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a4\3\2\2\2\u00a1\u00a3\7:\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00b7\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a8\7\3\2\2\u00a8\u00a9\7<\2\2\u00a9\u00ad\b\6"+
		"\1\2\u00aa\u00ab\7&\2\2\u00ab\u00ac\7<\2\2\u00ac\u00ae\b\6\1\2\u00ad\u00aa"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\7:\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\5\16\b\2\u00b6"+
		"\u0088\3\2\2\2\u00b6\u00a7\3\2\2\2\u00b7\13\3\2\2\2\u00b8\u00bb\5\20\t"+
		"\2\u00b9\u00bb\5\22\n\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\r\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00bf\u00c2\5\20\t\2\u00c0\u00c2\5\22\n\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\17\3\2\2\2\u00c3\u00c4\t\2\2\2\u00c4"+
		"\u00c6\5\"\22\2\u00c5\u00c7\7\64\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\21\3\2\2\2\u00c8\u00ce\t\2\2\2\u00c9\u00ca\5P)\2\u00ca\u00cb"+
		"\7=\2\2\u00cb\u00cc\b\n\1\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\7\13\2\2\u00ce"+
		"\u00c9\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d4\7-"+
		"\2\2\u00d1\u00d3\5\24\13\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d7\u00db\7.\2\2\u00d8\u00da\7:\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e2\5\26\f\2\u00df\u00e1\7:\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\23\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\5N(\2\u00e6\u00e9\7=\2\2\u00e7"+
		"\u00e8\7\"\2\2\u00e8\u00ea\5L\'\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f7\b\13\1\2\u00ec\u00ed\7\63\2\2\u00ed"+
		"\u00ee\5N(\2\u00ee\u00f1\7=\2\2\u00ef\u00f0\7\"\2\2\u00f0\u00f2\5L\'\2"+
		"\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\b\13\1\2\u00f4\u00f6\3\2\2\2\u00f5\u00ec\3\2\2\2\u00f6\u00f9\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\25\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00fa\u00fe\7\61\2\2\u00fb\u00fd\7:\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0104\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\5\"\22\2\u0102\u0101\3\2\2\2\u0103"+
		"\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010a\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0107\u0109\7:\2\2\u0108\u0107\3\2\2\2\u0109"+
		"\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010d\u010f\7\62\2\2\u010e\u0110\7\64\2\2\u010f"+
		"\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0114\3\2\2\2\u0111\u0112\7:"+
		"\2\2\u0112\u0114\5\"\22\2\u0113\u00fa\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\27\3\2\2\2\u0115\u0116\7\16\2\2\u0116\u0117\b\r\1\2\u0117\u0118\5\60"+
		"\31\2\u0118\31\3\2\2\2\u0119\u011a\7=\2\2\u011a\u0128\b\16\1\2\u011b\u011d"+
		"\t\3\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\7/\2\2\u011f\u0120\5\60\31\2\u0120\u0124\7\60\2\2\u0121\u0123\5"+
		"\32\16\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0119\3\2"+
		"\2\2\u0127\u011c\3\2\2\2\u0128\33\3\2\2\2\u0129\u012a\7\b\2\2\u012a\u012b"+
		"\7&\2\2\u012b\u0130\5P)\2\u012c\u012d\7\63\2\2\u012d\u012f\5P)\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7\66\2\2\u0134"+
		"\u0135\5P)\2\u0135\u0138\7%\2\2\u0136\u0137\7=\2\2\u0137\u0139\b\17\1"+
		"\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u013c"+
		"\7\64\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\35\3\2\2\2\u013d"+
		"\u013e\7\t\2\2\u013e\u013f\7&\2\2\u013f\u0140\7\6\2\2\u0140\u0141\7%\2"+
		"\2\u0141\37\3\2\2\2\u0142\u0144\7\61\2\2\u0143\u0145\7:\2\2\u0144\u0143"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u014b\3\2\2\2\u0148\u014a\5\"\22\2\u0149\u0148\3\2\2\2\u014a\u014d\3"+
		"\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u0151\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014e\u0150\7:\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u015e\7\62\2\2\u0155\u0156\7:\2\2\u0156\u015a\5\""+
		"\22\2\u0157\u0159\7:\2\2\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u0142\3\2\2\2\u015d\u0155\3\2\2\2\u015e!\3\2\2\2\u015f\u0163"+
		"\5,\27\2\u0160\u0162\7:\2\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0191\3\2\2\2\u0165\u0163\3\2"+
		"\2\2\u0166\u016a\5.\30\2\u0167\u0169\7:\2\2\u0168\u0167\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0191\3\2"+
		"\2\2\u016c\u016a\3\2\2\2\u016d\u0171\5J&\2\u016e\u0170\7:\2\2\u016f\u016e"+
		"\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0191\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0178\5(\25\2\u0175\u0177\7:"+
		"\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u0191\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017f\5*"+
		"\26\2\u017c\u017e\7:\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0191\3\2\2\2\u0181\u017f\3\2"+
		"\2\2\u0182\u0186\5\62\32\2\u0183\u0185\7:\2\2\u0184\u0183\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0191\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0189\u018d\5\30\r\2\u018a\u018c\7:\2\2\u018b"+
		"\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2"+
		"\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u015f\3\2\2\2\u0190"+
		"\u0166\3\2\2\2\u0190\u016d\3\2\2\2\u0190\u0174\3\2\2\2\u0190\u017b\3\2"+
		"\2\2\u0190\u0182\3\2\2\2\u0190\u0189\3\2\2\2\u0191#\3\2\2\2\u0192\u0195"+
		"\5\60\31\2\u0193\u0195\5\62\32\2\u0194\u0192\3\2\2\2\u0194\u0193\3\2\2"+
		"\2\u0195\u019d\3\2\2\2\u0196\u0199\7\63\2\2\u0197\u019a\5\60\31\2\u0198"+
		"\u019a\5\62\32\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019c\3"+
		"\2\2\2\u019b\u0196\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u01a2\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a2\3\2"+
		"\2\2\u01a1\u0194\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2%\3\2\2\2\u01a3\u01a8"+
		"\5\60\31\2\u01a4\u01a5\7\63\2\2\u01a5\u01a7\5\60\31\2\u01a6\u01a4\3\2"+
		"\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01ad\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01a3\3\2"+
		"\2\2\u01ac\u01ab\3\2\2\2\u01ad\'\3\2\2\2\u01ae\u01af\b\25\1\2\u01af\u01c2"+
		"\5F$\2\u01b0\u01b1\7\34\2\2\u01b1\u01b6\7=\2\2\u01b2\u01b3\7-\2\2\u01b3"+
		"\u01b4\5$\23\2\u01b4\u01b5\7.\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b2\3\2"+
		"\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01c1\3\2\2\2\u01ba\u01bb\7\34\2\2\u01bb\u01c1\7=\2\2\u01bc\u01bd\7/"+
		"\2\2\u01bd\u01be\5\60\31\2\u01be\u01bf\7\60\2\2\u01bf\u01c1\3\2\2\2\u01c0"+
		"\u01b0\3\2\2\2\u01c0\u01ba\3\2\2\2\u01c0\u01bc\3\2\2\2\u01c1\u01c4\3\2"+
		"\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c7\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01c6\7\34\2\2\u01c6\u01c8\t\4\2\2\u01c7\u01c5\3"+
		"\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cd\3\2\2\2\u01c9\u01ca\7-\2\2\u01ca"+
		"\u01cb\5$\23\2\u01cb\u01cc\7.\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01c9\3\2"+
		"\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d2\3\2\2\2\u01d1\u01d3\7\64\2\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3\3"+
		"\2\2\2\u01d3)\3\2\2\2\u01d4\u01de\7=\2\2\u01d5\u01de\5\32\16\2\u01d6\u01de"+
		"\5\34\17\2\u01d7\u01de\5\36\20\2\u01d8\u01d9\5N(\2\u01d9\u01da\5\6\4\2"+
		"\u01da\u01de\3\2\2\2\u01db\u01dc\7<\2\2\u01dc\u01de\5\6\4\2\u01dd\u01d4"+
		"\3\2\2\2\u01dd\u01d5\3\2\2\2\u01dd\u01d6\3\2\2\2\u01dd\u01d7\3\2\2\2\u01dd"+
		"\u01d8\3\2\2\2\u01dd\u01db\3\2\2\2\u01de+\3\2\2\2\u01df\u01e0\7\23\2\2"+
		"\u01e0\u01e1\b\27\1\2\u01e1\u01e5\5\60\31\2\u01e2\u01e4\7:\2\2\u01e3\u01e2"+
		"\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e8\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01ec\5 \21\2\u01e9\u01eb\7:"+
		"\2\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed\u0201\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f0\7\25"+
		"\2\2\u01f0\u01f1\b\27\1\2\u01f1\u01f5\5\60\31\2\u01f2\u01f4\7:\2\2\u01f3"+
		"\u01f2\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2"+
		"\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01fc\5 \21\2\u01f9"+
		"\u01fb\7:\2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff"+
		"\u01ef\3\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2"+
		"\2\2\u0202\u0207\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0206\7:\2\2\u0205"+
		"\u0204\3\2\2\2\u0206\u0209\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2"+
		"\2\2\u0208\u0213\3\2\2\2\u0209\u0207\3\2\2\2\u020a\u020b\7\24\2\2\u020b"+
		"\u020f\b\27\1\2\u020c\u020e\7:\2\2\u020d\u020c\3\2\2\2\u020e\u0211\3\2"+
		"\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211"+
		"\u020f\3\2\2\2\u0212\u0214\5 \21\2\u0213\u020a\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214-\3\2\2\2\u0215\u0216\7-\2\2\u0216\u0217\5\60\31\2\u0217\u0218"+
		"\7\34\2\2\u0218\u0219\7\34\2\2\u0219\u021a\5\60\31\2\u021a\u021b\7.\2"+
		"\2\u021b\u021e\3\2\2\2\u021c\u021e\7=\2\2\u021d\u0215\3\2\2\2\u021d\u021c"+
		"\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\7\34\2\2\u0220\u0221\7\20\2\2"+
		"\u0221\u0222\b\30\1\2\u0222\u0223\7\21\2\2\u0223\u0224\7\67\2\2\u0224"+
		"\u0225\7=\2\2\u0225\u0226\7\67\2\2\u0226\u0227\5 \21\2\u0227/\3\2\2\2"+
		"\u0228\u022d\5\64\33\2\u0229\u022a\7\"\2\2\u022a\u022b\5\60\31\2\u022b"+
		"\u022c\b\31\1\2\u022c\u022e\3\2\2\2\u022d\u0229\3\2\2\2\u022d\u022e\3"+
		"\2\2\2\u022e\u0235\3\2\2\2\u022f\u0232\5\64\33\2\u0230\u0231\7\63\2\2"+
		"\u0231\u0233\5\60\31\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235"+
		"\3\2\2\2\u0234\u0228\3\2\2\2\u0234\u022f\3\2\2\2\u0235\61\3\2\2\2\u0236"+
		"\u023b\5\64\33\2\u0237\u0238\7\"\2\2\u0238\u0239\5\60\31\2\u0239\u023a"+
		"\b\32\1\2\u023a\u023c\3\2\2\2\u023b\u0237\3\2\2\2\u023b\u023c\3\2\2\2"+
		"\u023c\63\3\2\2\2\u023d\u0246\5\66\34\2\u023e\u023f\7+\2\2\u023f\u0240"+
		"\5\60\31\2\u0240\u0241\7,\2\2\u0241\u0242\5\60\31\2\u0242\u0243\b\33\1"+
		"\2\u0243\u0245\3\2\2\2\u0244\u023e\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244"+
		"\3\2\2\2\u0246\u0247\3\2\2\2\u0247\65\3\2\2\2\u0248\u0246\3\2\2\2\u0249"+
		"\u0250\58\35\2\u024a\u024b\7)\2\2\u024b\u024c\58\35\2\u024c\u024d\b\34"+
		"\1\2\u024d\u024f\3\2\2\2\u024e\u024a\3\2\2\2\u024f\u0252\3\2\2\2\u0250"+
		"\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\67\3\2\2\2\u0252\u0250\3\2\2"+
		"\2\u0253\u025a\5:\36\2\u0254\u0255\7(\2\2\u0255\u0256\5:\36\2\u0256\u0257"+
		"\b\35\1\2\u0257\u0259\3\2\2\2\u0258\u0254\3\2\2\2\u0259\u025c\3\2\2\2"+
		"\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b9\3\2\2\2\u025c\u025a\3"+
		"\2\2\2\u025d\u0264\5<\37\2\u025e\u025f\7\'\2\2\u025f\u0260\5<\37\2\u0260"+
		"\u0261\b\36\1\2\u0261\u0263\3\2\2\2\u0262\u025e\3\2\2\2\u0263\u0266\3"+
		"\2\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265;\3\2\2\2\u0266\u0264"+
		"\3\2\2\2\u0267\u026e\5> \2\u0268\u0269\t\5\2\2\u0269\u026a\5> \2\u026a"+
		"\u026b\b\37\1\2\u026b\u026d\3\2\2\2\u026c\u0268\3\2\2\2\u026d\u0270\3"+
		"\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f=\3\2\2\2\u0270\u026e"+
		"\3\2\2\2\u0271\u0278\5@!\2\u0272\u0273\t\6\2\2\u0273\u0274\5@!\2\u0274"+
		"\u0275\b \1\2\u0275\u0277\3\2\2\2\u0276\u0272\3\2\2\2\u0277\u027a\3\2"+
		"\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279?\3\2\2\2\u027a\u0278"+
		"\3\2\2\2\u027b\u0282\5B\"\2\u027c\u027d\t\7\2\2\u027d\u027e\5B\"\2\u027e"+
		"\u027f\b!\1\2\u027f\u0281\3\2\2\2\u0280\u027c\3\2\2\2\u0281\u0284\3\2"+
		"\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283A\3\2\2\2\u0284\u0282"+
		"\3\2\2\2\u0285\u0286\t\b\2\2\u0286\u0287\5B\"\2\u0287\u0288\b\"\1\2\u0288"+
		"\u028b\3\2\2\2\u0289\u028b\5D#\2\u028a\u0285\3\2\2\2\u028a\u0289\3\2\2"+
		"\2\u028bC\3\2\2\2\u028c\u0291\5F$\2\u028d\u028e\7#\2\2\u028e\u0292\b#"+
		"\1\2\u028f\u0290\7$\2\2\u0290\u0292\b#\1\2\u0291\u028d\3\2\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292E\3\2\2\2\u0293\u02a4\5H%\2\u0294\u0295"+
		"\7\34\2\2\u0295\u0297\7=\2\2\u0296\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u0299\7-\2\2\u0299\u029a\5&\24\2\u029a\u029b\7.\2"+
		"\2\u029b\u02a3\3\2\2\2\u029c\u029d\7\34\2\2\u029d\u02a3\7=\2\2\u029e\u029f"+
		"\7/\2\2\u029f\u02a0\5\60\31\2\u02a0\u02a1\7\60\2\2\u02a1\u02a3\3\2\2\2"+
		"\u02a2\u0296\3\2\2\2\u02a2\u029c\3\2\2\2\u02a2\u029e\3\2\2\2\u02a3\u02a6"+
		"\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6"+
		"\u02a4\3\2\2\2\u02a7\u02a9\7\64\2\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3"+
		"\2\2\2\u02a9G\3\2\2\2\u02aa\u02b7\5L\'\2\u02ab\u02b7\5J&\2\u02ac\u02b7"+
		"\7=\2\2\u02ad\u02ae\7-\2\2\u02ae\u02af\5\60\31\2\u02af\u02b0\7.\2\2\u02b0"+
		"\u02b7\3\2\2\2\u02b1\u02b2\7=\2\2\u02b2\u02b3\7/\2\2\u02b3\u02b4\5\60"+
		"\31\2\u02b4\u02b5\7\60\2\2\u02b5\u02b7\3\2\2\2\u02b6\u02aa\3\2\2\2\u02b6"+
		"\u02ab\3\2\2\2\u02b6\u02ac\3\2\2\2\u02b6\u02ad\3\2\2\2\u02b6\u02b1\3\2"+
		"\2\2\u02b7I\3\2\2\2\u02b8\u02b9\7\17\2\2\u02b9\u02ba\b&\1\2\u02ba\u02bb"+
		"\7-\2\2\u02bb\u02bc\5\60\31\2\u02bc\u02be\7.\2\2\u02bd\u02bf\7\64\2\2"+
		"\u02be\u02bd\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02f1\3\2\2\2\u02c0\u02c1"+
		"\t\t\2\2\u02c1\u02c2\7\34\2\2\u02c2\u02c3\7\22\2\2\u02c3\u02c4\b&\1\2"+
		"\u02c4\u02c6\7-\2\2\u02c5\u02c7\5\60\31\2\u02c6\u02c5\3\2\2\2\u02c6\u02c7"+
		"\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02ca\7.\2\2\u02c9\u02cb\7\64\2\2\u02ca"+
		"\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02f1\3\2\2\2\u02cc\u02cd\7="+
		"\2\2\u02cd\u02ce\7\34\2\2\u02ce\u02cf\7\32\2\2\u02cf\u02d0\b&\1\2\u02d0"+
		"\u02d1\7-\2\2\u02d1\u02d2\5\60\31\2\u02d2\u02d4\7.\2\2\u02d3\u02d5\7\64"+
		"\2\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02f1\3\2\2\2\u02d6"+
		"\u02d7\7=\2\2\u02d7\u02d8\7\34\2\2\u02d8\u02d9\7\33\2\2\u02d9\u02da\b"+
		"&\1\2\u02da\u02dc\7-\2\2\u02db\u02dd\5\60\31\2\u02dc\u02db\3\2\2\2\u02dc"+
		"\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e0\7.\2\2\u02df\u02e1\7\64"+
		"\2\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02f1\3\2\2\2\u02e2"+
		"\u02e3\7=\2\2\u02e3\u02e8\7\34\2\2\u02e4\u02e5\7\30\2\2\u02e5\u02e9\b"+
		"&\1\2\u02e6\u02e7\7\31\2\2\u02e7\u02e9\b&\1\2\u02e8\u02e4\3\2\2\2\u02e8"+
		"\u02e6\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\7-\2\2\u02eb\u02ec\5\60"+
		"\31\2\u02ec\u02ee\7.\2\2\u02ed\u02ef\7\64\2\2\u02ee\u02ed\3\2\2\2\u02ee"+
		"\u02ef\3\2\2\2\u02ef\u02f1\3\2\2\2\u02f0\u02b8\3\2\2\2\u02f0\u02c0\3\2"+
		"\2\2\u02f0\u02cc\3\2\2\2\u02f0\u02d6\3\2\2\2\u02f0\u02e2\3\2\2\2\u02f1"+
		"K\3\2\2\2\u02f2\u02fb\7>\2\2\u02f3\u02fb\7\n\2\2\u02f4\u02fb\7=\2\2\u02f5"+
		"\u02fb\5X-\2\u02f6\u02fb\7:\2\2\u02f7\u02fb\7<\2\2\u02f8\u02fb\7\t\2\2"+
		"\u02f9\u02fb\7\13\2\2\u02fa\u02f2\3\2\2\2\u02fa\u02f3\3\2\2\2\u02fa\u02f4"+
		"\3\2\2\2\u02fa\u02f5\3\2\2\2\u02fa\u02f6\3\2\2\2\u02fa\u02f7\3\2\2\2\u02fa"+
		"\u02f8\3\2\2\2\u02fa\u02f9\3\2\2\2\u02fbM\3\2\2\2\u02fc\u0302\7\6\2\2"+
		"\u02fd\u0302\7\7\2\2\u02fe\u0302\5\34\17\2\u02ff\u0302\5\36\20\2\u0300"+
		"\u0302\5\32\16\2\u0301\u02fc\3\2\2\2\u0301\u02fd\3\2\2\2\u0301\u02fe\3"+
		"\2\2\2\u0301\u02ff\3\2\2\2\u0301\u0300\3\2\2\2\u0302O\3\2\2\2\u0303\u030a"+
		"\7\6\2\2\u0304\u030a\7\7\2\2\u0305\u030a\7\26\2\2\u0306\u030a\5\34\17"+
		"\2\u0307\u030a\7\t\2\2\u0308\u030a\5\32\16\2\u0309\u0303\3\2\2\2\u0309"+
		"\u0304\3\2\2\2\u0309\u0305\3\2\2\2\u0309\u0306\3\2\2\2\u0309\u0307\3\2"+
		"\2\2\u0309\u0308\3\2\2\2\u030aQ\3\2\2\2\u030b\u030c\t\6\2\2\u030cS\3\2"+
		"\2\2\u030d\u030e\t\7\2\2\u030eU\3\2\2\2\u030f\u0310\t\n\2\2\u0310W\3\2"+
		"\2\2\u0311\u0312\t\13\2\2\u0312Y\3\2\2\2h]hlvz\u0080\u0085\u008e\u0093"+
		"\u009a\u009f\u00a4\u00ad\u00b2\u00b6\u00ba\u00bc\u00c1\u00c6\u00ce\u00d4"+
		"\u00db\u00e2\u00e9\u00f1\u00f7\u00fe\u0104\u010a\u010f\u0113\u011c\u0124"+
		"\u0127\u0130\u0138\u013b\u0146\u014b\u0151\u015a\u015d\u0163\u016a\u0171"+
		"\u0178\u017f\u0186\u018d\u0190\u0194\u0199\u019d\u01a1\u01a8\u01ac\u01b8"+
		"\u01c0\u01c2\u01c7\u01cf\u01d2\u01dd\u01e5\u01ec\u01f5\u01fc\u0201\u0207"+
		"\u020f\u0213\u021d\u022d\u0232\u0234\u023b\u0246\u0250\u025a\u0264\u026e"+
		"\u0278\u0282\u028a\u0291\u0296\u02a2\u02a4\u02a8\u02b6\u02be\u02c6\u02ca"+
		"\u02d4\u02dc\u02e0\u02e8\u02ee\u02f0\u02fa\u0301\u0309";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}