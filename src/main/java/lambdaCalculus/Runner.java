package lambdaCalculus;
import lambdaCalculus.Tree.TreePrinter;
import lambdaCalculus.grammar.LambdaLexer;
import lambdaCalculus.grammar.LambdaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

/**
 * Created by Daniel Dao on 4/16/16.
 */
public class Runner {

    public static LambdaDef setupLambda(String input) {
        LambdaDef listener = new LambdaDef();
        try {
            LambdaLexer lexer = new LambdaLexer(new ANTLRInputStream(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LambdaParser parser = new LambdaParser(tokens);
            parser.setBuildParseTree(true);
            LambdaParser.LambdaTermContext tree = parser.lambdaTerm();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listener;
    }

    public static void printLambda(LambdaDef lambdaDef) {
        try {
            System.out.println("TERM: " + lambdaDef.getLambdaTerm());
            System.out.println();
            System.out.println("TREE:");
            TreePrinter.printNode(lambdaDef.getLambdaTree());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String input = "(\\x.\\y.x (y z))";
        String input3 = "(\\x.\\y.x ((\\y.x) z)";
        String input1 = "x y z";

        LambdaDef lambdaDef = setupLambda(input);
        printLambda(lambdaDef);
    }
}
