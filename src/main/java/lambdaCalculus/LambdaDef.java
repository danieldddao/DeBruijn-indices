package lambdaCalculus;

import lambdaCalculus.Tree.Tree;
import lambdaCalculus.Tree.TreePrinter;

import java.util.LinkedList;
import java.util.jar.Pack200;

/**
 * Created by Daniel Dao on 4/15/16.
 */
public class LambdaDef {

    private final char lambda = 'λ';
    private final char app = '@';

    private Tree<Character> lambdaTree;
    private String lambdaTerm;

    public LambdaDef(String input) {

        try {

            // check the input format
            if (!isLambdaTerm(input))
                throw new Exception("Error! Given term is not in correct format!\n" + input);

            // Replace backslash with λ
            setLambdaTerm(input.replace("\\", "" + lambda));

            // Convert the lambdaTerm to lambdaTree
             setLambdaTree(toTree(lambdaTerm));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Tree<Character> getLambdaTree() {
        return lambdaTree;
    }

    private void setLambdaTree(Tree<Character> lambdaTree) {
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

    /*
     * Check if the given input is in valid format
     */
    public boolean isLambdaTerm(String input) {
        boolean result = true;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
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
    private Tree<Character> toTree (String term) {
        Tree<Character> tree = null;
        try {
            char firstLetter = term.charAt(0);  // first letter of the term

            if (firstLetter == '(') {   // if the first letter is "("
                int index = findTermInParens(term);
                if(index > 0) {
                    if (index == term.length()-1) {
                        term = term.substring(1, index);
                        tree = toTree(term);
                    } else {
                        Tree<Character> leftChild = toTree(term.substring(1, index));
                        term = term.substring(index + 1);
                        if (term.charAt(0) == ' ') {
                            term = term.substring(1);
                            tree = new Tree<Character>(app, leftChild, toTree(term));
                        }
                    }
                }

            } else if (firstLetter == lambda) { // if the first letter is a λ

                term = term.substring(1);
                int dot = term.indexOf('.');
                char var = term.charAt(0);
                term = term.substring(dot + 1);
                Tree<Character> leftChild = new Tree<Character>(var, null, null);
                tree = new Tree<Character>(lambda, leftChild, toTree(term));

            } else if ((firstLetter >= 'a' && firstLetter <= 'z') || (firstLetter >= 'A' && firstLetter <= 'Z')) {

                int whiteSpace = term.indexOf(' ');
                if (whiteSpace > 0) {
                    char var = term.charAt(0);
                    term = term.substring(whiteSpace + 1);

                    Tree<Character> leftChild = new Tree<Character>(var, null, null);
                    tree = new Tree<Character>(app, leftChild, toTree(term));
                } else {
                    tree = new Tree<Character>(firstLetter, null, null);
                }
            }

            //System.out.println("Term: " + term);
            //System.out.println("List: " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tree;
    }

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
