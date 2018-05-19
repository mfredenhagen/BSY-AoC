// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle12.g4 by ANTLR 4.7

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
public class Puzzle12Parser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, INT = 3, NEWLINE = 4, WS = 5, ANY = 6;
    public static final int
            RULE_list = 0, RULE_prog = 1, RULE_name = 2, RULE_pipes = 3;
    public static final String[] ruleNames = {
            "list", "prog", "name", "pipes"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b \4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\4" +
                    "\3\4\3\5\3\5\3\5\5\5\32\n\5\6\5\34\n\5\r\5\16\5\35\3\5\2\2\6\2\4\6\b\2" +
                    "\2\2\36\2\r\3\2\2\2\4\21\3\2\2\2\6\24\3\2\2\2\b\26\3\2\2\2\n\13\5\4\3" +
                    "\2\13\f\7\6\2\2\f\16\3\2\2\2\r\n\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17" +
                    "\20\3\2\2\2\20\3\3\2\2\2\21\22\5\6\4\2\22\23\5\b\5\2\23\5\3\2\2\2\24\25" +
                    "\7\5\2\2\25\7\3\2\2\2\26\33\7\3\2\2\27\31\5\6\4\2\30\32\7\4\2\2\31\30" +
                    "\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\27\3\2\2\2\34\35\3\2\2\2\35\33" +
                    "\3\2\2\2\35\36\3\2\2\2\36\t\3\2\2\2\5\17\31\35";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'<->'", "','"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, "INT", "NEWLINE", "WS", "ANY"
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

    public Puzzle12Parser(TokenStream input) {
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
        return "Puzzle12.g4";
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

    public final ListContext list() throws RecognitionException {
        ListContext _localctx = new ListContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(11);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(8);
                            prog();
                            setState(9);
                            match(NEWLINE);
                        }
                    }
                    setState(13);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == INT);
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

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_prog);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(15);
                name();
                setState(16);
                pipes();
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

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(18);
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

    public final PipesContext pipes() throws RecognitionException {
        PipesContext _localctx = new PipesContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_pipes);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(20);
                match(T__0);
                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(21);
                            name();
                            setState(23);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T__1) {
                                {
                                    setState(22);
                                    match(T__1);
                                }
                            }

                        }
                    }
                    setState(27);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == INT);
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

    public static class ListContext extends ParserRuleContext {
        public ListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ProgContext> prog() {
            return getRuleContexts(ProgContext.class);
        }

        public ProgContext prog(int i) {
            return getRuleContext(ProgContext.class, i);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(Puzzle12Parser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(Puzzle12Parser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_list;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).enterList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).exitList(this);
        }
    }

    public static class ProgContext extends ParserRuleContext {
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public PipesContext pipes() {
            return getRuleContext(PipesContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).exitProg(this);
        }
    }

    public static class NameContext extends ParserRuleContext {
        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(Puzzle12Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).exitName(this);
        }
    }

    public static class PipesContext extends ParserRuleContext {
        public PipesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<NameContext> name() {
            return getRuleContexts(NameContext.class);
        }

        public NameContext name(int i) {
            return getRuleContext(NameContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pipes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).enterPipes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle12Listener) ((Puzzle12Listener) listener).exitPipes(this);
        }
    }
}