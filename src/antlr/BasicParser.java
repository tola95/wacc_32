// Generated from ./BasicParser.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=32, NEWPAIR=42, STR_LITER=54, PAIR_LITER=56, DO=38, CHR=17, MINUS=5, 
		SEMICOLON=40, ELSE=36, IF=34, BOOL_LITER=49, INTEGER=52, DONE=39, MUL=2, 
		FST=44, IS=28, EQ=19, READ=27, NOT=14, AND=12, GRTEQ=7, END=25, THEN=35, 
		SMT=8, EXIT=31, PLUS=4, CLOSE_PARENTHESES=21, ORD=16, CALL=43, FI=37, 
		PRINTLN=33, OPEN_PARENTHESES=20, GRT=6, CLOSE_SQUAREB=23, SND=45, BEGIN=24, 
		FREE=29, COMMENT=48, RETURN=30, SMTEQ=9, SKIP=26, WS=18, COMMA=41, MOD=3, 
		OR=13, CHAR_LITER=53, INT_LITER=51, NOTEQ=11, DIV=1, LEN=15, IDENT=55, 
		EQEQ=10, OPEN_SQUAREB=22, WHILE=47, BASE_TYPE=50, PAIR=46;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'*'", "'%'", "'+'", "'-'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", 
		"WS", "'='", "'('", "')'", "'['", "']'", "'begin'", "'end'", "'skip'", 
		"'read'", "'is'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'do'", "'done'", "';'", "','", "'newpair'", 
		"'call'", "'fst'", "'snd'", "'pair'", "'while'", "COMMENT", "BOOL_LITER", 
		"BASE_TYPE", "INT_LITER", "INTEGER", "CHAR_LITER", "STR_LITER", "IDENT", 
		"'null'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramlist = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignlhs = 5, RULE_assignrhs = 6, RULE_arglist = 7, RULE_pairelem = 8, 
		RULE_type = 9, RULE_arraytype = 10, RULE_pairtype = 11, RULE_pairelemtype = 12, 
		RULE_expr = 13, RULE_unaryoper = 14, RULE_binaryOper = 15, RULE_arrayelem = 16, 
		RULE_arrayliter = 17, RULE_prog = 18;
	public static final String[] ruleNames = {
		"program", "func", "paramlist", "param", "stat", "assignlhs", "assignrhs", 
		"arglist", "pairelem", "type", "arraytype", "pairtype", "pairelemtype", 
		"expr", "unaryoper", "binaryOper", "arrayelem", "arrayliter", "prog"
	};

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(BEGIN);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39); func();
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(45); stat(0);
			setState(46); match(END);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); type();
			setState(49); match(IDENT);
			setState(50); match(OPEN_PARENTHESES);
			setState(52);
			_la = _input.LA(1);
			if (_la==PAIR || _la==BASE_TYPE) {
				{
				setState(51); paramlist();
				}
			}

			setState(54); match(CLOSE_PARENTHESES);
			setState(55); match(IS);
			setState(56); stat(0);
			setState(57); match(END);
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

	public static class ParamlistContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ParamlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParamlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamlistContext paramlist() throws RecognitionException {
		ParamlistContext _localctx = new ParamlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); param();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(60); match(COMMA);
				setState(61); param();
				}
				}
				setState(66);
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); type();
			setState(68); match(IDENT);
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(71); match(SKIP);
				}
				break;
			case PAIR:
			case BASE_TYPE:
				{
				setState(72); type();
				setState(73); match(IDENT);
				setState(74); match(EQ);
				setState(75); assignrhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(77); assignlhs();
				setState(78); match(EQ);
				setState(79); assignrhs();
				}
				break;
			case READ:
				{
				setState(81); match(READ);
				setState(82); assignlhs();
				}
				break;
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
				{
				setState(83);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(84); expr(0);
				}
				break;
			case IF:
				{
				setState(85); match(IF);
				setState(86); expr(0);
				setState(87); match(THEN);
				setState(88); stat(0);
				setState(89); match(ELSE);
				setState(90); stat(0);
				setState(91); match(FI);
				}
				break;
			case WHILE:
				{
				setState(93); match(WHILE);
				setState(94); expr(0);
				setState(95); match(DO);
				setState(96); stat(0);
				setState(97); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(99); match(BEGIN);
				setState(100); stat(0);
				setState(101); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(105);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(106); match(SEMICOLON);
					setState(107); stat(2);
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignlhsContext extends ParserRuleContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public AssignlhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignlhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignlhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignlhsContext assignlhs() throws RecognitionException {
		AssignlhsContext _localctx = new AssignlhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignlhs);
		try {
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114); arrayelem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115); pairelem();
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

	public static class AssignrhsContext extends ParserRuleContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ArrayliterContext arrayliter() {
			return getRuleContext(ArrayliterContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public AssignrhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignrhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignrhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignrhsContext assignrhs() throws RecognitionException {
		AssignrhsContext _localctx = new AssignrhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignrhs);
		int _la;
		try {
			setState(135);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case LEN:
			case ORD:
			case CHR:
			case OPEN_PARENTHESES:
			case BOOL_LITER:
			case INT_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case IDENT:
			case PAIR_LITER:
				enterOuterAlt(_localctx, 1);
				{
				setState(118); expr(0);
				}
				break;
			case OPEN_SQUAREB:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); arrayliter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(120); match(NEWPAIR);
				setState(121); match(OPEN_PARENTHESES);
				setState(122); expr(0);
				setState(123); match(COMMA);
				setState(124); expr(0);
				setState(125); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(127); pairelem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(128); match(CALL);
				setState(129); match(IDENT);
				setState(130); match(OPEN_PARENTHESES);
				setState(132);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << BOOL_LITER) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
					{
					setState(131); arglist();
					}
				}

				setState(134); match(CLOSE_PARENTHESES);
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

	public static class ArglistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); expr(0);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(138); match(COMMA);
				setState(139); expr(0);
				}
				}
				setState(144);
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

	public static class PairelemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public PairelemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairelem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemContext pairelem() throws RecognitionException {
		PairelemContext _localctx = new PairelemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pairelem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(146); expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BASE_TYPE() { return getToken(BasicParser.BASE_TYPE, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148); match(BASE_TYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); arraytype(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150); pairtype();
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

	public static class ArraytypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public TerminalNode BASE_TYPE() { return getToken(BasicParser.BASE_TYPE, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArraytype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraytypeContext arraytype() throws RecognitionException {
		return arraytype(0);
	}

	private ArraytypeContext arraytype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArraytypeContext _localctx = new ArraytypeContext(_ctx, _parentState);
		ArraytypeContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_arraytype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				setState(154); match(BASE_TYPE);
				setState(155); match(OPEN_SQUAREB);
				setState(156); match(CLOSE_SQUAREB);
				}
				break;
			case PAIR:
				{
				setState(157); pairtype();
				setState(158); match(OPEN_SQUAREB);
				setState(159); match(CLOSE_SQUAREB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArraytypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arraytype);
					setState(163);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(164); match(OPEN_SQUAREB);
					setState(165); match(CLOSE_SQUAREB);
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PairtypeContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<PairelemtypeContext> pairelemtype() {
			return getRuleContexts(PairelemtypeContext.class);
		}
		public PairelemtypeContext pairelemtype(int i) {
			return getRuleContext(PairelemtypeContext.class,i);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairtypeContext pairtype() throws RecognitionException {
		PairtypeContext _localctx = new PairtypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pairtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(PAIR);
			setState(172); match(OPEN_PARENTHESES);
			setState(173); pairelemtype();
			setState(174); match(COMMA);
			setState(175); pairelemtype();
			setState(176); match(CLOSE_PARENTHESES);
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

	public static class PairelemtypeContext extends ParserRuleContext {
		public TerminalNode BASE_TYPE() { return getToken(BasicParser.BASE_TYPE, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public PairelemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelemtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairelemtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemtypeContext pairelemtype() throws RecognitionException {
		PairelemtypeContext _localctx = new PairelemtypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pairelemtype);
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178); match(BASE_TYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179); match(PAIR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180); arraytype(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INT_LITER() { return getToken(BasicParser.INT_LITER, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public BinaryOperContext binaryOper() {
			return getRuleContext(BinaryOperContext.class,0);
		}
		public TerminalNode BOOL_LITER() { return getToken(BasicParser.BOOL_LITER, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CHAR_LITER() { return getToken(BasicParser.CHAR_LITER, 0); }
		public UnaryoperContext unaryoper() {
			return getRuleContext(UnaryoperContext.class,0);
		}
		public TerminalNode STR_LITER() { return getToken(BasicParser.STR_LITER, 0); }
		public TerminalNode PAIR_LITER() { return getToken(BasicParser.PAIR_LITER, 0); }
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(184); unaryoper();
				setState(185); expr(2);
				}
				break;
			case 2:
				{
				setState(187); match(INT_LITER);
				}
				break;
			case 3:
				{
				setState(188); match(BOOL_LITER);
				}
				break;
			case 4:
				{
				setState(189); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				setState(190); match(STR_LITER);
				}
				break;
			case 6:
				{
				setState(191); match(PAIR_LITER);
				}
				break;
			case 7:
				{
				setState(192); match(IDENT);
				}
				break;
			case 8:
				{
				setState(193); arrayelem();
				}
				break;
			case 9:
				{
				setState(194); match(OPEN_PARENTHESES);
				setState(195); expr(0);
				setState(196); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(200);
					if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
					setState(201); binaryOper();
					setState(202); expr(11);
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryoperContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public UnaryoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryoperContext unaryoper() throws RecognitionException {
		UnaryoperContext _localctx = new UnaryoperContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BinaryOperContext extends ParserRuleContext {
		public TerminalNode SMT() { return getToken(BasicParser.SMT, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode GRT() { return getToken(BasicParser.GRT, 0); }
		public TerminalNode GRTEQ() { return getToken(BasicParser.GRTEQ, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode MUL() { return getToken(BasicParser.MUL, 0); }
		public TerminalNode EQEQ() { return getToken(BasicParser.EQEQ, 0); }
		public TerminalNode SMTEQ() { return getToken(BasicParser.SMTEQ, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public TerminalNode NOTEQ() { return getToken(BasicParser.NOTEQ, 0); }
		public BinaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperContext binaryOper() throws RecognitionException {
		BinaryOperContext _localctx = new BinaryOperContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MUL) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GRT) | (1L << GRTEQ) | (1L << SMT) | (1L << SMTEQ) | (1L << EQEQ) | (1L << NOTEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArrayelemContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ArrayelemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayelem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayelem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayelemContext arrayelem() throws RecognitionException {
		ArrayelemContext _localctx = new ArrayelemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayelem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(IDENT);
			setState(214); match(OPEN_SQUAREB);
			setState(215); expr(0);
			setState(216); match(CLOSE_SQUAREB);
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

	public static class ArrayliterContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ArrayliterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayliter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayliter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayliterContext arrayliter() throws RecognitionException {
		ArrayliterContext _localctx = new ArrayliterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayliter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(OPEN_SQUAREB);
			setState(220);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << BOOL_LITER) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				setState(219); arglist();
				}
			}

			setState(222); match(CLOSE_SQUAREB);
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

	public static class ProgContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << BOOL_LITER) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				{
				setState(224); expr(0);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230); match(EOF);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 10: return arraytype_sempred((ArraytypeContext)_localctx, predIndex);
		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arraytype_sempred(ArraytypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\5\3\67\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4A\n\4\f\4\16"+
		"\4D\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6j\n\6\3\6\3\6\3\6\7\6o\n\6\f\6\16\6r\13\6\3\7\3\7\3\7"+
		"\5\7w\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"\u0087\n\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\7\t\u008f\n\t\f\t\16\t\u0092"+
		"\13\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u009a\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00a4\n\f\3\f\3\f\3\f\7\f\u00a9\n\f\f\f\16\f\u00ac\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00b8\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00c9\n\17\3\17\3\17\3\17\3\17\7\17\u00cf\n\17\f\17\16\17\u00d2\13\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\5\23\u00df\n\23"+
		"\3\23\3\23\3\24\7\24\u00e4\n\24\f\24\16\24\u00e7\13\24\3\24\3\24\3\24"+
		"\2\5\n\26\34\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\6\3\2\37"+
		"#\3\2./\4\2\7\7\20\23\3\2\3\17\u00fb\2(\3\2\2\2\4\62\3\2\2\2\6=\3\2\2"+
		"\2\bE\3\2\2\2\ni\3\2\2\2\fv\3\2\2\2\16\u0089\3\2\2\2\20\u008b\3\2\2\2"+
		"\22\u0093\3\2\2\2\24\u0099\3\2\2\2\26\u00a3\3\2\2\2\30\u00ad\3\2\2\2\32"+
		"\u00b7\3\2\2\2\34\u00c8\3\2\2\2\36\u00d3\3\2\2\2 \u00d5\3\2\2\2\"\u00d7"+
		"\3\2\2\2$\u00dc\3\2\2\2&\u00e5\3\2\2\2(,\7\32\2\2)+\5\4\3\2*)\3\2\2\2"+
		"+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\5\n\6\2\60\61\7"+
		"\33\2\2\61\3\3\2\2\2\62\63\5\24\13\2\63\64\79\2\2\64\66\7\26\2\2\65\67"+
		"\5\6\4\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\27\2\29:\7\36\2\2"+
		":;\5\n\6\2;<\7\33\2\2<\5\3\2\2\2=B\5\b\5\2>?\7+\2\2?A\5\b\5\2@>\3\2\2"+
		"\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\7\3\2\2\2DB\3\2\2\2EF\5\24\13\2FG\7"+
		"9\2\2G\t\3\2\2\2HI\b\6\1\2Ij\7\34\2\2JK\5\24\13\2KL\79\2\2LM\7\25\2\2"+
		"MN\5\16\b\2Nj\3\2\2\2OP\5\f\7\2PQ\7\25\2\2QR\5\16\b\2Rj\3\2\2\2ST\7\35"+
		"\2\2Tj\5\f\7\2UV\t\2\2\2Vj\5\34\17\2WX\7$\2\2XY\5\34\17\2YZ\7%\2\2Z[\5"+
		"\n\6\2[\\\7&\2\2\\]\5\n\6\2]^\7\'\2\2^j\3\2\2\2_`\7\61\2\2`a\5\34\17\2"+
		"ab\7(\2\2bc\5\n\6\2cd\7)\2\2dj\3\2\2\2ef\7\32\2\2fg\5\n\6\2gh\7\33\2\2"+
		"hj\3\2\2\2iH\3\2\2\2iJ\3\2\2\2iO\3\2\2\2iS\3\2\2\2iU\3\2\2\2iW\3\2\2\2"+
		"i_\3\2\2\2ie\3\2\2\2jp\3\2\2\2kl\f\3\2\2lm\7*\2\2mo\5\n\6\4nk\3\2\2\2"+
		"or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\13\3\2\2\2rp\3\2\2\2sw\79\2\2tw\5\"\22"+
		"\2uw\5\22\n\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\r\3\2\2\2x\u008a\5\34\17"+
		"\2y\u008a\5$\23\2z{\7,\2\2{|\7\26\2\2|}\5\34\17\2}~\7+\2\2~\177\5\34\17"+
		"\2\177\u0080\7\27\2\2\u0080\u008a\3\2\2\2\u0081\u008a\5\22\n\2\u0082\u0083"+
		"\7-\2\2\u0083\u0084\79\2\2\u0084\u0086\7\26\2\2\u0085\u0087\5\20\t\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\7\27"+
		"\2\2\u0089x\3\2\2\2\u0089y\3\2\2\2\u0089z\3\2\2\2\u0089\u0081\3\2\2\2"+
		"\u0089\u0082\3\2\2\2\u008a\17\3\2\2\2\u008b\u0090\5\34\17\2\u008c\u008d"+
		"\7+\2\2\u008d\u008f\5\34\17\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\21\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0094\t\3\2\2\u0094\u0095\5\34\17\2\u0095\23\3\2\2\2\u0096"+
		"\u009a\7\64\2\2\u0097\u009a\5\26\f\2\u0098\u009a\5\30\r\2\u0099\u0096"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\25\3\2\2\2\u009b"+
		"\u009c\b\f\1\2\u009c\u009d\7\64\2\2\u009d\u009e\7\30\2\2\u009e\u00a4\7"+
		"\31\2\2\u009f\u00a0\5\30\r\2\u00a0\u00a1\7\30\2\2\u00a1\u00a2\7\31\2\2"+
		"\u00a2\u00a4\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00aa"+
		"\3\2\2\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\30\2\2\u00a7\u00a9\7\31\2\2"+
		"\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\27\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae"+
		"\u00af\7\26\2\2\u00af\u00b0\5\32\16\2\u00b0\u00b1\7+\2\2\u00b1\u00b2\5"+
		"\32\16\2\u00b2\u00b3\7\27\2\2\u00b3\31\3\2\2\2\u00b4\u00b8\7\64\2\2\u00b5"+
		"\u00b8\7\60\2\2\u00b6\u00b8\5\26\f\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\33\3\2\2\2\u00b9\u00ba\b\17\1\2\u00ba"+
		"\u00bb\5\36\20\2\u00bb\u00bc\5\34\17\4\u00bc\u00c9\3\2\2\2\u00bd\u00c9"+
		"\7\65\2\2\u00be\u00c9\7\63\2\2\u00bf\u00c9\7\67\2\2\u00c0\u00c9\78\2\2"+
		"\u00c1\u00c9\7:\2\2\u00c2\u00c9\79\2\2\u00c3\u00c9\5\"\22\2\u00c4\u00c5"+
		"\7\26\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7\7\27\2\2\u00c7\u00c9\3\2\2"+
		"\2\u00c8\u00b9\3\2\2\2\u00c8\u00bd\3\2\2\2\u00c8\u00be\3\2\2\2\u00c8\u00bf"+
		"\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8"+
		"\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\u00d0\3\2\2\2\u00ca\u00cb\f\f"+
		"\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd\5\34\17\r\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00ca\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\35\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\t\4\2\2\u00d4\37"+
		"\3\2\2\2\u00d5\u00d6\t\5\2\2\u00d6!\3\2\2\2\u00d7\u00d8\79\2\2\u00d8\u00d9"+
		"\7\30\2\2\u00d9\u00da\5\34\17\2\u00da\u00db\7\31\2\2\u00db#\3\2\2\2\u00dc"+
		"\u00de\7\30\2\2\u00dd\u00df\5\20\t\2\u00de\u00dd\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\31\2\2\u00e1%\3\2\2\2\u00e2\u00e4"+
		"\5\34\17\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2"+
		"\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9"+
		"\7\2\2\3\u00e9\'\3\2\2\2\23,\66Bipv\u0086\u0089\u0090\u0099\u00a3\u00aa"+
		"\u00b7\u00c8\u00d0\u00de\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}