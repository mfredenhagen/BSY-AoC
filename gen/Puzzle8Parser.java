// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle8.g4 by ANTLR 4.7

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Puzzle8Parser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            ID = 10, INT = 11, NEWLINE = 12, WS = 13, ANY = 14;
    public static final int
            RULE_prog = 0, RULE_instr = 1, RULE_register = 2, RULE_op = 3, RULE_value = 4,
            RULE_condition = 5, RULE_comp = 6;
    public static final String[] ruleNames = {
            "prog", "instr", "register", "op", "value", "condition", "comp"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\60\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2\f" +
                    "\2\16\2\27\13\2\3\2\5\2\32\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5" +
                    "\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\4" +
                    "\3\2\3\4\3\2\6\13\2*\2\20\3\2\2\2\4\35\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2" +
                    "\n&\3\2\2\2\f(\3\2\2\2\16-\3\2\2\2\20\25\5\4\3\2\21\22\7\16\2\2\22\24" +
                    "\5\4\3\2\23\21\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\31" +
                    "\3\2\2\2\27\25\3\2\2\2\30\32\7\16\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32\33" +
                    "\3\2\2\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\5\6\4\2\36\37\5\b\5\2\37 \5" +
                    "\n\6\2 !\5\f\7\2!\5\3\2\2\2\"#\7\f\2\2#\7\3\2\2\2$%\t\2\2\2%\t\3\2\2\2" +
                    "&\'\7\r\2\2\'\13\3\2\2\2()\7\5\2\2)*\5\6\4\2*+\5\16\b\2+,\5\n\6\2,\r\3" +
                    "\2\2\2-.\t\3\2\2.\17\3\2\2\2\4\25\31";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'inc'", "'dec'", "'if'", "'>'", "'<'", "'>='", "'<='", "'=='",
            "'!='"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, "ID", "INT",
            "NEWLINE", "WS", "ANY"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public Puzzle8Parser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "Puzzle8.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(14);
                instr();
                setState(19);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(15);
                                match(NEWLINE);
                                setState(16);
                                instr();
                            }
                        }
                    }
                    setState(21);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                }
                setState(23);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NEWLINE) {
                    {
                        setState(22);
                        match(NEWLINE);
                    }
                }

                setState(25);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InstrContext instr() throws RecognitionException {
        InstrContext _localctx = new InstrContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_instr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(27);
                register();
                setState(28);
                op();
                setState(29);
                value();
                setState(30);
                condition();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RegisterContext register() throws RecognitionException {
        RegisterContext _localctx = new RegisterContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_register);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(32);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final OpContext op() throws RecognitionException {
        OpContext _localctx = new OpContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_op);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(34);
                _la = _input.LA(1);
                if (!(_la == T__0 || _la == T__1)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(36);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConditionContext condition() throws RecognitionException {
        ConditionContext _localctx = new ConditionContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_condition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(38);
                match(T__2);
                setState(39);
                register();
                setState(40);
                comp();
                setState(41);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CompContext comp() throws RecognitionException {
        CompContext _localctx = new CompContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_comp);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(43);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ProgContext extends ParserRuleContext {
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<InstrContext> instr() {
            return getRuleContexts(InstrContext.class);
        }

        public InstrContext instr(int i) {
            return getRuleContext(InstrContext.class, i);
        }

        public TerminalNode EOF() {
            return getToken(Puzzle8Parser.EOF, 0);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(Puzzle8Parser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(Puzzle8Parser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitProg(this);
        }
    }

    public static class InstrContext extends ParserRuleContext {
        public InstrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public RegisterContext register() {
            return getRuleContext(RegisterContext.class, 0);
        }

        public OpContext op() {
            return getRuleContext(OpContext.class, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterInstr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitInstr(this);
        }
    }

    public static class RegisterContext extends ParserRuleContext {
        public RegisterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(Puzzle8Parser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_register;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterRegister(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitRegister(this);
        }
    }

    public static class OpContext extends ParserRuleContext {
        public OpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterOp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitOp(this);
        }
    }

    public static class ValueContext extends ParserRuleContext {
        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(Puzzle8Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitValue(this);
        }
    }

    public static class ConditionContext extends ParserRuleContext {
        public ConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public RegisterContext register() {
            return getRuleContext(RegisterContext.class, 0);
        }

        public CompContext comp() {
            return getRuleContext(CompContext.class, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_condition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitCondition(this);
        }
    }

    public static class CompContext extends ParserRuleContext {
        public CompContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).enterComp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle8Listener) ((Puzzle8Listener) listener).exitComp(this);
        }
    }
}