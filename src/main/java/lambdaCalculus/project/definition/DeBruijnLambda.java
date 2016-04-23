package lambdaCalculus.project.definition;

import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnBaseListener;
import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnParser;
import lambdaCalculus.project.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel Dao on 4/15/16.
 */
public class DeBruijnLambda extends DeBruijnBaseListener {

    private final String lambda = "λ";
    private final String app = "@";

    private Tree<String> lambdaTree;
    private String lambdaTerm;

    private List<Tree<String>> lambdaTreeList;

    public DeBruijnLambda() {
        lambdaTreeList = new ArrayList<Tree<String>>();
    }

    @Override
    public void exitLambdaTerm(DeBruijnParser.LambdaTermContext ctx) {
        try {
            // convert the "\" to "λ"
            setLambdaTerm(ctx.expr().getText().replace("\\", lambda));

            // reverse the list of trees
            Collections.reverse(lambdaTreeList);

            // build the tree based on the list
            setLambdaTree(new Tree<String>("", null, null).buildTreeFromRight(lambdaTreeList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitExpr(DeBruijnParser.ExprContext ctx) {
        try {
            if (ctx.num() != null) {
                lambdaTreeList.add(new Tree<String>(ctx.num().getText(), null, null));
            } else if (ctx.SPACE() != null && !ctx.SPACE().toString().isEmpty()) {
                lambdaTreeList.add(new Tree<String>(app, null, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitAbst(DeBruijnParser.AbstContext ctx) {
        try {
            Tree<String> tree = new Tree<String>(lambda, null, null);
            lambdaTreeList.add(tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitFunc(DeBruijnParser.FuncContext ctx) {
        try {
           if (ctx.SPACE() != null && !ctx.SPACE().toString().isEmpty()) {
                Tree<String> tree = new Tree<String>(app, null, null);
                lambdaTreeList.add(tree);
            } else if (ctx.num() != null) {
               Tree<String> tree = new Tree<String>(ctx.num().getText(), null, null);
               lambdaTreeList.add(tree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitArg(DeBruijnParser.ArgContext ctx) {
        try {
            if (ctx.num() != null) {
                Tree<String> tree = new Tree<String>(ctx.num().getText(), null, null);
                lambdaTreeList.add(tree);
            } else if (ctx.LEFT_PAREN() != null && ctx.RIGHT_PAREN() != null) {
                if (ctx.abst() == null) {
                    Tree<String> tree = new Tree<String>(app, null, null);
                    lambdaTreeList.add(tree);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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