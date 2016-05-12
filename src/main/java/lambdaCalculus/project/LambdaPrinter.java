package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnLexer;
import lambdaCalculus.project.grammar.deBruijnLambda.DeBruijnParser;
import lambdaCalculus.project.grammar.standardLambda.LambdaLexer;
import lambdaCalculus.project.grammar.standardLambda.LambdaParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Created by Daniel Dao on 4/16/16.
 */
public class LambdaPrinter {

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

    public static void printStandardLambdaTerm(StandardLambda standardLambda) {
        try {
            if (!error) {
                System.out.println("Standard Lambda TERM: " + standardLambda.getLambdaTerm());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStandardLambdaTree(StandardLambda standardLambda) {
        try {
            if (!error) {
                System.out.println("Standard Lambda TREE:");
                standardLambda.getLambdaTree().printTree();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnTerm(DeBruijnLambda deBruijnLambda) {
        try {
            if (!error) {
                System.out.println("DeBruijn TERM: " + deBruijnLambda.getLambdaTerm());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnTree(DeBruijnLambda deBruijnLambda) {
        try {
            if (!error) {
                System.out.println("DeBruijn TREE:");
                deBruijnLambda.getLambdaTree().printTree();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLambdaAutosubstTerm(StandardLambda standardLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst Lambda TERM: " + standardLambda.getLambdaTerm());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLambdaAutosubstTree(StandardLambda standardLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst Lambda TREE:");
                standardLambda.getLambdaTree().printTree();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnAutosubstTerm(DeBruijnLambda deBruijnLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst DeBruijn TERM: " + deBruijnLambda.getLambdaTerm());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnAutosubstTree(DeBruijnLambda deBruijnLambda) {
        try {
            if (!error) {
                System.out.println("Autosubst DeBruijn TREE:");
                deBruijnLambda.getLambdaTree().printTree();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDeBruijnFullReductionSteps(Autosubst autosubst) {
        try {
            System.out.println("Reduction steps in De Bruijn representation:");
            System.out.println(autosubst.getDeBruijnFullReduction());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStandardLambdaFullReductionSteps(Autosubst autosubst) {
        try {
            System.out.println("Reduction steps in Standard Lambda representation:");
            System.out.println(autosubst.getLambdaFullReduction());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
