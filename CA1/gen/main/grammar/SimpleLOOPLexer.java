// Generated from /Users/ali_akhgary/Desktop/Term6.tmp/Compiler/CA/1/src/main/grammar/SimpleLOOP.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLOOPLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Class", "Private", "Public", "Int", "Bool", "Fptr", "Set", "Self", "Initialize", 
			"True", "False", "Return", "Print", "Each", "Do", "New", "If", "Else", 
			"Elseif", "Void", "Null", "Delete", "Include", "Add", "Merge", "Dot", 
			"Plus", "Minus", "Mult", "Div", "DoubleSlash", "Assign", "Increment", 
			"Decrement", "GreaterThan", "LessThan", "Equals", "And", "Or", "Not", 
			"QuestionMark", "Colon", "LPar", "RPar", "LBracket", "RBracket", "LBrace", 
			"RBrace", "Comma", "SemiCollon", "Hashtag", "Arrow", "OneOr", "CommentBegin", 
			"CommentEnd", "Newline", "WS", "ClassIdentifier", "Identifier", "Number", 
			"COMMENT", "LINE_COMMENT", "NEWLINE_SKIP"
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


	    void print(String str, Boolean... params){
	        assert params.length <= 1;
	        boolean inline = params.length > 0 ? params[0].booleanValue() : false;
	        if (inline) {
	            System.out.print(str);
	        } else
	            System.out.println(str);
	    }


	public SimpleLOOPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLOOP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01a1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\3:\6:\u015c\n:\r:\16:\u015d"+
		"\3:\3:\3;\3;\7;\u0164\n;\f;\16;\u0167\13;\3<\3<\7<\u016b\n<\f<\16<\u016e"+
		"\13<\3=\6=\u0171\n=\r=\16=\u0172\3>\3>\3>\3>\3>\3>\3>\3>\3>\7>\u017e\n"+
		">\f>\16>\u0181\13>\3>\3>\3>\3>\3>\3>\3>\3?\3?\7?\u018c\n?\f?\16?\u018f"+
		"\13?\3?\3?\3?\3?\3@\3@\3@\3@\7@\u0199\n@\f@\16@\u019c\13@\3@\3@\3@\3@"+
		"\5\u017f\u018d\u019a\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\b\4\2\f\f\17\17\4\2\13"+
		"\13\"\"\3\2C\\\6\2\62;C\\aac|\5\2C\\aac|\3\2\62;\2\u01a8\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0087\3\2\2\2\7\u008f\3\2\2\2\t"+
		"\u0096\3\2\2\2\13\u009a\3\2\2\2\r\u009f\3\2\2\2\17\u00a4\3\2\2\2\21\u00a8"+
		"\3\2\2\2\23\u00ad\3\2\2\2\25\u00b8\3\2\2\2\27\u00bd\3\2\2\2\31\u00c3\3"+
		"\2\2\2\33\u00ca\3\2\2\2\35\u00d0\3\2\2\2\37\u00d5\3\2\2\2!\u00d8\3\2\2"+
		"\2#\u00dc\3\2\2\2%\u00df\3\2\2\2\'\u00e4\3\2\2\2)\u00ea\3\2\2\2+\u00ef"+
		"\3\2\2\2-\u00f4\3\2\2\2/\u00fb\3\2\2\2\61\u0103\3\2\2\2\63\u0107\3\2\2"+
		"\2\65\u010d\3\2\2\2\67\u010f\3\2\2\29\u0111\3\2\2\2;\u0113\3\2\2\2=\u0115"+
		"\3\2\2\2?\u0117\3\2\2\2A\u011a\3\2\2\2C\u011c\3\2\2\2E\u011f\3\2\2\2G"+
		"\u0122\3\2\2\2I\u0124\3\2\2\2K\u0126\3\2\2\2M\u0129\3\2\2\2O\u012c\3\2"+
		"\2\2Q\u012f\3\2\2\2S\u0131\3\2\2\2U\u0133\3\2\2\2W\u0135\3\2\2\2Y\u0137"+
		"\3\2\2\2[\u0139\3\2\2\2]\u013b\3\2\2\2_\u013d\3\2\2\2a\u013f\3\2\2\2c"+
		"\u0141\3\2\2\2e\u0143\3\2\2\2g\u0145\3\2\2\2i\u0147\3\2\2\2k\u014a\3\2"+
		"\2\2m\u014c\3\2\2\2o\u0153\3\2\2\2q\u0158\3\2\2\2s\u015b\3\2\2\2u\u0161"+
		"\3\2\2\2w\u0168\3\2\2\2y\u0170\3\2\2\2{\u0174\3\2\2\2}\u0189\3\2\2\2\177"+
		"\u0194\3\2\2\2\u0081\u0082\7e\2\2\u0082\u0083\7n\2\2\u0083\u0084\7c\2"+
		"\2\u0084\u0085\7u\2\2\u0085\u0086\7u\2\2\u0086\4\3\2\2\2\u0087\u0088\7"+
		"r\2\2\u0088\u0089\7t\2\2\u0089\u008a\7k\2\2\u008a\u008b\7x\2\2\u008b\u008c"+
		"\7c\2\2\u008c\u008d\7v\2\2\u008d\u008e\7g\2\2\u008e\6\3\2\2\2\u008f\u0090"+
		"\7r\2\2\u0090\u0091\7w\2\2\u0091\u0092\7d\2\2\u0092\u0093\7n\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7e\2\2\u0095\b\3\2\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7p\2\2\u0098\u0099\7v\2\2\u0099\n\3\2\2\2\u009a\u009b\7d\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7q\2\2\u009d\u009e\7n\2\2\u009e\f\3\2\2\2\u009f"+
		"\u00a0\7h\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7t\2\2"+
		"\u00a3\16\3\2\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7"+
		"v\2\2\u00a7\20\3\2\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7n\2\2\u00ab\u00ac\7h\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7p\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7k\2\2\u00b2"+
		"\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7|\2\2"+
		"\u00b6\u00b7\7g\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7"+
		"t\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7g\2\2\u00bc\26\3\2\2\2\u00bd\u00be"+
		"\7h\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\30\3\2\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7p\2\2"+
		"\u00c9\32\3\2\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7"+
		"k\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7v\2\2\u00cf\34\3\2\2\2\u00d0\u00d1"+
		"\7g\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7e\2\2\u00d3\u00d4\7j\2\2\u00d4"+
		"\36\3\2\2\2\u00d5\u00d6\7f\2\2\u00d6\u00d7\7q\2\2\u00d7 \3\2\2\2\u00d8"+
		"\u00d9\7p\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7y\2\2\u00db\"\3\2\2\2\u00dc"+
		"\u00dd\7k\2\2\u00dd\u00de\7h\2\2\u00de$\3\2\2\2\u00df\u00e0\7g\2\2\u00e0"+
		"\u00e1\7n\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3&\3\2\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7k\2\2"+
		"\u00e8\u00e9\7h\2\2\u00e9(\3\2\2\2\u00ea\u00eb\7x\2\2\u00eb\u00ec\7q\2"+
		"\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7f\2\2\u00ee*\3\2\2\2\u00ef\u00f0\7"+
		"p\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7n\2\2\u00f3,"+
		"\3\2\2\2\u00f4\u00f5\7f\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7n\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7g\2\2\u00fa.\3\2\2\2\u00fb"+
		"\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7n\2\2"+
		"\u00ff\u0100\7w\2\2\u0100\u0101\7f\2\2\u0101\u0102\7g\2\2\u0102\60\3\2"+
		"\2\2\u0103\u0104\7c\2\2\u0104\u0105\7f\2\2\u0105\u0106\7f\2\2\u0106\62"+
		"\3\2\2\2\u0107\u0108\7o\2\2\u0108\u0109\7g\2\2\u0109\u010a\7t\2\2\u010a"+
		"\u010b\7i\2\2\u010b\u010c\7g\2\2\u010c\64\3\2\2\2\u010d\u010e\7\60\2\2"+
		"\u010e\66\3\2\2\2\u010f\u0110\7-\2\2\u01108\3\2\2\2\u0111\u0112\7/\2\2"+
		"\u0112:\3\2\2\2\u0113\u0114\7,\2\2\u0114<\3\2\2\2\u0115\u0116\7\61\2\2"+
		"\u0116>\3\2\2\2\u0117\u0118\7\61\2\2\u0118\u0119\7\61\2\2\u0119@\3\2\2"+
		"\2\u011a\u011b\7?\2\2\u011bB\3\2\2\2\u011c\u011d\7-\2\2\u011d\u011e\7"+
		"-\2\2\u011eD\3\2\2\2\u011f\u0120\7/\2\2\u0120\u0121\7/\2\2\u0121F\3\2"+
		"\2\2\u0122\u0123\7@\2\2\u0123H\3\2\2\2\u0124\u0125\7>\2\2\u0125J\3\2\2"+
		"\2\u0126\u0127\7?\2\2\u0127\u0128\7?\2\2\u0128L\3\2\2\2\u0129\u012a\7"+
		"(\2\2\u012a\u012b\7(\2\2\u012bN\3\2\2\2\u012c\u012d\7~\2\2\u012d\u012e"+
		"\7~\2\2\u012eP\3\2\2\2\u012f\u0130\7#\2\2\u0130R\3\2\2\2\u0131\u0132\7"+
		"A\2\2\u0132T\3\2\2\2\u0133\u0134\7<\2\2\u0134V\3\2\2\2\u0135\u0136\7*"+
		"\2\2\u0136X\3\2\2\2\u0137\u0138\7+\2\2\u0138Z\3\2\2\2\u0139\u013a\7]\2"+
		"\2\u013a\\\3\2\2\2\u013b\u013c\7_\2\2\u013c^\3\2\2\2\u013d\u013e\7}\2"+
		"\2\u013e`\3\2\2\2\u013f\u0140\7\177\2\2\u0140b\3\2\2\2\u0141\u0142\7."+
		"\2\2\u0142d\3\2\2\2\u0143\u0144\7=\2\2\u0144f\3\2\2\2\u0145\u0146\7%\2"+
		"\2\u0146h\3\2\2\2\u0147\u0148\7/\2\2\u0148\u0149\7@\2\2\u0149j\3\2\2\2"+
		"\u014a\u014b\7~\2\2\u014bl\3\2\2\2\u014c\u014d\7?\2\2\u014d\u014e\7d\2"+
		"\2\u014e\u014f\7g\2\2\u014f\u0150\7i\2\2\u0150\u0151\7k\2\2\u0151\u0152"+
		"\7p\2\2\u0152n\3\2\2\2\u0153\u0154\7?\2\2\u0154\u0155\7g\2\2\u0155\u0156"+
		"\7p\2\2\u0156\u0157\7f\2\2\u0157p\3\2\2\2\u0158\u0159\t\2\2\2\u0159r\3"+
		"\2\2\2\u015a\u015c\t\3\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\b:"+
		"\2\2\u0160t\3\2\2\2\u0161\u0165\t\4\2\2\u0162\u0164\t\5\2\2\u0163\u0162"+
		"\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"v\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u016c\t\6\2\2\u0169\u016b\t\5\2\2"+
		"\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016dx\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171\t\7\2\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173z\3\2\2\2\u0174\u0175\7?\2\2\u0175\u0176\7d\2\2\u0176\u0177"+
		"\7g\2\2\u0177\u0178\7i\2\2\u0178\u0179\7k\2\2\u0179\u017a\7p\2\2\u017a"+
		"\u017f\3\2\2\2\u017b\u017e\5{>\2\u017c\u017e\13\2\2\2\u017d\u017b\3\2"+
		"\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7?"+
		"\2\2\u0183\u0184\7g\2\2\u0184\u0185\7p\2\2\u0185\u0186\7f\2\2\u0186\u0187"+
		"\3\2\2\2\u0187\u0188\b>\2\2\u0188|\3\2\2\2\u0189\u018d\7%\2\2\u018a\u018c"+
		"\13\2\2\2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018e\3\2\2\2"+
		"\u018d\u018b\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191"+
		"\7\f\2\2\u0191\u0192\3\2\2\2\u0192\u0193\b?\2\2\u0193~\3\2\2\2\u0194\u0195"+
		"\7\61\2\2\u0195\u0196\7\61\2\2\u0196\u019a\3\2\2\2\u0197\u0199\13\2\2"+
		"\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u019b\3\2\2\2\u019a\u0198"+
		"\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7\f\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a0\b@\2\2\u01a0\u0080\3\2\2\2\13\2\u015d\u0165"+
		"\u016c\u0172\u017d\u017f\u018d\u019a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}