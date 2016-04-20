package lambdaCalculus;
import lambdaCalculus.grammar.deBruijnLambda.DeBruijnLexer;
import lambdaCalculus.grammar.deBruijnLambda.DeBruijnParser;
import lambdaCalculus.grammar.standardLambda.LambdaLexer;
import lambdaCalculus.grammar.standardLambda.LambdaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

/**
 * Created by Daniel Dao on 4/16/16.
 */
public class TermRunner {

    public static StandardLambda setupLambda(String input) {
        StandardLambda listener = new StandardLambda();
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

    public static void printLambda(StandardLambda standardLambda) {
        try {
            System.out.println("Standard Lambda TERM: " + standardLambda.getLambdaTerm());
            System.out.println("Standard Lambda TREE:");
            TreePrinter.printNode(standardLambda.getLambdaTree());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DeBruijnLambda setupDeBruijn(String input) {
        DeBruijnLambda listener = new DeBruijnLambda();
        try {
            DeBruijnLexer lexer = new DeBruijnLexer(new ANTLRInputStream(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DeBruijnParser parser = new DeBruijnParser(tokens);
            parser.setBuildParseTree(true);
            DeBruijnParser.LambdaTermContext tree = parser.lambdaTerm();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listener;
    }

    public static void printDeBruijn(DeBruijnLambda deBruijnLambda) {
        try {
            System.out.println("DeBruijn TERM: " + deBruijnLambda.getLambdaTerm());
            System.out.println("DeBruijn TREE:");
            TreePrinter.printNode(deBruijnLambda.getLambdaTree());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String input = "(\\x.\\y.y x (\\z.z))";
        String input3 = "(\\x.\\y.x ((\\y.x) z)";
        String input2 = "x y z";

//        StandardLambda standardLambda = setupLambda(input);
//        printLambda(standardLambda);
//        DeBruijnLambda deBruijnLambda = TermsConverter.standardLambdaToDeBruijn(standardLambda);
//        printDeBruijn(deBruijnLambda);

        String input1 = "\\.\\.0 1 (\\.3)";
        DeBruijnLambda deBruijnLambda = setupDeBruijn(input1);
        printDeBruijn(deBruijnLambda);
        StandardLambda standardLambda = TermsConverter.deBruijnToStandardLambda(deBruijnLambda);
        printLambda(standardLambda);
    }
}
