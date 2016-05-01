package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnLexer;
import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnParser;
import lambdaCalculus.project.grammar.standardLambda.LambdaLexer;
import lambdaCalculus.project.grammar.standardLambda.LambdaParser;

import lambdaCalculus.project.tree.TreePrinter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Created by Daniel Dao on 4/16/16.
 */
public class TermRunner {

    private static boolean error;

    protected static void setError(boolean b) {
        error = b;
    }

    public static StandardLambda setupLambda(String input) {
        StandardLambda listener = new StandardLambda();
        try {
            LambdaLexer lexer = new LambdaLexer(new ANTLRInputStream(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LambdaParser parser = new LambdaParser(tokens);
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    error = true;
                    throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
                }
            });
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
            if (!error) {
                System.out.println("Standard Lambda TERM: " + standardLambda.getLambdaTerm());
                System.out.println("Standard Lambda TREE:");
                TreePrinter.printNode(standardLambda.getLambdaTree());
                System.out.println();
            }
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
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    error = true;
                    throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
                }
            });
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
            if (!error) {
                System.out.println("DeBruijn TERM: " + deBruijnLambda.getLambdaTerm());
                System.out.println("DeBruijn TREE:");
                TreePrinter.printNode(deBruijnLambda.getLambdaTree());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLambdaAutosubst(StandardLambda standardLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst Lambda TERM: " + standardLambda.getLambdaTerm());
                System.out.println("Autosubst Lambda TREE:");
                TreePrinter.printNode(standardLambda.getLambdaTree());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnAutosubst(DeBruijnLambda deBruijnLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst DeBruijn TERM: " + deBruijnLambda.getLambdaTerm());
                System.out.println("Autosubst DeBruijn TREE:");
                TreePrinter.printNode(deBruijnLambda.getLambdaTree());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setError(false);
        try {
            if (args.length == 2) {
                if (args[0].equals("lambda")) {
                    StandardLambda standardLambda = setupLambda(args[1]);
                    printLambda(standardLambda);
                    DeBruijnLambda deBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
                    printDeBruijn(deBruijnLambda);
                } else if (args[0].equals("debruijn")) {
                    DeBruijnLambda deBruijnLambda = setupDeBruijn(args[1]);
                    printDeBruijn(deBruijnLambda);
                    StandardLambda standardLambda = TermConverter.deBruijnToStandardLambda(deBruijnLambda);
                    printLambda(standardLambda);
                } else {
                    throw new Exception("Given argument is not correct! Please try again!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
