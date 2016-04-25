package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;
import lambdaCalculus.project.tree.Tree;
import lambdaCalculus.project.tree.TreePrinter;

import java.util.ArrayList;
import java.util.List;

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

    private List<Tree<String>> lambdaTreeList;
    private StandardLambda standardLambda;  // standardLambda after substitution
    private DeBruijnLambda deBruijnLambda;  // deBruijnLambda after substitution

    /**
     * Autosubst for StandardLambda input
     **/
    public Autosubst (StandardLambda standardLambda) {
        lambdaTreeList = new ArrayList<Tree<String>>();
        DeBruijnLambda converteddeBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
        DeBruijnLambda substitutedDeBruijnLambda = calculateSubstitution(converteddeBruijnLambda);
        //setDeBruijnLambda(substitutedDeBruijnLambda);
        //setStandardLambda(TermConverter.deBruijnToStandardLambda(substitutedDeBruijnLambda));
    }

    /**
     * Autosubst for DeBruijnLambda input
     **/
    public Autosubst (DeBruijnLambda deBruijnLambda) {
        lambdaTreeList = new ArrayList<Tree<String>>();
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
     * Get the substituted De Bruijn lambda term
     **/
    public void setDeBruijnLambda(DeBruijnLambda deBruijnLambda) {
        this.deBruijnLambda = deBruijnLambda;
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
     * Execute the Shift Substitution operation: ⇑σ(x) = (0·(σ◦↑)) = (σ◦↑)(x-1) if x != 0, else 0
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
                System.out.println("CASE 1");
                if (inputTree.getLeft().getData().equals("0")) {    // case 0[σ]
                    lambdaTreeList.add(new Tree<String>("0", null, null));
                } else {
                    result = new Tree<String>(parens, inputTree.getRight().getRight(), inputTree.getLeft());
                }
            } else if (inputTree.getLeft().getData().equals(app)) { // case 2: (t t')[σ]
                System.out.println("CASE 2");
                /* Build [σ] */
                Tree<String> instChild = new Tree<String>(inst, null, inputTree.getRight().getRight());

                /* Build t[σ] */
                Tree<String> leftChild = new Tree<String>(app, inputTree.getLeft().getLeft(), instChild);

                /* Build t'[σ] */
                Tree<String> rightChild = new Tree<String>(app, inputTree.getLeft().getRight(), instChild);

                /* Build (t[σ])(t'[σ]) */
                result = new Tree<String>(app, leftChild, rightChild);
                System.out.println("Right");
                TreePrinter.printNode(rightChild);
            } else if (inputTree.getLeft().getData().equals(lambda)) {                                                // case 3: (λ.t)[σ]
                System.out.println("CASE 3");
                /* Build [⇑σ] */
                Tree<String> instChild = new Tree<String>(inst, null, new Tree<String>(shiftSub, null, inputTree.getRight().getRight()));

                /* Build t[⇑σ] */
                Tree<String> appChild = new Tree<String>(app, inputTree.getLeft().getRight(), instChild);

                /* Build λ.(t[⇑σ]) */
                lambdaTreeList.add(new Tree<String>(lambda, null, null)); // put λ to list
                result = appChild;  // return t[⇑σ]
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
     * Execute the Autosubst substitution for a given DeBruijn Tree
     * Return calculated DeBruijn Tree
     **/
    public Tree<String> calculateSubstTree(Tree<String> deBruijnTree) {
        Tree<String> inputTree = deBruijnTree;
        Tree<String> resultTree = null;
        try {
            while (!inputTree.getData().matches("[0-9]+")) {
                String data = inputTree.getData();
                if (data.equals(lambda)) {                                      // start with "λ"
                    Tree<String> tree = new Tree<String>(lambda, null, null);
                    lambdaTreeList.add(tree);   // put "λ" to the list
                    inputTree = inputTree.getRight();
                } else if (data.equals(app)) {
                    if (inputTree.getRight().getData().equals(inst)) {          // Instantiation
                        System.out.println("Instant");
                        inputTree = instantiation(inputTree);
                    } else if (inputTree.getLeft().getData().equals(lambda)) {  // Beta-reduction
                        System.out.println("Beta Reduc");
                        inputTree = betaReduction(inputTree);
                    } else {
                        lambdaTreeList.add(new Tree<String>(app, null, null));
                        calculateSubstTree(inputTree.getLeft());
                        calculateSubstTree(inputTree.getRight());
                    }
                }
                //TreePrinter.printNode(inputTree);
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
        DeBruijnLambda deBruijnLambda = null;
        try {
            Tree<String> inputTree = inputLambda.getLambdaTree();
            calculateSubstTree(inputTree);
            for (Tree<String> x : lambdaTreeList)
                TreePrinter.printNode(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deBruijnLambda;
    }
}
