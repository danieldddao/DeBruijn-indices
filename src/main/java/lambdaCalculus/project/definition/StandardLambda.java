package lambdaCalculus.project.definition;

import lambdaCalculus.project.grammar.standardLambda.LambdaBaseListener;
import lambdaCalculus.project.grammar.standardLambda.LambdaParser;
import lambdaCalculus.project.tree.Tree;

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

    @Override
    public void exitLambdaTerm(LambdaParser.LambdaTermContext ctx) {
        setLambdaTerm(ctx.expr().getText().replace("\\", lambda));

        // reverse the list of trees
        Collections.reverse(lambdaTreeList);

        // build the tree based on the list
        setLambdaTree(new Tree<String>("", null, null).buildTreeFromRight(lambdaTreeList));
    }

    @Override
    public void exitExpr(LambdaParser.ExprContext ctx) {
        if (ctx.SPACE() != null && !ctx.SPACE().toString().isEmpty()) {
            Tree<String> tree = new Tree<String>(app, null, null);
            lambdaTreeList.add(tree);
        } else if (ctx.var() != null) {
            Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
            lambdaTreeList.add(tree);
        }
    }

    @Override
    public void exitAbst(LambdaParser.AbstContext ctx) {
        try {
            if (ctx.var() != null) {
                Tree<String> child = new Tree<String>(ctx.var().getText(), null, null);
                Tree<String> tree = new Tree<String>(lambda, child, null);
                lambdaTreeList.add(tree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitFunc(LambdaParser.FuncContext ctx) {
        try {
           if (ctx.var() != null) {
                Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
                lambdaTreeList.add(tree);
            } else if (ctx.SPACE() != null && !ctx.SPACE().toString().isEmpty()) {
                Tree<String> tree = new Tree<String>(app, null, null);
                lambdaTreeList.add(tree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitArg(LambdaParser.ArgContext ctx) {
        if (ctx.var() != null) {
            Tree<String> tree = new Tree<String>(ctx.var().getText(), null, null);
            lambdaTreeList.add(tree);
        } else if (ctx.LEFT_PAREN() != null && ctx.RIGHT_PAREN() != null) {
            if (ctx.abst() == null) {
                Tree<String> tree = new Tree<String>(app, null, null);
                lambdaTreeList.add(tree);
            }
        }
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
    public void setLambdaTree(Tree<String> lambdaTree) {
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
    public void setLambdaTerm(String lambdaTerm) {
        this.lambdaTerm = lambdaTerm;
    }
}
