package standardLambda;// Generated from Lambda by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LambdaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAMBDA=1, DOT=2, SPACE=3, LEFT_PAREN=4, RIGHT_PAREN=5, VAR=6, WS=7, NEWLINE=8;
	public static final int
		RULE_lambdaTerm = 0, RULE_expr = 1, RULE_var = 2, RULE_abst = 3, RULE_func = 4, 
		RULE_arg = 5;
	public static final String[] ruleNames = {
		"lambdaTerm", "expr", "var", "abst", "func", "arg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'.'", "' '", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAMBDA", "DOT", "SPACE", "LEFT_PAREN", "RIGHT_PAREN", "VAR", "WS", 
		"NEWLINE"
	};
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
	public String getGrammarFileName() { return "standardLambda/Lambda"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LambdaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LambdaTermContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LambdaParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(LambdaParser.EOF, 0); }
		public LambdaTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterLambdaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitLambdaTerm(this);
		}
	}

	public final LambdaTermContext lambdaTerm() throws RecognitionException {
		LambdaTermContext _localctx = new LambdaTermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lambdaTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			expr(0);
			setState(13);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ExprContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(LambdaParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(LambdaParser.SPACE, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(LambdaParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(LambdaParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(LambdaParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(LambdaParser.RIGHT_PAREN, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitExpr(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(16);
				var();
				}
				break;
			case 2:
				{
				setState(17);
				abst();
				}
				break;
			case 3:
				{
				setState(18);
				func(0);
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(19);
					match(SPACE);
					}
					}
					setState(22); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SPACE );
				setState(24);
				arg();
				}
				break;
			case 4:
				{
				setState(27); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(26);
						match(LEFT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(29); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(31);
				expr(0);
				setState(33); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(32);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(35); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(39);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(41); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(40);
						match(SPACE);
						}
						}
						setState(43); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SPACE );
					setState(45);
					arg();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LambdaParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(VAR);
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

	public static class AbstContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(LambdaParser.LAMBDA, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LambdaParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterAbst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitAbst(this);
		}
	}

	public final AbstContext abst() throws RecognitionException {
		AbstContext _localctx = new AbstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_abst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LAMBDA);
			setState(54);
			var();
			setState(55);
			match(DOT);
			setState(56);
			expr(0);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(LambdaParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(LambdaParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(LambdaParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(LambdaParser.RIGHT_PAREN, i);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(LambdaParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(LambdaParser.SPACE, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		return func(0);
	}

	private FuncContext func(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FuncContext _localctx = new FuncContext(_ctx, _parentState);
		FuncContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_func, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(59);
				var();
				}
				break;
			case LEFT_PAREN:
				{
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(60);
					match(LEFT_PAREN);
					}
					}
					setState(63); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LEFT_PAREN );
				setState(65);
				abst();
				setState(67); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(66);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(69); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(73);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(74);
						match(SPACE);
						}
						}
						setState(77); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SPACE );
					setState(79);
					arg();
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ArgContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(LambdaParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(LambdaParser.LEFT_PAREN, i);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(LambdaParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(LambdaParser.RIGHT_PAREN, i);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(LambdaParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(LambdaParser.SPACE, i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		int _la;
		try {
			int _alt;
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(LEFT_PAREN);
				setState(87);
				abst();
				setState(88);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(90);
						match(LEFT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(93); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(95);
				func(0);
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96);
					match(SPACE);
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SPACE );
				setState(101);
				arg();
				setState(103); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(102);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 4:
			return func_sempred((FuncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean func_sempred(FuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\np\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\6\3"+
		"\27\n\3\r\3\16\3\30\3\3\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3\6\3$\n"+
		"\3\r\3\16\3%\5\3(\n\3\3\3\3\3\6\3,\n\3\r\3\16\3-\3\3\7\3\61\n\3\f\3\16"+
		"\3\64\13\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6@\n\6\r\6\16\6A"+
		"\3\6\3\6\6\6F\n\6\r\6\16\6G\5\6J\n\6\3\6\3\6\6\6N\n\6\r\6\16\6O\3\6\7"+
		"\6S\n\6\f\6\16\6V\13\6\3\7\3\7\3\7\3\7\3\7\3\7\6\7^\n\7\r\7\16\7_\3\7"+
		"\3\7\6\7d\n\7\r\7\16\7e\3\7\3\7\6\7j\n\7\r\7\16\7k\5\7n\n\7\3\7\2\4\4"+
		"\n\b\2\4\6\b\n\f\2\3\3\3\n\n{\2\16\3\2\2\2\4\'\3\2\2\2\6\65\3\2\2\2\b"+
		"\67\3\2\2\2\nI\3\2\2\2\fm\3\2\2\2\16\17\5\4\3\2\17\20\t\2\2\2\20\3\3\2"+
		"\2\2\21\22\b\3\1\2\22(\5\6\4\2\23(\5\b\5\2\24\26\5\n\6\2\25\27\7\5\2\2"+
		"\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2"+
		"\32\33\5\f\7\2\33(\3\2\2\2\34\36\7\6\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37"+
		"\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\5\4\3\2\"$\7\7\2\2#\"\3\2\2\2$%\3"+
		"\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'\21\3\2\2\2\'\23\3\2\2\2\'\24\3"+
		"\2\2\2\'\35\3\2\2\2(\62\3\2\2\2)+\f\4\2\2*,\7\5\2\2+*\3\2\2\2,-\3\2\2"+
		"\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\5\f\7\2\60)\3\2\2\2\61\64\3\2\2\2"+
		"\62\60\3\2\2\2\62\63\3\2\2\2\63\5\3\2\2\2\64\62\3\2\2\2\65\66\7\b\2\2"+
		"\66\7\3\2\2\2\678\7\3\2\289\5\6\4\29:\7\4\2\2:;\5\4\3\2;\t\3\2\2\2<=\b"+
		"\6\1\2=J\5\6\4\2>@\7\6\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3"+
		"\2\2\2CE\5\b\5\2DF\7\7\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3"+
		"\2\2\2I<\3\2\2\2I?\3\2\2\2JT\3\2\2\2KM\f\3\2\2LN\7\5\2\2ML\3\2\2\2NO\3"+
		"\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\5\f\7\2RK\3\2\2\2SV\3\2\2\2TR\3"+
		"\2\2\2TU\3\2\2\2U\13\3\2\2\2VT\3\2\2\2Wn\5\6\4\2XY\7\6\2\2YZ\5\b\5\2Z"+
		"[\7\7\2\2[n\3\2\2\2\\^\7\6\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`a\3\2\2\2ac\5\n\6\2bd\7\5\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2"+
		"\2fg\3\2\2\2gi\5\f\7\2hj\7\7\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2ln\3\2\2\2mW\3\2\2\2mX\3\2\2\2m]\3\2\2\2n\r\3\2\2\2\21\30\37%\'-\62"+
		"AGIOT_ekm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}