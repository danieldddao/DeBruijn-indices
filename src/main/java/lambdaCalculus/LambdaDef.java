package lambdaCalculus;

import lambdaCalculus.Tree.Tree;

import lambdaCalculus.Tree.TreePrinter;
import lambdaCalculus.grammar.LambdaBaseListener;
import lambdaCalculus.grammar.LambdaParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel Dao on 4/15/16.
 */
public class LambdaDef extends LambdaBaseListener {

    private final String lambda = "λ";
    private final String app = "@";

    private Tree<String> lambdaTree;
    private List<Tree<String>> lambdaTreeList;
    private String lambdaTerm;

    public LambdaDef() {
        lambdaTreeList = new ArrayList<Tree<String>>();
    }

    public void enterLambdaTerm(LambdaParser.LambdaTermContext ctx) {

    }

    public Tree<String> buildTree (List<Tree<String>> list) {
        Tree<String> tree = null;
        try {
            if (list.size() == 1) {
                tree = list.remove(0);
            } else if (list.get(0).getData().equals(lambda)) {
                tree = list.remove(0);
                tree.setRight(buildTree(list));
            } else if (list.get(0).getData().equals(app)) {
                tree = list.remove(0);
                tree.setRight(buildTree(list));
                tree.setLeft(buildTree(list));
            } else {
                tree = list.remove(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tree;
    }

    public void exitLambdaTerm(LambdaParser.LambdaTermContext ctx) {
        setLambdaTerm(ctx.expr().getText().replace("\\", lambda));

        // reverse the list of trees
        Collections.reverse(lambdaTreeList);

        // build the tree based on the list
        setLambdaTree(buildTree(lambdaTreeList));
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
        System.out.println("EXIT ABS: " + ctx.getText());
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
    private void setLambdaTree(Tree<String> lambdaTree) {
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
    private void setLambdaTerm(String lambdaTerm) {
        this.lambdaTerm = lambdaTerm;
    }

    private int findTermInParens(String term) {
        int index = -1;
        LinkedList<Character> list = new LinkedList<Character>();

        try {
            char[] charTerm = term.toCharArray();
            for (int x=0; x < charTerm.length; x++) {
                if (charTerm[x] == '(')
                    list.add(charTerm[x]);
                else if (charTerm[x] == ')')
                    list.remove();
                if (list.size() == 0)
                    return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    /*
     * Convert the standard lambda term to a tree.
     */
//    private Tree<Character> toTree (String term) {
//        Tree<Character> tree = null;
//        try {
//            char firstLetter = term.charAt(0);  // first letter of the term
//
//            if (firstLetter == '(') {   // if the first letter is "("
//                int index = findTermInParens(term);
//                if(index > 0) {
//                    if (index == term.length()-1) {
//                        term = term.substring(1, index);
//                        tree = toTree(term);
//                    } else {
//                        Tree<Character> leftChild = toTree(term.substring(1, index));
//                        term = term.substring(index + 1);
//                        if (term.charAt(0) == ' ') {
//                            term = term.substring(1);
//                            tree = new Tree<Character>(app, leftChild, toTree(term));
//                        }
//                    }
//                }
//
//            } else if (firstLetter == lambda) { // if the first letter is a λ
//
//                term = term.substring(1);
//                int dot = term.indexOf('.');
//                char var = term.charAt(0);
//                term = term.substring(dot + 1);
//                Tree<Character> leftChild = new Tree<Character>(var, null, null);
//                tree = new Tree<Character>(lambda, leftChild, toTree(term));
//
//            } else if ((firstLetter >= 'a' && firstLetter <= 'z') || (firstLetter >= 'A' && firstLetter <= 'Z')) {
//
//                int whiteSpace = term.indexOf(' ');
//                if (whiteSpace > 0) {
//                    char var = term.charAt(0);
//                    term = term.substring(whiteSpace + 1);
//
//                    Tree<Character> leftChild = new Tree<Character>(var, null, null);
//                    tree = new Tree<Character>(app, leftChild, toTree(term));
//                } else {
//                    tree = new Tree<Character>(firstLetter, null, null);
//                }
//            }
//
//            //System.out.println("Term: " + term);
//            //System.out.println("List: " + list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return tree;
//    }

    /*
     * Convert the input term to corresponding standard lambda term
     */
    public String lambdaConvert(String input) {
        String term = "";

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return term;
    }

}
