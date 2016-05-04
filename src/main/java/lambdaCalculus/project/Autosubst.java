package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel Dao on 4/21/16.
 */
public class Autosubst {

    private final String lambda = "λ";
    private final String app = "@";

    private final String id = "id";         // identity symbol
    private final String shiftElem = "↑";   // shift-element symbol
    private final String shiftSub = "⇑";    // shift-substitution symbol
    private final String inst = "[]";       // instantiation symbol
    private final String comp = "◦";        // composition symbol
    private final String cons = "·";        // cons symbol
    private final String parens = "()";        // parentheses symbol

    private List<String> listLambda;    // store lambdas in the lambda abstraction of the term
    private List<Tree<String>> fullReductionSteps; // list stores all the steps for B-reduction

    private StandardLambda standardLambda;  // standardLambda after substitution
    private DeBruijnLambda deBruijnLambda;  // deBruijnLambda after substitution
    private String deBruijnFullReduction = "";           // complete steps for B-reduction in De Bruijn representation
    private String lambdaFullReduction = "";           // complete steps for B-reduction in standard lambda representation

    /**
     * Autosubst for StandardLambda input
     **/
    public Autosubst(StandardLambda standardLambda) {
        DeBruijnLambda converteddeBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
        DeBruijnLambda substitutedDeBruijnLambda = calculateSubstitution(converteddeBruijnLambda);

        setDeBruijnLambda(substitutedDeBruijnLambda);
        setStandardLambda(TermConverter.deBruijnToStandardLambda(substitutedDeBruijnLambda));
    }

    /**
     * Autosubst for DeBruijnLambda input
     **/
    public Autosubst(DeBruijnLambda deBruijnLambda) {
        DeBruijnLambda substitutedDeBruijnLambda = calculateSubstitution(deBruijnLambda);

        setDeBruijnLambda(substitutedDeBruijnLambda);
        setStandardLambda(TermConverter.deBruijnToStandardLambda(substitutedDeBruijnLambda));
    }

    /**
     * Get the substituted standard lambda term
     **/
    public StandardLambda getStandardLambda() {
        return standardLambda;
    }

    /**
     * Set the substituted standard lambda term
     **/
    public void setStandardLambda(StandardLambda standardLambda) {
        this.standardLambda = standardLambda;
    }

    /**
     * Get the substituted De Bruijn lambda term
     **/
    public DeBruijnLambda getDeBruijnLambda() {
        return deBruijnLambda;
    }

    /**
     * Set the substituted De Bruijn lambda term
     **/
    public void setDeBruijnLambda(DeBruijnLambda deBruijnLambda) {
        this.deBruijnLambda = deBruijnLambda;
    }

    /**
     * Get full B-reduction steps in De Bruijn representation
     **/
    public String getDeBruijnFullReduction() {
        return deBruijnFullReduction;
    }

    /**
     * Set full B-reduction steps in De Bruijn representation
     **/
    public void setDeBruijnFullReduction(String deBruijnFullReduction) {
        this.deBruijnFullReduction = deBruijnFullReduction;
    }

    /**
     * Get full B-reduction steps in standard lambda representation
     **/
    public String getLambdaFullReduction() {
        return lambdaFullReduction;
    }

    /**
     * Set full B-reduction steps in standard lambda representation
     **/
    public void setLambdaFullReduction(String lambdaFullReduction) {
        this.lambdaFullReduction = lambdaFullReduction;
    }

