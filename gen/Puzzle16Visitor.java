// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle16.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Puzzle16Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Puzzle16Visitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#dancemoves}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDancemoves(Puzzle16Parser.DancemovesContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#move}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMove(Puzzle16Parser.MoveContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#spin}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSpin(Puzzle16Parser.SpinContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#exchange}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExchange(Puzzle16Parser.ExchangeContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#partner}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartner(Puzzle16Parser.PartnerContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#x}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitX(Puzzle16Parser.XContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#y}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitY(Puzzle16Parser.YContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#a}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitA(Puzzle16Parser.AContext ctx);

    /**
     * Visit a parse tree produced by {@link Puzzle16Parser#b}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitB(Puzzle16Parser.BContext ctx);
}