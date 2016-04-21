package lambdaCalculus;

import lambdaCalculus.grammar.deBruijnLambda.DeBruijnBaseListener;
import lambdaCalculus.grammar.deBruijnLambda.DeBruijnParser;
import lambdaCalculus.tree.Tree;
import lambdaCalculus.tree.TreePrinter;

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

    public void exitLambdaTerm(DeBruijnParser.LambdaTermContext ctx) {
        // convert the "\" to "λ"
        setLambdaTerm(ctx.expr().getText().replace("\\", lambda));

        // reverse the list of trees
        Collections.reverse(lambdaTreeList);
        for (Tree<String> x : lambdaTreeList) {
            TreePrinter.printNode(x);
        }

        // build the tree based on the list
        setLambdaTree(Tree.buildTreeFromRight(lambdaTreeList));
    }

    public void exitExpr(DeBruijnParser.ExprContext ctx) {
//        System.out.println("EXIT EXPR " + ctx.getText());
//        System.out.println("" + ctx.LEFT_PAREN() + ctx.RIGHT_PAREN());

        if (ctx.num() != null) {
//            System.out.println("EXIT var " + ctx.var());
            Tree<String> tree = new Tree<String>(ctx.num().getText(), null, null);
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

    public void exitAbst(DeBruijnParser.AbstContext ctx) {
//        System.out.println("EXIT ABS: " + ctx.getText());
        try {
//                System.out.println("EXIT var " + ctx.var());
//                System.out.println("EXIT expr " + ctx.expr());
//            System.out.println();
            Tree<String> tree = new Tree<String>(lambda, null, null);
            lambdaTreeList.add(tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitFunc(DeBruijnParser.FuncContext ctx) {
//        System.out.println("EXIT FUNC: " + ctx.getText());
        try {
           if (ctx.num() != null) {
//                System.out.println("EXIT var " + ctx.var());
                Tree<String> tree = new Tree<String>(ctx.num().getText(), null, null);
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

    public void exitArg(DeBruijnParser.ArgContext ctx) {
//        System.out.println("EXIT ARG: " + ctx.getText());
        if (ctx.num() != null) {
//            System.out.println("EXIT var " + ctx.var());
            Tree<String> tree = new Tree<String>(ctx.num().getText(), null, null);
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
