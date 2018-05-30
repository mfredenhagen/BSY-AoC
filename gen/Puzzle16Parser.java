// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle16.g4 by ANTLR 4.7

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Puzzle16Parser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, NAME = 3, INT = 4, WS = 5;
    public static final int
            RULE_dancemoves = 0, RULE_move = 1, RULE_spin = 2, RULE_exchange = 3,
            RULE_partner = 4, RULE_intparams = 5, RULE_nameparams = 6, RULE_code = 7,
            RULE_x = 8, RULE_y = 9, RULE_a = 10, RULE_b = 11;
    public static final String[] ruleNames = {
            "dancemoves", "move", "spin", "exchange", "partner", "intparams", "nameparams",
            "code", "x", "y", "a", "b"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7C\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
                    "\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3\5\3&" +
                    "\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3" +
                    "\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16" +
                    "\20\22\24\26\30\2\2\29\2\32\3\2\2\2\4%\3\2\2\2\6\'\3\2\2\2\b*\3\2\2\2" +
                    "\n-\3\2\2\2\f\60\3\2\2\2\16\64\3\2\2\2\208\3\2\2\2\22:\3\2\2\2\24<\3\2" +
                    "\2\2\26>\3\2\2\2\30@\3\2\2\2\32\37\5\4\3\2\33\34\7\3\2\2\34\36\5\4\3\2" +
                    "\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3" +
                    "\2\2\2\"&\5\6\4\2#&\5\b\5\2$&\5\n\6\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&" +
                    "\5\3\2\2\2\'(\5\20\t\2()\7\6\2\2)\7\3\2\2\2*+\5\20\t\2+,\5\f\7\2,\t\3" +
                    "\2\2\2-.\5\20\t\2./\5\16\b\2/\13\3\2\2\2\60\61\5\22\n\2\61\62\7\4\2\2" +
                    "\62\63\5\24\13\2\63\r\3\2\2\2\64\65\5\26\f\2\65\66\7\4\2\2\66\67\5\30" +
                    "\r\2\67\17\3\2\2\289\7\5\2\29\21\3\2\2\2:;\7\6\2\2;\23\3\2\2\2<=\7\6\2" +
                    "\2=\25\3\2\2\2>?\7\5\2\2?\27\3\2\2\2@A\7\5\2\2A\31\3\2\2\2\4\37%";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "','", "'/'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, "NAME", "INT", "WS"
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

    public Puzzle16Parser(TokenStream input) {
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
        return "Puzzle16.g4";
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

    public final DancemovesContext dancemoves() throws RecognitionException {
        DancemovesContext _localctx = new DancemovesContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_dancemoves);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(24);
                move();
                setState(29);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__0) {
                    {
                        {
                            setState(25);
                            match(T__0);
                            setState(26);
                            move();
                        }
                    }
                    setState(31);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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

    public final MoveContext move() throws RecognitionException {
        MoveContext _localctx = new MoveContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_move);
        try {
            setState(35);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(32);
                    spin();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(33);
                    exchange();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(34);
                    partner();
                }
                break;
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

    public final SpinContext spin() throws RecognitionException {
        SpinContext _localctx = new SpinContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_spin);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(37);
                code();
                setState(38);
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

    public final ExchangeContext exchange() throws RecognitionException {
        ExchangeContext _localctx = new ExchangeContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_exchange);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(40);
                code();
                setState(41);
                intparams();
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

    public final PartnerContext partner() throws RecognitionException {
        PartnerContext _localctx = new PartnerContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_partner);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(43);
                code();
                setState(44);
                nameparams();
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

    public final IntparamsContext intparams() throws RecognitionException {
        IntparamsContext _localctx = new IntparamsContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_intparams);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(46);
                x();
                setState(47);
                match(T__1);
                setState(48);
                y();
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

    public final NameparamsContext nameparams() throws RecognitionException {
        NameparamsContext _localctx = new NameparamsContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_nameparams);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(50);
                a();
                setState(51);
                match(T__1);
                setState(52);
                b();
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

    public final CodeContext code() throws RecognitionException {
        CodeContext _localctx = new CodeContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_code);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                match(NAME);
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

    public final XContext x() throws RecognitionException {
        XContext _localctx = new XContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_x);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(56);
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

    public final YContext y() throws RecognitionException {
        YContext _localctx = new YContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_y);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(58);
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

    public final AContext a() throws RecognitionException {
        AContext _localctx = new AContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_a);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                match(NAME);
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

    public final BContext b() throws RecognitionException {
        BContext _localctx = new BContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_b);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(62);
                match(NAME);
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

    public static class DancemovesContext extends ParserRuleContext {
        public DancemovesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<MoveContext> move() {
            return getRuleContexts(MoveContext.class);
        }

        public MoveContext move(int i) {
            return getRuleContext(MoveContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dancemoves;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor)
                return ((Puzzle16Visitor<? extends T>) visitor).visitDancemoves(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MoveContext extends ParserRuleContext {
        public MoveContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SpinContext spin() {
            return getRuleContext(SpinContext.class, 0);
        }

        public ExchangeContext exchange() {
            return getRuleContext(ExchangeContext.class, 0);
        }

        public PartnerContext partner() {
            return getRuleContext(PartnerContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_move;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitMove(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SpinContext extends ParserRuleContext {
        public SpinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public TerminalNode INT() {
            return getToken(Puzzle16Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_spin;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitSpin(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExchangeContext extends ParserRuleContext {
        public ExchangeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public IntparamsContext intparams() {
            return getRuleContext(IntparamsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exchange;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitExchange(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PartnerContext extends ParserRuleContext {
        public PartnerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public NameparamsContext nameparams() {
            return getRuleContext(NameparamsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_partner;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitPartner(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntparamsContext extends ParserRuleContext {
        public IntparamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public XContext x() {
            return getRuleContext(XContext.class, 0);
        }

        public YContext y() {
            return getRuleContext(YContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_intparams;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor)
                return ((Puzzle16Visitor<? extends T>) visitor).visitIntparams(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NameparamsContext extends ParserRuleContext {
        public NameparamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AContext a() {
            return getRuleContext(AContext.class, 0);
        }

        public BContext b() {
            return getRuleContext(BContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nameparams;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor)
                return ((Puzzle16Visitor<? extends T>) visitor).visitNameparams(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CodeContext extends ParserRuleContext {
        public CodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME() {
            return getToken(Puzzle16Parser.NAME, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_code;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitCode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class XContext extends ParserRuleContext {
        public XContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(Puzzle16Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_x;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitX(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class YContext extends ParserRuleContext {
        public YContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(Puzzle16Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_y;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitY(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AContext extends ParserRuleContext {
        public AContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME() {
            return getToken(Puzzle16Parser.NAME, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_a;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitA(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BContext extends ParserRuleContext {
        public BContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NAME() {
            return getToken(Puzzle16Parser.NAME, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_b;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof Puzzle16Visitor) return ((Puzzle16Visitor<? extends T>) visitor).visitB(this);
            else return visitor.visitChildren(this);
        }
    }
}