// Generated from Puzzle8.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Puzzle8Parser}.
 */
public interface Puzzle8Listener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(Puzzle8Parser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(Puzzle8Parser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#instr}.
     *
     * @param ctx the parse tree
     */
    void enterInstr(Puzzle8Parser.InstrContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#instr}.
     *
     * @param ctx the parse tree
     */
    void exitInstr(Puzzle8Parser.InstrContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#register}.
     *
     * @param ctx the parse tree
     */
    void enterRegister(Puzzle8Parser.RegisterContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#register}.
     *
     * @param ctx the parse tree
     */
    void exitRegister(Puzzle8Parser.RegisterContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#op}.
     *
     * @param ctx the parse tree
     */
    void enterOp(Puzzle8Parser.OpContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#op}.
     *
     * @param ctx the parse tree
     */
    void exitOp(Puzzle8Parser.OpContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#blocks}.
     *
     * @param ctx the parse tree
     */
    void enterBlocks(Puzzle8Parser.BlocksContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#blocks}.
     *
     * @param ctx the parse tree
     */
    void exitBlocks(Puzzle8Parser.BlocksContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterCondition(Puzzle8Parser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitCondition(Puzzle8Parser.ConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle8Parser#comp}.
     *
     * @param ctx the parse tree
     */
    void enterComp(Puzzle8Parser.CompContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle8Parser#comp}.
     *
     * @param ctx the parse tree
     */
    void exitComp(Puzzle8Parser.CompContext ctx);
}