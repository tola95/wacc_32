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
		INT=19, CHAR=20, STRING=21, EQ=22, OPEN_PARENTHESES=23, CLOSE_PARENTHESES=24, 
		OPEN_SQUAREB=25, CLOSE_SQUAREB=26, BEGIN=27, END=28, SKIP=29, READ=30, 
		IS=31, FREE=32, RETURN=33, EXIT=34, PRINT=35, PRINTLN=36, IF=37, THEN=38, 
		ELSE=39, FI=40, DO=41, DONE=42, SEMICOLON=43, COMMA=44, NEWPAIR=45, CALL=46, 
		FST=47, SND=48, PAIR=49, WHILE=50, COMMENT=51, BOOL=52, TRUE=53, FALSE=54, 
		NEWLINE=55, INT_LITER=56, INTEGER=57, CHAR_LITER=58, STR_LITER=59, IDENT=60, 
		PAIR_LITER=61;
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
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='"
	};
	public static final String[] ruleNames = {
		"DIV", "MUL", "MOD", "PLUS", "MINUS", "GRT", "GRTEQ", "SMT", "SMTEQ", 
		"EQEQ", "NOTEQ", "AND", "OR", "NOT", "LEN", "ORD", "CHR", "WS", "INT", 
		"CHAR", "STRING", "EOL", "EQ", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", 
		"OPEN_SQUAREB", "CLOSE_SQUAREB", "BEGIN", "END", "SKIP", "READ", "IS", 
		"FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "IF", "THEN", "ELSE", "FI", 
		"DO", "DONE", "SEMICOLON", "COMMA", "NEWPAIR", "CALL", "FST", "SND", "PAIR", 
		"WHILE", "COMMENT", "BOOL", "TRUE", "FALSE", "NEWLINE", "INT_LITER", "INTEGER", 
		"CHARACTER", "CHAR_LITER", "STR_LITER", "ESCAPED_CHAR", "IDENT", "DIGIT", 
		"PAIR_LITER"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2?\u01a7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\5\27\u00c9"+
		"\n\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\7\65\u014b\n\65\f\65\16\65\u014e\13\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39"+
		"\3:\5:\u0165\n:\3:\6:\u0168\n:\r:\16:\u0169\3;\6;\u016d\n;\r;\16;\u016e"+
		"\3<\3<\3=\3=\3=\5=\u0176\n=\3=\3=\3>\3>\3>\7>\u017d\n>\f>\16>\u0180\13"+
		">\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u0197"+
		"\n?\3@\3@\3@\7@\u019c\n@\f@\16@\u019f\13@\3A\3A\3B\3B\3B\3B\3B\2\2C\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\2/\30\61\31\63\32\65\33\67\349\35;\36=\37"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g\64i\65k\66m\67o8q"+
		"9s:u;w\2y<{=}\2\177>\u0081\2\u0083?\3\2\b\6\2\13\f\17\17\"\"^^\4\2\f\f"+
		"\17\17\4\2--//\3\2\62;\5\2$$\61\61bb\5\2C\\aac|\u01b5\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2\177\3\2\2\2\2\u0083\3\2\2"+
		"\2\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u0089\3\2\2\2\t\u008b\3\2\2\2\13"+
		"\u008d\3\2\2\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u0094\3\2\2\2\23\u0096"+
		"\3\2\2\2\25\u0099\3\2\2\2\27\u009c\3\2\2\2\31\u009f\3\2\2\2\33\u00a2\3"+
		"\2\2\2\35\u00a5\3\2\2\2\37\u00a7\3\2\2\2!\u00ab\3\2\2\2#\u00af\3\2\2\2"+
		"%\u00b3\3\2\2\2\'\u00b7\3\2\2\2)\u00bb\3\2\2\2+\u00c0\3\2\2\2-\u00c8\3"+
		"\2\2\2/\u00cc\3\2\2\2\61\u00ce\3\2\2\2\63\u00d0\3\2\2\2\65\u00d2\3\2\2"+
		"\2\67\u00d4\3\2\2\29\u00d6\3\2\2\2;\u00dc\3\2\2\2=\u00e0\3\2\2\2?\u00e5"+
		"\3\2\2\2A\u00ea\3\2\2\2C\u00ed\3\2\2\2E\u00f2\3\2\2\2G\u00f9\3\2\2\2I"+
		"\u00fe\3\2\2\2K\u0104\3\2\2\2M\u010c\3\2\2\2O\u010f\3\2\2\2Q\u0114\3\2"+
		"\2\2S\u0119\3\2\2\2U\u011c\3\2\2\2W\u011f\3\2\2\2Y\u0124\3\2\2\2[\u0126"+
		"\3\2\2\2]\u0128\3\2\2\2_\u0130\3\2\2\2a\u0135\3\2\2\2c\u0139\3\2\2\2e"+
		"\u013d\3\2\2\2g\u0142\3\2\2\2i\u0148\3\2\2\2k\u0151\3\2\2\2m\u0156\3\2"+
		"\2\2o\u015b\3\2\2\2q\u0161\3\2\2\2s\u0164\3\2\2\2u\u016c\3\2\2\2w\u0170"+
		"\3\2\2\2y\u0172\3\2\2\2{\u0179\3\2\2\2}\u0196\3\2\2\2\177\u0198\3\2\2"+
		"\2\u0081\u01a0\3\2\2\2\u0083\u01a2\3\2\2\2\u0085\u0086\7\61\2\2\u0086"+
		"\4\3\2\2\2\u0087\u0088\7,\2\2\u0088\6\3\2\2\2\u0089\u008a\7\'\2\2\u008a"+
		"\b\3\2\2\2\u008b\u008c\7-\2\2\u008c\n\3\2\2\2\u008d\u008e\7/\2\2\u008e"+
		"\f\3\2\2\2\u008f\u0090\7@\2\2\u0090\16\3\2\2\2\u0091\u0092\7@\2\2\u0092"+
		"\u0093\7?\2\2\u0093\20\3\2\2\2\u0094\u0095\7>\2\2\u0095\22\3\2\2\2\u0096"+
		"\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098\24\3\2\2\2\u0099\u009a\7?\2\2\u009a"+
		"\u009b\7?\2\2\u009b\26\3\2\2\2\u009c\u009d\7#\2\2\u009d\u009e\7?\2\2\u009e"+
		"\30\3\2\2\2\u009f\u00a0\7(\2\2\u00a0\u00a1\7(\2\2\u00a1\32\3\2\2\2\u00a2"+
		"\u00a3\7~\2\2\u00a3\u00a4\7~\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6"+
		"\36\3\2\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		" \3\2\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7f\2\2\u00ae"+
		"\"\3\2\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7t\2\2\u00b2"+
		"$\3\2\2\2\u00b3\u00b4\t\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\23\2\2"+
		"\u00b6&\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7v\2"+
		"\2\u00ba(\3\2\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7j\2\2\u00bd\u00be\7"+
		"c\2\2\u00be\u00bf\7t\2\2\u00bf*\3\2\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2"+
		"\7v\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7p\2\2\u00c5"+
		"\u00c6\7i\2\2\u00c6,\3\2\2\2\u00c7\u00c9\7\17\2\2\u00c8\u00c7\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\f\2\2\u00cb.\3"+
		"\2\2\2\u00cc\u00cd\7?\2\2\u00cd\60\3\2\2\2\u00ce\u00cf\7*\2\2\u00cf\62"+
		"\3\2\2\2\u00d0\u00d1\7+\2\2\u00d1\64\3\2\2\2\u00d2\u00d3\7]\2\2\u00d3"+
		"\66\3\2\2\2\u00d4\u00d5\7_\2\2\u00d58\3\2\2\2\u00d6\u00d7\7d\2\2\u00d7"+
		"\u00d8\7g\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7p\2\2"+
		"\u00db:\3\2\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7f\2"+
		"\2\u00df<\3\2\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7m\2\2\u00e2\u00e3\7"+
		"k\2\2\u00e3\u00e4\7r\2\2\u00e4>\3\2\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7"+
		"\7g\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7f\2\2\u00e9@\3\2\2\2\u00ea\u00eb"+
		"\7k\2\2\u00eb\u00ec\7u\2\2\u00ecB\3\2\2\2\u00ed\u00ee\7h\2\2\u00ee\u00ef"+
		"\7t\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7g\2\2\u00f1D\3\2\2\2\u00f2\u00f3"+
		"\7t\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7w\2\2\u00f6"+
		"\u00f7\7t\2\2\u00f7\u00f8\7p\2\2\u00f8F\3\2\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		"\u00fb\7z\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7v\2\2\u00fdH\3\2\2\2\u00fe"+
		"\u00ff\7r\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2\2"+
		"\u0102\u0103\7v\2\2\u0103J\3\2\2\2\u0104\u0105\7r\2\2\u0105\u0106\7t\2"+
		"\2\u0106\u0107\7k\2\2\u0107\u0108\7p\2\2\u0108\u0109\7v\2\2\u0109\u010a"+
		"\7n\2\2\u010a\u010b\7p\2\2\u010bL\3\2\2\2\u010c\u010d\7k\2\2\u010d\u010e"+
		"\7h\2\2\u010eN\3\2\2\2\u010f\u0110\7v\2\2\u0110\u0111\7j\2\2\u0111\u0112"+
		"\7g\2\2\u0112\u0113\7p\2\2\u0113P\3\2\2\2\u0114\u0115\7g\2\2\u0115\u0116"+
		"\7n\2\2\u0116\u0117\7u\2\2\u0117\u0118\7g\2\2\u0118R\3\2\2\2\u0119\u011a"+
		"\7h\2\2\u011a\u011b\7k\2\2\u011bT\3\2\2\2\u011c\u011d\7f\2\2\u011d\u011e"+
		"\7q\2\2\u011eV\3\2\2\2\u011f\u0120\7f\2\2\u0120\u0121\7q\2\2\u0121\u0122"+
		"\7p\2\2\u0122\u0123\7g\2\2\u0123X\3\2\2\2\u0124\u0125\7=\2\2\u0125Z\3"+
		"\2\2\2\u0126\u0127\7.\2\2\u0127\\\3\2\2\2\u0128\u0129\7p\2\2\u0129\u012a"+
		"\7g\2\2\u012a\u012b\7y\2\2\u012b\u012c\7r\2\2\u012c\u012d\7c\2\2\u012d"+
		"\u012e\7k\2\2\u012e\u012f\7t\2\2\u012f^\3\2\2\2\u0130\u0131\7e\2\2\u0131"+
		"\u0132\7c\2\2\u0132\u0133\7n\2\2\u0133\u0134\7n\2\2\u0134`\3\2\2\2\u0135"+
		"\u0136\7h\2\2\u0136\u0137\7u\2\2\u0137\u0138\7v\2\2\u0138b\3\2\2\2\u0139"+
		"\u013a\7u\2\2\u013a\u013b\7p\2\2\u013b\u013c\7f\2\2\u013cd\3\2\2\2\u013d"+
		"\u013e\7r\2\2\u013e\u013f\7c\2\2\u013f\u0140\7k\2\2\u0140\u0141\7t\2\2"+
		"\u0141f\3\2\2\2\u0142\u0143\7y\2\2\u0143\u0144\7j\2\2\u0144\u0145\7k\2"+
		"\2\u0145\u0146\7n\2\2\u0146\u0147\7g\2\2\u0147h\3\2\2\2\u0148\u014c\7"+
		"%\2\2\u0149\u014b\n\3\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014f\u0150\b\65\2\2\u0150j\3\2\2\2\u0151\u0152\7d\2\2\u0152\u0153"+
		"\7q\2\2\u0153\u0154\7q\2\2\u0154\u0155\7n\2\2\u0155l\3\2\2\2\u0156\u0157"+
		"\7v\2\2\u0157\u0158\7t\2\2\u0158\u0159\7w\2\2\u0159\u015a\7g\2\2\u015a"+
		"n\3\2\2\2\u015b\u015c\7h\2\2\u015c\u015d\7c\2\2\u015d\u015e\7n\2\2\u015e"+
		"\u015f\7u\2\2\u015f\u0160\7g\2\2\u0160p\3\2\2\2\u0161\u0162\7\f\2\2\u0162"+
		"r\3\2\2\2\u0163\u0165\t\4\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2"+
		"\u0165\u0167\3\2\2\2\u0166\u0168\t\5\2\2\u0167\u0166\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016at\3\2\2\2\u016b"+
		"\u016d\5\u0081A\2\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016fv\3\2\2\2\u0170\u0171\n\6\2\2\u0171"+
		"x\3\2\2\2\u0172\u0175\7)\2\2\u0173\u0176\5w<\2\u0174\u0176\5}?\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7)"+
		"\2\2\u0178z\3\2\2\2\u0179\u017e\7$\2\2\u017a\u017d\5w<\2\u017b\u017d\5"+
		"}?\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u0180\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0182\7$\2\2\u0182|\3\2\2\2\u0183\u0184\7^\2\2\u0184\u0197"+
		"\7\62\2\2\u0185\u0186\7^\2\2\u0186\u0197\7d\2\2\u0187\u0188\7^\2\2\u0188"+
		"\u0197\7v\2\2\u0189\u018a\7^\2\2\u018a\u0197\7p\2\2\u018b\u018c\7^\2\2"+
		"\u018c\u0197\7h\2\2\u018d\u018e\7^\2\2\u018e\u0197\7t\2\2\u018f\u0197"+
		"\7^\2\2\u0190\u0191\7^\2\2\u0191\u0197\7^\2\2\u0192\u0193\7^\2\2\u0193"+
		"\u0197\7$\2\2\u0194\u0195\7^\2\2\u0195\u0197\7)\2\2\u0196\u0183\3\2\2"+
		"\2\u0196\u0185\3\2\2\2\u0196\u0187\3\2\2\2\u0196\u0189\3\2\2\2\u0196\u018b"+
		"\3\2\2\2\u0196\u018d\3\2\2\2\u0196\u018f\3\2\2\2\u0196\u0190\3\2\2\2\u0196"+
		"\u0192\3\2\2\2\u0196\u0194\3\2\2\2\u0197~\3\2\2\2\u0198\u019d\t\7\2\2"+
		"\u0199\u019c\t\7\2\2\u019a\u019c\5\u0081A\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2"+
		"\2\2\u019e\u0080\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a1\4\62;\2\u01a1"+
		"\u0082\3\2\2\2\u01a2\u01a3\7p\2\2\u01a3\u01a4\7w\2\2\u01a4\u01a5\7n\2"+
		"\2\u01a5\u01a6\7n\2\2\u01a6\u0084\3\2\2\2\16\2\u00c8\u014c\u0164\u0169"+
		"\u016e\u0175\u017c\u017e\u0196\u019b\u019d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}