package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by Daniel Dao on 4/15/16.
 *
 * Convert lambda terms to De Bruijn terms.
 * And convert De Bruijn terms to lambda terms.
 */
public class TermConverter {

    private static final String lambda = "λ";
    private static final String app = "@";
    private static final String dot = ".";
    private static final String space = " ";
    private static final String leftParen = "(";
    private static final String rightParen = ")";

    private static int ct;  // for converting variable to number

    private static int codeASCII = 97; // ASCII code for lowercase characters ([a-z] = [97-122])
    private static int ctASCII = 0;

    /**
     * Return a lowercase character from a - z.
     **/
    private static String getVar() {
        String var = "";
        try {
            if (codeASCII == 123) {
                ctASCII++;
                codeASCII = 97; // reset to a
            } else if (ctASCII == 123) {
                ctASCII = 0;
            }

            if (ctASCII == 0) {
                var = Character.toString((char) codeASCII);
            } else {
                var = Character.toString((char) codeASCII) + Character.toString((char) (ctASCII + 96));
            }
            codeASCII++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return var;
    }

    /**
     * Break the De Bruijn lambda tree into smaller STANDARD LAMBDA trees and store them in the list of STANDARD LAMBDA sub-trees
     * Return a list of STANDARD LAMBDA sub-trees
     **/
    public static List<Tree<String>> breakDeBruijnLambdaTree(Tree<String> inputTree, List<Entry<String, Integer>> listVar) {
        List<Tree<String>> listTree = new ArrayList<Tree<String>>();

        try {
            if (inputTree.getData().matches("[0-9]+")) {  // If the node is a variable
                int num = Integer.parseInt(inputTree.getData());
                String var = null;
                for (Entry<String, Integer> entry : listVar) {
                    if (num == entry.getValue()) {
                        var = entry.getKey();
                    }
                }
                if (var == null)
                    var = getVar();

                Tree<String> child = new Tree<String>(var, null, null);
                listTree.add(child);
            }
            else if (inputTree.getData().equals(lambda)) {  // If the node is a lambda abstraction
                for (Entry<String, Integer> entry : listVar) {
                    entry.setValue(entry.getValue() + 1);
                }
                String var = getVar();
                Entry<String, Integer> entry = new SimpleEntry<String, Integer>(var, 0);
                listVar.add(entry);

                Tree<String> child = new Tree<String>(lambda, new Tree<String>(var, null, null), null);
                listTree.add(child);
                listTree.addAll(breakDeBruijnLambdaTree(inputTree.getRight(), listVar));
            } else if (inputTree.getData().equals(app)) {   // If the node is an application
                Tree<String> child = new Tree<String>(app, null, null);
                listTree.add(child);

                /* Make a copy of the listVar */
                List<Entry<String, Integer>> listVarCopy1 = new ArrayList<Entry<String, Integer>>();
                List<Entry<String, Integer>> listVarCopy2 = new ArrayList<Entry<String, Integer>>();
                for (Entry<String, Integer> entry : listVar) {
                    listVarCopy1.add(new SimpleEntry<String, Integer>(entry.getKey(), entry.getValue()));
                    listVarCopy2.add(new SimpleEntry<String, Integer>(entry.getKey(), entry.getValue()));
                }

                listTree.addAll(breakDeBruijnLambdaTree(inputTree.getRight(), listVarCopy2));
                listTree.addAll(breakDeBruijnLambdaTree(inputTree.getLeft(), listVarCopy1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTree;
    }

    /**
     * Build the Standard Lambda Tree based on the given list of sub-trees
     */
    public static Tree<String> buildStandardLambdaTree(List<Tree<String>> listTree) {
        Tree<String> tree = new Tree<String>("", null, null);
        return tree.buildTreeFromRight(listTree);
    }

    /**
     * Build the Standard Lambda term based on the given Standard Lambda Tree
     */
    public static String buildStandardLambdaTerm(Tree<String> inputTree) {
        String term = "";
        try {
            if (inputTree.getData().matches("[a-z]+")) {
                term += inputTree.getData();
            }else if (inputTree.getData().equals(lambda)) {
                /* insert lambda abstraction */
                term += lambda + inputTree.getLeft().getData() + dot; // insert "λ" var "."
                term += buildStandardLambdaTerm(inputTree.getRight());
            } else if (inputTree.getData().equals(app)) {

                // if function is a lambda abstraction, surround it with parentheses
                if (inputTree.getLeft().getData().equals(lambda)) {
                    term += leftParen + buildStandardLambdaTerm(inputTree.getLeft()) + rightParen;
                } else {
                    term += buildStandardLambdaTerm(inputTree.getLeft());
                }

                term += space; // insert " " between function and argument

                // if argument is a lambda abstraction, surround it with parentheses
                if (inputTree.getRight().getData().equals(lambda) | inputTree.getRight().getData().equals(app)) {
                    term += leftParen + buildStandardLambdaTerm(inputTree.getRight()) + rightParen;
                } else {
                    term += buildStandardLambdaTerm(inputTree.getRight());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }

    /**
     * Convert the DeBruijnLambda to StandardLambda
     **/
    public static StandardLambda deBruijnToStandardLambda(DeBruijnLambda deBruijnLambda) {
        List<Tree<String>> listTree = breakDeBruijnLambdaTree(deBruijnLambda.getLambdaTree(), new ArrayList<Entry<String, Integer>>());

        /* Create a StandardLambda from the given DeBruijnLambda */
        StandardLambda standardLambda = new StandardLambda();
        standardLambda.setLambdaTree(buildStandardLambdaTree(listTree));
        standardLambda.setLambdaTerm(buildStandardLambdaTerm(standardLambda.getLambdaTree()));

        return standardLambda;
    }

    /**
     * Break the standard lambda tree into smaller DE BRUIJN trees and store them in the list of DE BRUIJN sub-trees
     * Return a list of DE BRUIJN sub-trees
     **/
    private static List<Tree<String>> breakStandardLambdaTree(Tree<String> inputTree, List<Entry<String, Integer>> listVar) {
        List<Tree<String>> listTree = new ArrayList<Tree<String>>();
        try {
            if (inputTree.getData().matches("[a-z]")) {  // If the node is a variable
                int num = -1;
                if (listVar.size() == 0) { // If there's no lambda abstraction in the tree
                    num = ct;
                    ct++;
                } else {
                    String var = inputTree.getData();
                    for (int x = listVar.size()-1; x >=0; x--) {
                        if (var.equals(listVar.get(x).getKey())) {
                            num = listVar.get(x).getValue();
                            break;
                        }
                    }
                    if (num == -1) {  // If the variable is a free variable in the tree
                        ct++;
                        num = listVar.get(0).getValue() + ct;
                    }
                }
                Tree<String> child = new Tree<String>(num + "", null, null);
                listTree.add(child);
            }
            else if (inputTree.getData().equals(lambda)) {  // If the node is a lambda abstraction
                for (Entry<String, Integer> entry : listVar) {
                    entry.setValue(entry.getValue() + 1);
                }
                Entry<String, Integer> entry = new SimpleEntry<String, Integer>(inputTree.getLeft().getData(), 0);
                listVar.add(entry);

                Tree<String> child = new Tree<String>(lambda, null, null);
                listTree.add(child);
                listTree.addAll(breakStandardLambdaTree(inputTree.getRight(), listVar));
            } else if (inputTree.getData().equals(app)) {   // If the node is an application
                Tree<String> child = new Tree<String>(app, null, null);
                listTree.add(child);

                 /* Make a copy of the listVar */
                List<Entry<String, Integer>> listVarCopy1 = new ArrayList<Entry<String, Integer>>();
                List<Entry<String, Integer>> listVarCopy2 = new ArrayList<Entry<String, Integer>>();
                for (Entry<String, Integer> entry : listVar) {
                    listVarCopy1.add(new SimpleEntry<String, Integer>(entry.getKey(), entry.getValue()));
                    listVarCopy2.add(new SimpleEntry<String, Integer>(entry.getKey(), entry.getValue()));
                }

                listTree.addAll(breakStandardLambdaTree(inputTree.getLeft(), listVarCopy1));
                listTree.addAll(breakStandardLambdaTree(inputTree.getRight(), listVarCopy2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTree;
    }

    /**
     * Build the DeBruijn Lambda Tree based on the given list of sub-trees
     */
    private static Tree<String> buildDeBruijnTree(List<Tree<String>> listTree) {
        Tree<String> tree = new Tree<String>("", null, null);
        return tree.buildTreeFromLeft(listTree);
    }

    /**
     * Build the De Bruijn term based on the given De Bruijn tree
     **/
    public static String buildDeBruijnTerm(Tree<String> inputTree) {
        String term = "";
        try {
            if (inputTree.getData().matches("[0-9]+")) {
                term += inputTree.getData();
            }else if (inputTree.getData().equals(lambda)) {
                 term += lambda + dot; // insert "λ."
                 term += buildDeBruijnTerm(inputTree.getRight());
             } else if (inputTree.getData().equals(app)) {
                // if function is a lambda abstraction, surround it with parentheses
                if (inputTree.getLeft().getData().equals(lambda)) {
                    term += leftParen + buildDeBruijnTerm(inputTree.getLeft()) + rightParen;
                } else {
                    term += buildDeBruijnTerm(inputTree.getLeft());
                }

                term += space; // insert " " between function and argument

                // if argument is a lambda abstraction, surround it with parentheses
                if (inputTree.getRight().getData().equals(lambda) | inputTree.getRight().getData().equals(app)) {
                    term += leftParen + buildDeBruijnTerm(inputTree.getRight()) + rightParen;
                } else {
                    term += buildDeBruijnTerm(inputTree.getRight());
                }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }

    /**
     * Convert the StandardLambda to DeBruijnLambda
     **/
    public static DeBruijnLambda standardLambdaToDeBruijn(StandardLambda standardLambda) {
        ct = 0;

        /* Break standard lambda tree into small subtrees */
        List<Tree<String>> listTree = breakStandardLambdaTree(standardLambda.getLambdaTree(), new ArrayList<Entry<String, Integer>>());

        /* Create a DeBruijnLambda from the list of subtrees */
        DeBruijnLambda deBruijnLambda = new DeBruijnLambda();
        deBruijnLambda.setLambdaTree(buildDeBruijnTree(listTree));
        deBruijnLambda.setLambdaTerm(buildDeBruijnTerm(deBruijnLambda.getLambdaTree()));

        return deBruijnLambda;
    }
}
