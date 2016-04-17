package lambdaCalculus;


import lambdaCalculus.Tree.TreePrinter;

/**
 * Created by Daniel Dao on 4/16/16.
 */
public class Runner {

    public static void print(String input) {
        LambdaDef lambdaDef = new LambdaDef(input);
        String term = lambdaDef.getLambdaTerm();
        System.out.println("Tree for " + term + " :");
        TreePrinter.printNode(lambdaDef.getLambdaTree());
    }

    public static void main(String[] args) {
        String input1 = "(\\x.\\y.(x y) z)";
        String input2 = "\\x.\\y.x y z";
        String input3 = "x";

        print(input1);
        print(input2);
        //print(input3);

    }
}
