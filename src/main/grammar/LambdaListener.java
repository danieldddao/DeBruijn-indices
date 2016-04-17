// Generated from Lambda by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LambdaParser}.
 */
public interface LambdaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LambdaParser#lambdaTerm}.
	 * @param ctx the parse tree
	 */
	void enterLambdaTerm(LambdaParser.LambdaTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#lambdaTerm}.
	 * @param ctx the parse tree
	 */
	void exitLambdaTerm(LambdaParser.LambdaTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LambdaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LambdaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(LambdaParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(LambdaParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#abs}.
	 * @param ctx the parse tree
	 */
	void enterAbs(LambdaParser.AbsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#abs}.
	 * @param ctx the parse tree
	 */
	void exitAbs(LambdaParser.AbsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(LambdaParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(LambdaParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(LambdaParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(LambdaParser.ArgContext ctx);
}