    /**
     * Execute the Cons operation: (s·σ)(x) = s if x=0 | σ(x - 1) otherwise
     * Tree looks like:     ()         s    |       ()
     *                     /  \   =         |      /  \
     *                    .   x             |     σ   x-1
     *                   / \                |
     *                  s  σ                |
     * Return calculated tree
     **/
    public Tree<String> consOp(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            if (inputTree.getRight().getData().equals("0")) {   // case x = 0
                result = inputTree.getLeft().getLeft();
            } else {
                /* Build x-1 */
                Tree<String> rightChild = new Tree<String>(Integer.parseInt(inputTree.getRight().getData())-1 + "", null, null);

                /* Build σ(x - 1) */
                result = new Tree<String>(parens, inputTree.getLeft().getRight(), rightChild);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Execute the identity operation: id(x) = x
     * Tree looks like:     ()         x
     *                     /  \   =
     *                    id  x
     * Return calculated tree
     **/
    public Tree<String> identity(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            result = inputTree.getRight();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Execute the Shift Element operation: ↑(x) = x + 1
     * Tree looks like:     ()         x+1
     *                     /  \   =
     *                    ↑   x
     * Return calculated tree
     **/
    public Tree<String> shiftElement(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            int num = Integer.parseInt(inputTree.getRight().getData());
            result = new Tree<String>(num + 1 + "", null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Execute the Shift Substitution operation: ⇑σ(x) = (0·(σ◦↑)) = 0 if x=0 | (σ◦↑)(x-1) otherwise
     * Tree looks like:     ()         0        ()
     *                     /  \   =   / \  |   /  \
     *                    ⇑   x               ◦   x-1
     *                     \                 / \
     *                     σ                σ  ↑
     * Return calculated tree
     **/
    public Tree<String> shiftSubstitution(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            if (inputTree.getRight().getData().equals("0")) {
                result = new Tree<String>("0", null, null);
            } else {
                /* Build x-1 */
                Tree<String> rightChild = new Tree<String>(Integer.parseInt(inputTree.getRight().getData()) - 1 + "", null, null);

                /* Build σ◦↑ */
                Tree<String> leftChild = new Tree<String>(comp, inputTree.getLeft().getRight(), new Tree<String>(shiftElem, null, null));

                /* Build (σ◦↑)(x-1)d */
                result = new Tree<String>(parens, leftChild, rightChild);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Execute the instantiation operations: x[σ] = σ(x)
     *                                       (t t')[σ] = (t[σ])(t'[σ])
     *                                       (λ.t)[σ] = λ.(t[⇑σ])
     *
     *  Tree looks like:     @          ()
     *                      / \   =    /  \
     *                     x  []      σ   x
     *                         \
     *                         σ
     *
     *
     *                       @             @
     *                     /  \   =    /      \
     *                    @   []      @        @
     *                   / \   \     / \     /  \
     *                  t  t'  σ    t  []    t' []
     *                                  \        \
     *                                  σ        σ
     *
     *
     *                       @          λ
     *                     /  \   =      \
     *                    λ   []         @
     *                     \   \        / \
     *                     t   σ       t  []
     *                                     \
     *                                     ⇑
     *                                     \
     *                                     σ
     * Return calculated tree
     **/
    public Tree<String> instantiation(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            if (inputTree.getLeft().getData().matches("[0-9]+")) {  // case 1: x[σ]
//                System.out.println("CASE 1");
                result = new Tree<String>(parens, inputTree.getRight().getRight(), inputTree.getLeft());
            } else if (inputTree.getLeft().getData().equals(app)) { // case 2: (t t')[σ]
//                System.out.println("CASE 2");
                /* Build [σ] */
                Tree<String> instChild = new Tree<String>(inst, null, inputTree.getRight().getRight());

                /* Build t[σ] */
                Tree<String> leftChild = new Tree<String>(app, inputTree.getLeft().getLeft(), instChild);

                /* Build t'[σ] */
                Tree<String> rightChild = new Tree<String>(app, inputTree.getLeft().getRight(), instChild);

                /* Build (t[σ])(t'[σ]) */
                result = new Tree<String>(app, leftChild, rightChild);
            } else if (inputTree.getLeft().getData().equals(lambda)) {  // case 3: (λ.t)[σ]
//                System.out.println("CASE 3");
                /* Build [⇑σ] */
                Tree<String> instChild = new Tree<String>(inst, null, new Tree<String>(shiftSub, null, inputTree.getRight().getRight()));

                /* Build t[⇑σ] */
                Tree<String> appChild = new Tree<String>(app, inputTree.getLeft().getRight(), instChild);

                /* Build λ.(t[⇑σ]) */
                result = new Tree<String>(lambda, null, appChild);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Execute the composition operation: (σ◦σ')(x) = σ(x)[σ']
     * Tree looks like:     ()            @
     *                     /  \   =     /   \
     *                    ◦   x        ()   []
     *                   / \          /  \   \
     *                  σ  σ'        σ   x   σ'
     * Return calculated tree
     **/
    public Tree<String> composition(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            /* Build [σ'] */
            Tree<String> rightChild = new Tree<String>(inst, null, inputTree.getLeft().getRight());

            /* Build σ(x) */
            Tree<String> leftChild = new Tree<String>(parens, inputTree.getLeft().getLeft(), inputTree.getRight());

            /* Build σ(x)[σ'] */
            result = new Tree<String>(app, leftChild, rightChild);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Execute the Beta-Reduction operation: (λ.t) t' -> t [t'·id]
     * Tree looks like:     @            @
     *                     / \    =    /   \
     *                    λ   t'      t    []
     *                     \                \
     *                     t                 ·
     *                                     /  \
     *                                    t'  id
     * Return calculated tree
     **/
    public Tree<String> betaReduction(Tree<String> inputTree) {
        Tree<String> result = null;
        try {
            /* Build [t'·id] */
            Tree<String> instTree = new Tree<String>(inst, null, new Tree<String>(cons, inputTree.getRight(), new Tree<String>(id, null, null)));

            /* Build t [t'·id] */
            result = new Tree<String>(app, inputTree.getLeft().getRight(), instTree);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Build a new tree with each lambda in the list as the root (for full B-reduction steps)
     */
    private Tree<String> addLambdaToTree(Tree<String> inputTree) {
        Tree<String> outputTree = inputTree;
        for (int x=0; x<listLambda.size(); x++) {
            outputTree = new Tree<String>(listLambda.get(x), null, outputTree);
        }
        return outputTree;
    }

    /**
     * Execute the Autosubst substitution for a given DeBruijn Tree
     * Return calculated DeBruijn Tree
     **/
    public Tree<String> calculateSubstTree(Tree<String> deBruijnTree) {
        Tree<String> inputTree = deBruijnTree;
        Tree<String> resultTree = null;
        try {
            boolean condition = true;
            while (condition) {
//                System.out.println("INPUT TREE");
                String data = inputTree.getData();
                if (data.matches("[0-9]+")) {
                    resultTree = inputTree;
                    condition = false;
                } else if (data.equals(lambda)) {                                      // start with "λ", lambda abstraction
                    listLambda.add(lambda);   // add lambda to list
                    resultTree = new Tree<String>(lambda, null, calculateSubstTree(inputTree.getRight()));
                    condition = false;
                } else if (data.equals(app)) {
                    if (inputTree.getRight().getData().equals(inst)) {          // Instantiation
                        if (inputTree.getLeft().getData().equals(lambda) | inputTree.getLeft().getData().equals(app) | inputTree.getLeft().getData().matches("[0-9]+")) {
//                            System.out.println("Instant");
                            inputTree = instantiation(inputTree);
                        } else {
                            Tree<String> leftChild = calculateSubstTree(inputTree.getLeft());
                            Tree<String> rightChild = calculateSubstTree(inputTree.getRight());
//                            System.out.println("Other App");
                            inputTree = new Tree<String>(app, leftChild, rightChild);
                        }
                    } else if (inputTree.getLeft().getData().equals(lambda)) {  // Beta-reduction
//                        System.out.println("Beta Reduc");
                        fullReductionSteps.add(addLambdaToTree(inputTree));   // add tree to the list of steps
                        inputTree = betaReduction(inputTree);
                    } else {
                        resultTree = new Tree<String>(app, calculateSubstTree(inputTree.getLeft()), calculateSubstTree(inputTree.getRight()));
//                        System.out.println("APP ELSE");
                        condition = false;
                    }
                } else if (data.equals(parens)) {                               // start with "()"
//                    System.out.println("parens");
                    data = inputTree.getLeft().getData();
                    if (data.equals(id)) {                                      // identity operation
//                        System.out.println("id");
                        inputTree = identity(inputTree);
                    } else  if (data.equals(shiftElem)) {                       // shift-element operation
//                        System.out.println("shiftElem");
                        inputTree = shiftElement(inputTree);
                    } else if (data.equals(shiftSub)) {                         // shift-substitution operation
//                        System.out.println("shiftSub");
                        inputTree = shiftSubstitution(inputTree);
                    } else if (data.equals(cons)) {                             // cons operation
//                        System.out.println("cons");
                        inputTree = consOp(inputTree);
                    } else if (data.equals(comp)) {                             // composition operation
//                        System.out.println("comp");
                        inputTree = composition(inputTree);
                    }
                } else {
//                    System.out.println("break");
                    resultTree = inputTree;
                    condition = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultTree;
    }

    /**
     * Execute the Autosubst substitution for a given DeBruijn Lambda
     * Return calculated DeBruijn Lambda
     **/
    public DeBruijnLambda calculateSubstitution(DeBruijnLambda inputLambda) {
        DeBruijnLambda deBruijnLambda = new DeBruijnLambda();
        fullReductionSteps = new ArrayList<Tree<String>>();
        listLambda = new ArrayList<String>();
        try {
            Tree<String> inputTree = inputLambda.getLambdaTree();
            Tree<String> calculatedTree = calculateSubstTree(inputTree);

            deBruijnLambda.setLambdaTree(calculatedTree);
            deBruijnLambda.setLambdaTerm(TermConverter.buildDeBruijnTerm(calculatedTree));

            /* Generate all B-reduction steps in de bruijn representation */
            fullReductionSteps.add(deBruijnLambda.getLambdaTree());
            for (Tree<String> x : fullReductionSteps) {
                deBruijnFullReduction += TermConverter.buildDeBruijnTerm(x) + "\n";

                /* Generate all B-reduction steps in standard lambda representation */
                List<Tree<String>> listTree = TermConverter.breakDeBruijnLambdaTree(x, new ArrayList<Map.Entry<String, Integer>>(), 0);
                lambdaFullReduction += TermConverter.buildStandardLambdaTerm(TermConverter.buildStandardLambdaTree(listTree)) + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deBruijnLambda;
    }
}
