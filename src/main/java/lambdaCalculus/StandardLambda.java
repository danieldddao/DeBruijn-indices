package lambdaCalculus;

import lambdaCalculus.grammar.standardLambda.LambdaBaseListener;
import lambdaCalculus.grammar.standardLambda.LambdaParser;
import lambdaCalculus.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel Dao on 4/15/16.
 */
public class StandardLambda extends LambdaBaseListener {

    private final String lambda = "λ";
    private final String app = "@";

    private Tree<String> lambdaTree;
    private List<Tree<String>> lambdaTreeList;
    private String lambdaTerm;

    public StandardLambda() {
        lambdaTreeList = new ArrayList<Tree<String>>();
    }

    public void enterLambdaTerm(LambdaParser.LambdaTermContext ctx) {

    }

    public void exitLambdaTerm(LambdaParser.LambdaTermContext ctx) {
        setLambdaTerm(ctx.expr().getText().replace("\\", lambda));

        // reverse the list of trees
        Collections.reverse(lambdaTreeList);

        // build the tree based on the list
        setLambdaTree(Tree.buildTreeFromRight(lambdaTreeList));
    }

    public void enterExpr(LambdaParser.ExprContext ctx) {
//        System.out.println("EN EXPR " + ctx.getText());
//        System.out.println("EN EXPR PAREN " + ctx.LEFT_PAREN());
//        System.out.println("EN SPACE " + ctx.SPACE());
//        System.out.println("EN VAR " + ctx.var());
//        System.out.println("EN abst " + ctx.abst());
//        System.out.println("EN func " + ctx.func());
//        System.out.println("EN arg " + ctx.arg());
//        System.out.println();
    }

    public void exitExpr(LambdaParser.ExprContext ctx) {
//        System.out.println("EXIT EXPR " + ctx.getText());
//        System.out.println("" + ctx.LEFT_PAREN() + ctx.RIGHT_PAREN());

        if (ctx.var() != null) {
//            System.out.println("EXIT var " + ctx.var());
            Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
            lambdaTreeList.add(tree);
        } else if (ctx.abst() != null) {
//            System.out.println("EXIT abst " + ctx.abst());
        } else if (ctx.SPACE() != null && !ctx.SPACE().isEmpty()) {
//            System.out.println("EXIT space " + ctx.SPACE());
//            System.out.println("EXIT func " + ctx.func());
//            System.out.println("EXIT arg " + ctx.arg());
            Tree<String> tree = new Tree<String>(app, null, null);
            lambdaTreeList.add(tree);
        } else if (ctx.LEFT_PAREN() != null && ctx.RIGHT_PAREN() != null && !ctx.LEFT_PAREN().isEmpty() && !ctx.RIGHT_PAREN().isEmpty()) {
//            System.out.println("EXIT paren " + ctx.LEFT_PAREN());
        }
//        System.out.println();


    }

    public void enterAbst(LambdaParser.AbstContext ctx) {

    }

    public void exitAbst(LambdaParser.AbstContext ctx) {
//        System.out.println("EXIT ABS: " + ctx.getText());
        try {
            if (ctx.var() != null) {
//                System.out.println("EXIT var " + ctx.var());
//                System.out.println("EXIT expr " + ctx.expr());
                Tree<String> child = new Tree<String>(ctx.var().getText(), null, null);
                Tree<String> tree = new Tree<String>(lambda, child, null);
                lambdaTreeList.add(tree);
            }
//            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterFunc(LambdaParser.FuncContext ctx) {
        //System.out.println("ENTER FUNC: " + ctx.getText());
    }

    public void exitFunc(LambdaParser.FuncContext ctx) {
//        System.out.println("EXIT FUNC: " + ctx.getText());
        try {
           if (ctx.var() != null) {
//                System.out.println("EXIT var " + ctx.var());
                Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
                lambdaTreeList.add(tree);
            } else if (ctx.SPACE() != null && !ctx.SPACE().isEmpty()) {
//                System.out.println("EXIT space " + ctx.SPACE());
//                System.out.println("EXIT func " + ctx.func());
//                System.out.println("EXIT arg " + ctx.arg());
                Tree<String> tree = new Tree<String>(app, null, null);
                lambdaTreeList.add(tree);
            }
//            System.out.println("EXIT paren " + ctx.LEFT_PAREN());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println();

    }

    public void enterArg(LambdaParser.ArgContext ctx) {
        //System.out.println("ENTER ARG: " + ctx.getText());
    }

    public void exitArg(LambdaParser.ArgContext ctx) {
//        System.out.println("EXIT ARG: " + ctx.getText());
        if (ctx.var() != null) {
//            System.out.println("EXIT var " + ctx.var());
            Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
            lambdaTreeList.add(tree);
        } else if (ctx.LEFT_PAREN() != null && ctx.RIGHT_PAREN() != null) {
            if (ctx.abst() != null) {
//                System.out.println("EXIT abst " + ctx.abst());
            } else {
//                System.out.println("EXIT func " + ctx.func());
//                System.out.println("EXIT arg " + ctx.arg());
                Tree<String> tree = new Tree<String>(app, null, null);
                lambdaTreeList.add(tree);
            }
        }
            System.out.println();
    }

    public void enterVar(LambdaParser.VarContext ctx) {
        //System.out.println("ENTER VAR: " + ctx.getText());
    }

    public void exitVar(LambdaParser.VarContext ctx) {
        //System.out.println("EXIT VAR: " + ctx.getText());
        //Tree<String> tree = new Tree<String>(ctx.getText(), null, null);
        //lambdaTreeList.add(tree);
    }

    /*
     * Get the lambda tree
     */
    public Tree<String> getLambdaTree() {
        return lambdaTree;
    }

    /*
     * Set the lambda tree
     */
    protected void setLambdaTree(Tree<String> lambdaTree) {
        this.lambdaTree = lambdaTree;
    }

    /*
     * Get the lambda term
     */
    public String getLambdaTerm() {
        return lambdaTerm;
    }

    /*
     * Set the lambda term
     */
    protected void setLambdaTerm(String lambdaTerm) {
        this.lambdaTerm = lambdaTerm;
    }
}
