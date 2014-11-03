// Generated from ./BasicLexer.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIV=1, MUL=2, MOD=3, PLUS=4, MINUS=5, GRT=6, GRTEQ=7, SMT=8, SMTEQ=9, 
		EQEQ=10, NOTEQ=11, AND=12, OR=13, NOT=14, LEN=15, ORD=16, CHR=17, WS=18, 
		EQ=19, OPEN_PARENTHESES=20, CLOSE_PARENTHESES=21, OPEN_SQUAREB=22, CLOSE_SQUAREB=23, 
		BEGIN=24, END=25, SKIP=26, READ=27, IS=28, FREE=29, RETURN=30, EXIT=31, 
		PRINT=32, PRINTLN=33, IF=34, THEN=35, ELSE=36, FI=37, DO=38, DONE=39, 
		SEMICOLON=40, COMMA=41, NEWPAIR=42, CALL=43, FST=44, SND=45, PAIR=46, 
		WHILE=47, COMMENT=48, BOOL_LITER=49, BASE_TYPE=50, INT_LITER=51, INTEGER=52, 
		CHAR_LITER=53, STR_LITER=54, IDENT=55, PAIR_LITER=56;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'"
	};
	public static final String[] ruleNames = {
		"DIV", "MUL", "MOD", "PLUS", "MINUS", "GRT", "GRTEQ", "SMT", "SMTEQ", 
		"EQEQ", "NOTEQ", "AND", "OR", "NOT", "LEN", "ORD", "CHR", "WS", "EOL", 
		"EQ", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", "OPEN_SQUAREB", "CLOSE_SQUAREB", 
		"BEGIN", "END", "SKIP", "READ", "IS", "FREE", "RETURN", "EXIT", "PRINT", 
		"PRINTLN", "IF", "THEN", "ELSE", "FI", "DO", "DONE", "SEMICOLON", "COMMA", 
		"NEWPAIR", "CALL", "FST", "SND", "PAIR", "WHILE", "COMMENT", "BOOL_LITER", 
		"BASE_TYPE", "INT_LITER", "INTEGER", "CHARACTER", "CHAR_LITER", "STR_LITER", 
		"ESCAPED_CHAR", "IDENT", "DIGIT", "PAIR_LITER"
	};


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2:\u0199\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\5\24\u00af\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\7\62\u0131\n\62\f\62"+
		"\16\62\u0134\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\5\63\u0141\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0154\n\64\3\65\5\65\u0157\n"+
		"\65\3\65\6\65\u015a\n\65\r\65\16\65\u015b\3\66\6\66\u015f\n\66\r\66\16"+
		"\66\u0160\3\67\3\67\38\38\38\58\u0168\n8\38\38\39\39\39\79\u016f\n9\f"+
		"9\169\u0172\139\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\3:\3:\3:\5:\u0189\n:\3;\3;\3;\7;\u018e\n;\f;\16;\u0191\13;\3<\3<\3=\3"+
		"=\3=\3=\3=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\26-\27/\30\61\31\63\32\65\33"+
		"\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g"+
		"\64i\65k\66m\2o\67q8s\2u9w\2y:\3\2\b\6\2\13\f\17\17\"\"^^\4\2\f\f\17\17"+
		"\4\2--//\3\2\62;\5\2$$\61\61bb\5\2C\\aac|\u01ab\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2"+
		"\3{\3\2\2\2\5}\3\2\2\2\7\177\3\2\2\2\t\u0081\3\2\2\2\13\u0083\3\2\2\2"+
		"\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21\u008a\3\2\2\2\23\u008c\3\2\2\2\25"+
		"\u008f\3\2\2\2\27\u0092\3\2\2\2\31\u0095\3\2\2\2\33\u0098\3\2\2\2\35\u009b"+
		"\3\2\2\2\37\u009d\3\2\2\2!\u00a1\3\2\2\2#\u00a5\3\2\2\2%\u00a9\3\2\2\2"+
		"\'\u00ae\3\2\2\2)\u00b2\3\2\2\2+\u00b4\3\2\2\2-\u00b6\3\2\2\2/\u00b8\3"+
		"\2\2\2\61\u00ba\3\2\2\2\63\u00bc\3\2\2\2\65\u00c2\3\2\2\2\67\u00c6\3\2"+
		"\2\29\u00cb\3\2\2\2;\u00d0\3\2\2\2=\u00d3\3\2\2\2?\u00d8\3\2\2\2A\u00df"+
		"\3\2\2\2C\u00e4\3\2\2\2E\u00ea\3\2\2\2G\u00f2\3\2\2\2I\u00f5\3\2\2\2K"+
		"\u00fa\3\2\2\2M\u00ff\3\2\2\2O\u0102\3\2\2\2Q\u0105\3\2\2\2S\u010a\3\2"+
		"\2\2U\u010c\3\2\2\2W\u010e\3\2\2\2Y\u0116\3\2\2\2[\u011b\3\2\2\2]\u011f"+
		"\3\2\2\2_\u0123\3\2\2\2a\u0128\3\2\2\2c\u012e\3\2\2\2e\u0140\3\2\2\2g"+
		"\u0153\3\2\2\2i\u0156\3\2\2\2k\u015e\3\2\2\2m\u0162\3\2\2\2o\u0164\3\2"+
		"\2\2q\u016b\3\2\2\2s\u0188\3\2\2\2u\u018a\3\2\2\2w\u0192\3\2\2\2y\u0194"+
		"\3\2\2\2{|\7\61\2\2|\4\3\2\2\2}~\7,\2\2~\6\3\2\2\2\177\u0080\7\'\2\2\u0080"+
		"\b\3\2\2\2\u0081\u0082\7-\2\2\u0082\n\3\2\2\2\u0083\u0084\7/\2\2\u0084"+
		"\f\3\2\2\2\u0085\u0086\7@\2\2\u0086\16\3\2\2\2\u0087\u0088\7@\2\2\u0088"+
		"\u0089\7?\2\2\u0089\20\3\2\2\2\u008a\u008b\7>\2\2\u008b\22\3\2\2\2\u008c"+
		"\u008d\7>\2\2\u008d\u008e\7?\2\2\u008e\24\3\2\2\2\u008f\u0090\7?\2\2\u0090"+
		"\u0091\7?\2\2\u0091\26\3\2\2\2\u0092\u0093\7#\2\2\u0093\u0094\7?\2\2\u0094"+
		"\30\3\2\2\2\u0095\u0096\7(\2\2\u0096\u0097\7(\2\2\u0097\32\3\2\2\2\u0098"+
		"\u0099\7~\2\2\u0099\u009a\7~\2\2\u009a\34\3\2\2\2\u009b\u009c\7#\2\2\u009c"+
		"\36\3\2\2\2\u009d\u009e\7n\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7p\2\2\u00a0"+
		" \3\2\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7f\2\2\u00a4"+
		"\"\3\2\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7j\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"$\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\23\2\2"+
		"\u00ac&\3\2\2\2\u00ad\u00af\7\17\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\f\2\2\u00b1(\3\2\2\2\u00b2\u00b3"+
		"\7?\2\2\u00b3*\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5,\3\2\2\2\u00b6\u00b7\7"+
		"+\2\2\u00b7.\3\2\2\2\u00b8\u00b9\7]\2\2\u00b9\60\3\2\2\2\u00ba\u00bb\7"+
		"_\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7g\2\2\u00be\u00bf"+
		"\7i\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1\64\3\2\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7f\2\2\u00c5\66\3\2\2\2\u00c6\u00c7"+
		"\7u\2\2\u00c7\u00c8\7m\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7r\2\2\u00ca"+
		"8\3\2\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7f\2\2\u00cf:\3\2\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7u\2\2\u00d2"+
		"<\3\2\2\2\u00d3\u00d4\7h\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7g\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7>\3\2\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7g\2\2\u00da"+
		"\u00db\7v\2\2\u00db\u00dc\7w\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7p\2\2"+
		"\u00de@\3\2\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7z\2\2\u00e1\u00e2\7k\2"+
		"\2\u00e2\u00e3\7v\2\2\u00e3B\3\2\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6\7"+
		"t\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7v\2\2\u00e9D"+
		"\3\2\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7k\2\2\u00ed"+
		"\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7p\2\2"+
		"\u00f1F\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7h\2\2\u00f4H\3\2\2\2\u00f5"+
		"\u00f6\7v\2\2\u00f6\u00f7\7j\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2"+
		"\u00f9J\3\2\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7u\2"+
		"\2\u00fd\u00fe\7g\2\2\u00feL\3\2\2\2\u00ff\u0100\7h\2\2\u0100\u0101\7"+
		"k\2\2\u0101N\3\2\2\2\u0102\u0103\7f\2\2\u0103\u0104\7q\2\2\u0104P\3\2"+
		"\2\2\u0105\u0106\7f\2\2\u0106\u0107\7q\2\2\u0107\u0108\7p\2\2\u0108\u0109"+
		"\7g\2\2\u0109R\3\2\2\2\u010a\u010b\7=\2\2\u010bT\3\2\2\2\u010c\u010d\7"+
		".\2\2\u010dV\3\2\2\2\u010e\u010f\7p\2\2\u010f\u0110\7g\2\2\u0110\u0111"+
		"\7y\2\2\u0111\u0112\7r\2\2\u0112\u0113\7c\2\2\u0113\u0114\7k\2\2\u0114"+
		"\u0115\7t\2\2\u0115X\3\2\2\2\u0116\u0117\7e\2\2\u0117\u0118\7c\2\2\u0118"+
		"\u0119\7n\2\2\u0119\u011a\7n\2\2\u011aZ\3\2\2\2\u011b\u011c\7h\2\2\u011c"+
		"\u011d\7u\2\2\u011d\u011e\7v\2\2\u011e\\\3\2\2\2\u011f\u0120\7u\2\2\u0120"+
		"\u0121\7p\2\2\u0121\u0122\7f\2\2\u0122^\3\2\2\2\u0123\u0124\7r\2\2\u0124"+
		"\u0125\7c\2\2\u0125\u0126\7k\2\2\u0126\u0127\7t\2\2\u0127`\3\2\2\2\u0128"+
		"\u0129\7y\2\2\u0129\u012a\7j\2\2\u012a\u012b\7k\2\2\u012b\u012c\7n\2\2"+
		"\u012c\u012d\7g\2\2\u012db\3\2\2\2\u012e\u0132\7%\2\2\u012f\u0131\n\3"+
		"\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\b\62"+
		"\2\2\u0136d\3\2\2\2\u0137\u0138\7v\2\2\u0138\u0139\7t\2\2\u0139\u013a"+
		"\7w\2\2\u013a\u0141\7g\2\2\u013b\u013c\7h\2\2\u013c\u013d\7c\2\2\u013d"+
		"\u013e\7n\2\2\u013e\u013f\7u\2\2\u013f\u0141\7g\2\2\u0140\u0137\3\2\2"+
		"\2\u0140\u013b\3\2\2\2\u0141f\3\2\2\2\u0142\u0143\7k\2\2\u0143\u0144\7"+
		"p\2\2\u0144\u0154\7v\2\2\u0145\u0146\7d\2\2\u0146\u0147\7q\2\2\u0147\u0148"+
		"\7q\2\2\u0148\u0154\7n\2\2\u0149\u014a\7e\2\2\u014a\u014b\7j\2\2\u014b"+
		"\u014c\7c\2\2\u014c\u0154\7t\2\2\u014d\u014e\7u\2\2\u014e\u014f\7v\2\2"+
		"\u014f\u0150\7t\2\2\u0150\u0151\7k\2\2\u0151\u0152\7p\2\2\u0152\u0154"+
		"\7i\2\2\u0153\u0142\3\2\2\2\u0153\u0145\3\2\2\2\u0153\u0149\3\2\2\2\u0153"+
		"\u014d\3\2\2\2\u0154h\3\2\2\2\u0155\u0157\t\4\2\2\u0156\u0155\3\2\2\2"+
		"\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u015a\t\5\2\2\u0159\u0158"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"j\3\2\2\2\u015d\u015f\5w<\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161l\3\2\2\2\u0162\u0163\n\6\2\2"+
		"\u0163n\3\2\2\2\u0164\u0167\7)\2\2\u0165\u0168\5m\67\2\u0166\u0168\5s"+
		":\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016a\7)\2\2\u016ap\3\2\2\2\u016b\u0170\7$\2\2\u016c\u016f\5m\67\2\u016d"+
		"\u016f\5s:\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2"+
		"\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0173\u0174\7$\2\2\u0174r\3\2\2\2\u0175\u0176\7^\2\2\u0176\u0189"+
		"\7\62\2\2\u0177\u0178\7^\2\2\u0178\u0189\7d\2\2\u0179\u017a\7^\2\2\u017a"+
		"\u0189\7v\2\2\u017b\u017c\7^\2\2\u017c\u0189\7p\2\2\u017d\u017e\7^\2\2"+
		"\u017e\u0189\7h\2\2\u017f\u0180\7^\2\2\u0180\u0189\7t\2\2\u0181\u0189"+
		"\7^\2\2\u0182\u0183\7^\2\2\u0183\u0189\7^\2\2\u0184\u0185\7^\2\2\u0185"+
		"\u0189\7$\2\2\u0186\u0187\7^\2\2\u0187\u0189\7)\2\2\u0188\u0175\3\2\2"+
		"\2\u0188\u0177\3\2\2\2\u0188\u0179\3\2\2\2\u0188\u017b\3\2\2\2\u0188\u017d"+
		"\3\2\2\2\u0188\u017f\3\2\2\2\u0188\u0181\3\2\2\2\u0188\u0182\3\2\2\2\u0188"+
		"\u0184\3\2\2\2\u0188\u0186\3\2\2\2\u0189t\3\2\2\2\u018a\u018f\t\7\2\2"+
		"\u018b\u018e\t\7\2\2\u018c\u018e\5w<\2\u018d\u018b\3\2\2\2\u018d\u018c"+
		"\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"v\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\4\62;\2\u0193x\3\2\2\2\u0194"+
		"\u0195\7p\2\2\u0195\u0196\7w\2\2\u0196\u0197\7n\2\2\u0197\u0198\7n\2\2"+
		"\u0198z\3\2\2\2\20\2\u00ae\u0132\u0140\u0153\u0156\u015b\u0160\u0167\u016e"+
		"\u0170\u0188\u018d\u018f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}