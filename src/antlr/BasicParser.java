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
		PRINT=35, NEWPAIR=45, PAIR_LITER=53, STR_LITER=60, DO=41, CHR=17, MINUS=5, 
		SEMICOLON=43, ELSE=39, IF=37, INTEGER=58, DONE=42, MUL=2, FST=47, NEWLINE=56, 
		TRUE=54, IS=31, EQ=22, READ=30, NOT=14, AND=12, GRTEQ=7, END=28, THEN=38, 
		SMT=8, EXIT=34, PLUS=4, CLOSE_PARENTHESES=24, ORD=16, CALL=46, FI=40, 
		PRINTLN=36, OPEN_PARENTHESES=23, GRT=6, CLOSE_SQUAREB=26, SND=48, CHAR=20, 
		BEGIN=27, FREE=32, INT=19, COMMENT=51, RETURN=33, SMTEQ=9, SKIP=29, WS=18, 
		COMMA=44, MOD=3, OR=13, CHAR_LITER=59, INT_LITER=57, NOTEQ=11, DIV=1, 
		LEN=15, IDENT=61, BOOL=52, EQEQ=10, STRING=21, OPEN_SQUAREB=25, WHILE=50, 
		FALSE=55, PAIR=49;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'*'", "'%'", "'+'", "'-'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", 
		"WS", "'int'", "'char'", "'string'", "'='", "'('", "')'", "'['", "']'", 
		"'begin'", "'end'", "'skip'", "'read'", "'is'", "'free'", "'return'", 
		"'exit'", "'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", 
		"'do'", "'done'", "';'", "','", "'newpair'", "'call'", "'fst'", "'snd'", 
		"'pair'", "'while'", "COMMENT", "'bool'", "'null'", "'true'", "'false'", 
		"'\n'", "INT_LITER", "INTEGER", "CHAR_LITER", "STR_LITER", "IDENT"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramlist = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignlhs = 5, RULE_assignrhs = 6, RULE_arglist = 7, RULE_pairelem = 8, 
		RULE_basetype = 9, RULE_type = 10, RULE_arraytype = 11, RULE_pairtype = 12, 
		RULE_pairelemtype = 13, RULE_expr = 14, RULE_unaryoper = 15, RULE_bool_Liter = 16, 
		RULE_arrayelem = 17, RULE_arrayliter = 18, RULE_prog = 19;
	public static final String[] ruleNames = {
		"program", "func", "paramlist", "param", "stat", "assignlhs", "assignrhs", 
		"arglist", "pairelem", "basetype", "type", "arraytype", "pairtype", "pairelemtype", 
		"expr", "unaryoper", "bool_Liter", "arrayelem", "arrayliter", "prog"
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
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
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
			setState(40); match(BEGIN);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(41); func();
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(47); stat(0);
			setState(48); match(END);
			setState(49); match(EOF);
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
			setState(51); type();
			setState(52); match(IDENT);
			setState(53); match(OPEN_PARENTHESES);
			setState(55);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << STRING) | (1L << PAIR) | (1L << BOOL))) != 0)) {
				{
				setState(54); paramlist();
				}
			}

			setState(57); match(CLOSE_PARENTHESES);
			setState(58); match(IS);
			setState(59); stat(0);
			setState(60); match(END);
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
			setState(62); param();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(63); match(COMMA);
				setState(64); param();
				}
				}
				setState(69);
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
			setState(70); type();
			setState(71); match(IDENT);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Semicolon_StatContext extends StatContext {
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public Semicolon_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSemicolon_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignLhsRhs_StatContext extends StatContext {
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public AssignLhsRhs_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLhsRhs_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_StatContext extends StatContext {
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public If_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIf_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class While_StatContext extends StatContext {
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public While_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhile_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Read_StatContext extends StatContext {
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public Read_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRead_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Begin_StatContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Begin_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBegin_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Println_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public Println_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrintln_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentEq_StatContext extends StatContext {
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public IdentEq_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdentEq_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Return_StatContext extends StatContext {
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitReturn_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exit_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public Exit_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExit_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Free_StatContext extends StatContext {
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Free_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFree_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Skip_StatContext extends StatContext {
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public Skip_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSkip_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Print_StatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrint_Stat(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new Skip_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(74); match(SKIP);
				}
				break;
			case INT:
			case CHAR:
			case STRING:
			case PAIR:
			case BOOL:
				{
				_localctx = new IdentEq_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); type();
				setState(76); match(IDENT);
				setState(77); match(EQ);
				setState(78); assignrhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new AssignLhsRhs_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80); assignlhs();
				setState(81); match(EQ);
				setState(82); assignrhs();
				}
				break;
			case READ:
				{
				_localctx = new Read_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); match(READ);
				setState(85); assignlhs();
				}
				break;
			case FREE:
				{
				_localctx = new Free_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); match(FREE);
				setState(87); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Return_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); match(RETURN);
				setState(89); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Exit_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(EXIT);
				setState(91); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Print_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); match(PRINT);
				setState(93); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Println_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94); match(PRINTLN);
				setState(95); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); match(IF);
				setState(97); expr(0);
				setState(98); match(THEN);
				setState(99); stat(0);
				setState(100); match(ELSE);
				setState(101); stat(0);
				setState(102); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); match(WHILE);
				setState(105); expr(0);
				setState(106); match(DO);
				setState(107); stat(0);
				setState(108); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Begin_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110); match(BEGIN);
				setState(111); stat(0);
				setState(112); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Semicolon_StatContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(116);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(117); match(SEMICOLON);
					setState(118); stat(2);
					}
					} 
				}
				setState(123);
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
		public AssignlhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignlhs; }
	 
		public AssignlhsContext() { }
		public void copyFrom(AssignlhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Ident_AssignLhsContext extends AssignlhsContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public Ident_AssignLhsContext(AssignlhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent_AssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Arrayelem_AssignLhsContext extends AssignlhsContext {
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public Arrayelem_AssignLhsContext(AssignlhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayelem_AssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pairelem_AssignLhsContext extends AssignlhsContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public Pairelem_AssignLhsContext(AssignlhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairelem_AssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignlhsContext assignlhs() throws RecognitionException {
		AssignlhsContext _localctx = new AssignlhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignlhs);
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new Ident_AssignLhsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Arrayelem_AssignLhsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125); arrayelem();
				}
				break;
			case 3:
				_localctx = new Pairelem_AssignLhsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126); pairelem();
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
		public AssignrhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignrhs; }
	 
		public AssignrhsContext() { }
		public void copyFrom(AssignrhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayLiter_assignrhsContext extends AssignrhsContext {
		public ArrayliterContext arrayliter() {
			return getRuleContext(ArrayliterContext.class,0);
		}
		public ArrayLiter_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayLiter_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElem_assignrhsContext extends AssignrhsContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public PairElem_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElem_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_assignrhsContext extends AssignrhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Exp_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExp_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewPair_assignrhsContext extends AssignrhsContext {
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public NewPair_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitNewPair_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Call_assignrhsContext extends AssignrhsContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Call_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCall_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignrhsContext assignrhs() throws RecognitionException {
		AssignrhsContext _localctx = new AssignrhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignrhs);
		int _la;
		try {
			setState(146);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case LEN:
			case ORD:
			case CHR:
			case OPEN_PARENTHESES:
			case PAIR_LITER:
			case TRUE:
			case FALSE:
			case INT_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case IDENT:
				_localctx = new Exp_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129); expr(0);
				}
				break;
			case OPEN_SQUAREB:
				_localctx = new ArrayLiter_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130); arrayliter();
				}
				break;
			case NEWPAIR:
				_localctx = new NewPair_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131); match(NEWPAIR);
				setState(132); match(OPEN_PARENTHESES);
				setState(133); expr(0);
				setState(134); match(COMMA);
				setState(135); expr(0);
				setState(136); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new PairElem_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138); pairelem();
				}
				break;
			case CALL:
				_localctx = new Call_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(139); match(CALL);
				setState(140); match(IDENT);
				setState(141); match(OPEN_PARENTHESES);
				setState(143);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << PAIR_LITER) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(142); arglist();
					}
				}

				setState(145); match(CLOSE_PARENTHESES);
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
			setState(148); expr(0);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(149); match(COMMA);
				setState(150); expr(0);
				}
				}
				setState(155);
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
			setState(156);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(157); expr(0);
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

	public static class BasetypeContext extends ParserRuleContext {
		public BasetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetype; }
	 
		public BasetypeContext() { }
		public void copyFrom(BasetypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Char_baseTypeContext extends BasetypeContext {
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public Char_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Int_baseTypeContext extends BasetypeContext {
		public TerminalNode INT() { return getToken(BasicParser.INT, 0); }
		public Int_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class String_baseTypeContext extends BasetypeContext {
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public String_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitString_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_baseTypeContext extends BasetypeContext {
		public TerminalNode BOOL() { return getToken(BasicParser.BOOL, 0); }
		public Bool_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_baseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasetypeContext basetype() throws RecognitionException {
		BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basetype);
		try {
			setState(163);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Int_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159); match(INT);
				}
				break;
			case BOOL:
				_localctx = new Bool_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160); match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new Char_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161); match(CHAR);
				}
				break;
			case STRING:
				_localctx = new String_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162); match(STRING);
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

	public static class TypeContext extends ParserRuleContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165); basetype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); arraytype(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167); pairtype();
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
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arraytype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case STRING:
			case BOOL:
				{
				setState(171); basetype();
				setState(172); match(OPEN_SQUAREB);
				setState(173); match(CLOSE_SQUAREB);
				}
				break;
			case PAIR:
				{
				setState(175); pairtype();
				setState(176); match(OPEN_SQUAREB);
				setState(177); match(CLOSE_SQUAREB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArraytypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arraytype);
					setState(181);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(182); match(OPEN_SQUAREB);
					setState(183); match(CLOSE_SQUAREB);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 24, RULE_pairtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(PAIR);
			setState(190); match(OPEN_PARENTHESES);
			setState(191); pairelemtype();
			setState(192); match(COMMA);
			setState(193); pairelemtype();
			setState(194); match(CLOSE_PARENTHESES);
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
		public PairelemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelemtype; }
	 
		public PairelemtypeContext() { }
		public void copyFrom(PairelemtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseType_pairElemTypeContext extends PairelemtypeContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public BaseType_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayType_pairElemTypeContext extends PairelemtypeContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public ArrayType_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pair_pairElemTypeContext extends PairelemtypeContext {
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public Pair_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemtypeContext pairelemtype() throws RecognitionException {
		PairelemtypeContext _localctx = new PairelemtypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pairelemtype);
		try {
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new BaseType_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196); basetype();
				}
				break;
			case 2:
				_localctx = new Pair_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197); match(PAIR);
				}
				break;
			case 3:
				_localctx = new ArrayType_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198); arraytype(0);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolLiter_ExprContext extends ExprContext {
		public Bool_LiterContext bool_Liter() {
			return getRuleContext(Bool_LiterContext.class,0);
		}
		public BoolLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBoolLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Equality_ExprContext extends ExprContext {
		public TerminalNode EQEQ() { return getToken(BasicParser.EQEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOTEQ() { return getToken(BasicParser.NOTEQ, 0); }
		public Equality_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitEquality_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class And_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public And_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAnd_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ident_ExprContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public Ident_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairLiter_ExprContext extends ExprContext {
		public TerminalNode PAIR_LITER() { return getToken(BasicParser.PAIR_LITER, 0); }
		public PairLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Or_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public Or_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitOr_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Parenth_ExprContext extends ExprContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Parenth_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParenth_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiter_ExprContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(BasicParser.INT_LITER, 0); }
		public IntLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIntLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiter_ExprContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(BasicParser.CHAR_LITER, 0); }
		public CharLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCharLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Factor_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(BasicParser.MUL, 0); }
		public Factor_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFactor_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Compare_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SMTEQ() { return getToken(BasicParser.SMTEQ, 0); }
		public TerminalNode SMT() { return getToken(BasicParser.SMT, 0); }
		public TerminalNode GRT() { return getToken(BasicParser.GRT, 0); }
		public TerminalNode GRTEQ() { return getToken(BasicParser.GRTEQ, 0); }
		public Compare_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCompare_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrLiter_ExprContext extends ExprContext {
		public TerminalNode STR_LITER() { return getToken(BasicParser.STR_LITER, 0); }
		public StrLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStrLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElem_ExprContext extends ExprContext {
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public ArrayElem_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public Term_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTerm_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOper_ExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryoperContext unaryoper() {
			return getRuleContext(UnaryoperContext.class,0);
		}
		public UnaryOper_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryOper_Expr(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOper_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(202); unaryoper();
				setState(203); expr(15);
				}
				break;
			case 2:
				{
				_localctx = new Parenth_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205); match(OPEN_PARENTHESES);
				setState(206); expr(0);
				setState(207); match(CLOSE_PARENTHESES);
				}
				break;
			case 3:
				{
				_localctx = new IntLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209); match(INT_LITER);
				}
				break;
			case 4:
				{
				_localctx = new BoolLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); bool_Liter();
				}
				break;
			case 5:
				{
				_localctx = new CharLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211); match(CHAR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new StrLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212); match(STR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new PairLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); match(PAIR_LITER);
				}
				break;
			case 8:
				{
				_localctx = new Ident_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); match(IDENT);
				}
				break;
			case 9:
				{
				_localctx = new ArrayElem_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); arrayelem();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(236);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Factor_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(219);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MUL) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(220); expr(14);
						}
						break;
					case 2:
						{
						_localctx = new Term_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(222);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(223); expr(13);
						}
						break;
					case 3:
						{
						_localctx = new Compare_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(225);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRT) | (1L << GRTEQ) | (1L << SMT) | (1L << SMTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(226); expr(12);
						}
						break;
					case 4:
						{
						_localctx = new Equality_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(228);
						_la = _input.LA(1);
						if ( !(_la==EQEQ || _la==NOTEQ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(229); expr(11);
						}
						break;
					case 5:
						{
						_localctx = new And_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(231); match(AND);
						setState(232); expr(10);
						}
						break;
					case 6:
						{
						_localctx = new Or_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(234); match(OR);
						setState(235); expr(9);
						}
						break;
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 30, RULE_unaryoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
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

	public static class Bool_LiterContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public Bool_LiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_Liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_Liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_LiterContext bool_Liter() throws RecognitionException {
		Bool_LiterContext _localctx = new Bool_LiterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bool_Liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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
		public List<TerminalNode> OPEN_SQUAREB() { return getTokens(BasicParser.OPEN_SQUAREB); }
		public TerminalNode OPEN_SQUAREB(int i) {
			return getToken(BasicParser.OPEN_SQUAREB, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_SQUAREB(int i) {
			return getToken(BasicParser.CLOSE_SQUAREB, i);
		}
		public List<TerminalNode> CLOSE_SQUAREB() { return getTokens(BasicParser.CLOSE_SQUAREB); }
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
		enterRule(_localctx, 34, RULE_arrayelem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(IDENT);
			setState(250); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(246); match(OPEN_SQUAREB);
					setState(247); expr(0);
					setState(248); match(CLOSE_SQUAREB);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(252); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		enterRule(_localctx, 36, RULE_arrayliter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(OPEN_SQUAREB);
			setState(256);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << PAIR_LITER) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT))) != 0)) {
				{
				setState(255); arglist();
				}
			}

			setState(258); match(CLOSE_SQUAREB);
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
		enterRule(_localctx, 38, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << PAIR_LITER) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT))) != 0)) {
				{
				{
				setState(260); expr(0);
				}
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(266); match(EOF);
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
		case 11: return arraytype_sempred((ArraytypeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
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
		case 2: return precpred(_ctx, 13);
		case 3: return precpred(_ctx, 12);
		case 4: return precpred(_ctx, 11);
		case 5: return precpred(_ctx, 10);
		case 6: return precpred(_ctx, 9);
		case 7: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7"+
		"\4D\n\4\f\4\16\4G\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6u\n\6\3"+
		"\6\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\3\7\3\7\3\7\5\7\u0082\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0092\n\b\3\b\5\b\u0095"+
		"\n\b\3\t\3\t\3\t\7\t\u009a\n\t\f\t\16\t\u009d\13\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\5\13\u00a6\n\13\3\f\3\f\3\f\5\f\u00ab\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\r\3\r\3\r\7\r\u00bb\n\r\f\r\16"+
		"\r\u00be\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00ca"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00db\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ef\n\20\f\20\16"+
		"\20\u00f2\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00fd"+
		"\n\23\r\23\16\23\u00fe\3\24\3\24\5\24\u0103\n\24\3\24\3\24\3\25\7\25\u0108"+
		"\n\25\f\25\16\25\u010b\13\25\3\25\3\25\3\25\2\5\n\30\36\26\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(\2\t\3\2\61\62\3\2\3\5\3\2\6\7\3\2\b"+
		"\13\3\2\f\r\4\2\7\7\20\23\3\289\u012b\2*\3\2\2\2\4\65\3\2\2\2\6@\3\2\2"+
		"\2\bH\3\2\2\2\nt\3\2\2\2\f\u0081\3\2\2\2\16\u0094\3\2\2\2\20\u0096\3\2"+
		"\2\2\22\u009e\3\2\2\2\24\u00a5\3\2\2\2\26\u00aa\3\2\2\2\30\u00b5\3\2\2"+
		"\2\32\u00bf\3\2\2\2\34\u00c9\3\2\2\2\36\u00da\3\2\2\2 \u00f3\3\2\2\2\""+
		"\u00f5\3\2\2\2$\u00f7\3\2\2\2&\u0100\3\2\2\2(\u0109\3\2\2\2*.\7\35\2\2"+
		"+-\5\4\3\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3"+
		"\2\2\2\61\62\5\n\6\2\62\63\7\36\2\2\63\64\7\2\2\3\64\3\3\2\2\2\65\66\5"+
		"\26\f\2\66\67\7?\2\2\679\7\31\2\28:\5\6\4\298\3\2\2\29:\3\2\2\2:;\3\2"+
		"\2\2;<\7\32\2\2<=\7!\2\2=>\5\n\6\2>?\7\36\2\2?\5\3\2\2\2@E\5\b\5\2AB\7"+
		".\2\2BD\5\b\5\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\7\3\2\2\2GE\3"+
		"\2\2\2HI\5\26\f\2IJ\7?\2\2J\t\3\2\2\2KL\b\6\1\2Lu\7\37\2\2MN\5\26\f\2"+
		"NO\7?\2\2OP\7\30\2\2PQ\5\16\b\2Qu\3\2\2\2RS\5\f\7\2ST\7\30\2\2TU\5\16"+
		"\b\2Uu\3\2\2\2VW\7 \2\2Wu\5\f\7\2XY\7\"\2\2Yu\5\36\20\2Z[\7#\2\2[u\5\36"+
		"\20\2\\]\7$\2\2]u\5\36\20\2^_\7%\2\2_u\5\36\20\2`a\7&\2\2au\5\36\20\2"+
		"bc\7\'\2\2cd\5\36\20\2de\7(\2\2ef\5\n\6\2fg\7)\2\2gh\5\n\6\2hi\7*\2\2"+
		"iu\3\2\2\2jk\7\64\2\2kl\5\36\20\2lm\7+\2\2mn\5\n\6\2no\7,\2\2ou\3\2\2"+
		"\2pq\7\35\2\2qr\5\n\6\2rs\7\36\2\2su\3\2\2\2tK\3\2\2\2tM\3\2\2\2tR\3\2"+
		"\2\2tV\3\2\2\2tX\3\2\2\2tZ\3\2\2\2t\\\3\2\2\2t^\3\2\2\2t`\3\2\2\2tb\3"+
		"\2\2\2tj\3\2\2\2tp\3\2\2\2u{\3\2\2\2vw\f\3\2\2wx\7-\2\2xz\5\n\6\4yv\3"+
		"\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\13\3\2\2\2}{\3\2\2\2~\u0082\7?\2"+
		"\2\177\u0082\5$\23\2\u0080\u0082\5\22\n\2\u0081~\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0080\3\2\2\2\u0082\r\3\2\2\2\u0083\u0095\5\36\20\2\u0084\u0095"+
		"\5&\24\2\u0085\u0086\7/\2\2\u0086\u0087\7\31\2\2\u0087\u0088\5\36\20\2"+
		"\u0088\u0089\7.\2\2\u0089\u008a\5\36\20\2\u008a\u008b\7\32\2\2\u008b\u0095"+
		"\3\2\2\2\u008c\u0095\5\22\n\2\u008d\u008e\7\60\2\2\u008e\u008f\7?\2\2"+
		"\u008f\u0091\7\31\2\2\u0090\u0092\5\20\t\2\u0091\u0090\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\7\32\2\2\u0094\u0083\3\2\2\2"+
		"\u0094\u0084\3\2\2\2\u0094\u0085\3\2\2\2\u0094\u008c\3\2\2\2\u0094\u008d"+
		"\3\2\2\2\u0095\17\3\2\2\2\u0096\u009b\5\36\20\2\u0097\u0098\7.\2\2\u0098"+
		"\u009a\5\36\20\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\21\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\t\2\2\2\u009f\u00a0\5\36\20\2\u00a0\23\3\2\2\2\u00a1\u00a6\7\25"+
		"\2\2\u00a2\u00a6\7\66\2\2\u00a3\u00a6\7\26\2\2\u00a4\u00a6\7\27\2\2\u00a5"+
		"\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2"+
		"\2\2\u00a6\25\3\2\2\2\u00a7\u00ab\5\24\13\2\u00a8\u00ab\5\30\r\2\u00a9"+
		"\u00ab\5\32\16\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\27\3\2\2\2\u00ac\u00ad\b\r\1\2\u00ad\u00ae\5\24\13\2\u00ae"+
		"\u00af\7\33\2\2\u00af\u00b0\7\34\2\2\u00b0\u00b6\3\2\2\2\u00b1\u00b2\5"+
		"\32\16\2\u00b2\u00b3\7\33\2\2\u00b3\u00b4\7\34\2\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u00ac\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b6\u00bc\3\2\2\2\u00b7\u00b8"+
		"\f\4\2\2\u00b8\u00b9\7\33\2\2\u00b9\u00bb\7\34\2\2\u00ba\u00b7\3\2\2\2"+
		"\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\31"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\63\2\2\u00c0\u00c1\7\31\2\2"+
		"\u00c1\u00c2\5\34\17\2\u00c2\u00c3\7.\2\2\u00c3\u00c4\5\34\17\2\u00c4"+
		"\u00c5\7\32\2\2\u00c5\33\3\2\2\2\u00c6\u00ca\5\24\13\2\u00c7\u00ca\7\63"+
		"\2\2\u00c8\u00ca\5\30\r\2\u00c9\u00c6\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\35\3\2\2\2\u00cb\u00cc\b\20\1\2\u00cc\u00cd\5 \21"+
		"\2\u00cd\u00ce\5\36\20\21\u00ce\u00db\3\2\2\2\u00cf\u00d0\7\31\2\2\u00d0"+
		"\u00d1\5\36\20\2\u00d1\u00d2\7\32\2\2\u00d2\u00db\3\2\2\2\u00d3\u00db"+
		"\7;\2\2\u00d4\u00db\5\"\22\2\u00d5\u00db\7=\2\2\u00d6\u00db\7>\2\2\u00d7"+
		"\u00db\7\67\2\2\u00d8\u00db\7?\2\2\u00d9\u00db\5$\23\2\u00da\u00cb\3\2"+
		"\2\2\u00da\u00cf\3\2\2\2\u00da\u00d3\3\2\2\2\u00da\u00d4\3\2\2\2\u00da"+
		"\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00d9\3\2\2\2\u00db\u00f0\3\2\2\2\u00dc\u00dd\f\17\2\2\u00dd"+
		"\u00de\t\3\2\2\u00de\u00ef\5\36\20\20\u00df\u00e0\f\16\2\2\u00e0\u00e1"+
		"\t\4\2\2\u00e1\u00ef\5\36\20\17\u00e2\u00e3\f\r\2\2\u00e3\u00e4\t\5\2"+
		"\2\u00e4\u00ef\5\36\20\16\u00e5\u00e6\f\f\2\2\u00e6\u00e7\t\6\2\2\u00e7"+
		"\u00ef\5\36\20\r\u00e8\u00e9\f\13\2\2\u00e9\u00ea\7\16\2\2\u00ea\u00ef"+
		"\5\36\20\f\u00eb\u00ec\f\n\2\2\u00ec\u00ed\7\17\2\2\u00ed\u00ef\5\36\20"+
		"\13\u00ee\u00dc\3\2\2\2\u00ee\u00df\3\2\2\2\u00ee\u00e2\3\2\2\2\u00ee"+
		"\u00e5\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ef\u00f2\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\37\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f4\t\7\2\2\u00f4!\3\2\2\2\u00f5\u00f6\t\b\2\2\u00f6"+
		"#\3\2\2\2\u00f7\u00fc\7?\2\2\u00f8\u00f9\7\33\2\2\u00f9\u00fa\5\36\20"+
		"\2\u00fa\u00fb\7\34\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff%\3\2\2\2"+
		"\u0100\u0102\7\33\2\2\u0101\u0103\5\20\t\2\u0102\u0101\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7\34\2\2\u0105\'\3\2\2\2\u0106"+
		"\u0108\5\36\20\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3"+
		"\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010d\7\2\2\3\u010d)\3\2\2\2\26.9Et{\u0081\u0091\u0094\u009b\u00a5\u00aa"+
		"\u00b5\u00bc\u00c9\u00da\u00ee\u00f0\u00fe\u0102\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}