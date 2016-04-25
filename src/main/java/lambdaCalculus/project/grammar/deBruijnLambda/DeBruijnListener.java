package lambdaCalculus.project.grammar.deBruijnLambda;// Generated from DeBruijn by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DeBruijnParser}.
 */
public interface DeBruijnListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#lambdaTerm}.
	 * @param ctx the parse tree
	 */
	void enterLambdaTerm(DeBruijnParser.LambdaTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#lambdaTerm}.
	 * @param ctx the parse tree
	 */
	void exitLambdaTerm(DeBruijnParser.LambdaTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DeBruijnParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DeBruijnParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(DeBruijnParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(DeBruijnParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#abst}.
	 * @param ctx the parse tree
	 */
	void enterAbst(DeBruijnParser.AbstContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#abst}.
	 * @param ctx the parse tree
	 */
	void exitAbst(DeBruijnParser.AbstContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(DeBruijnParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(DeBruijnParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeBruijnParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(DeBruijnParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeBruijnParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(DeBruijnParser.ArgContext ctx);
}