package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 4/23/16.
 *
 * Demo for presentation
 */
public class DemoTest {
    public static void main(String[] args) {
        try {
            System.out.println();
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/lambdaCalculus/project/demoInput"));
            String line = br.readLine();
            List<String> list = new ArrayList<String>();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
            if (list.size() == 3) {
                if (list.get(0).equals("lambda")) {
                    LambdaPrinter.setError(false);
                    StandardLambda standardLambda = LambdaPrinter.setupLambda(list.get(2));
                    LambdaPrinter.printStandardLambdaTerm(standardLambda);
                    LambdaPrinter.printStandardLambdaTree(standardLambda);

                    DeBruijnLambda deBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
                    LambdaPrinter.printDeBruijnTerm(deBruijnLambda);
                    LambdaPrinter.printDeBruijnTree(deBruijnLambda);
                } else if (list.get(0).equals("debruijn")) {
                    LambdaPrinter.setError(false);
                    DeBruijnLambda deBruijnLambda = LambdaPrinter.setupDeBruijn(list.get(2));
                    LambdaPrinter.printDeBruijnTerm(deBruijnLambda);
                    LambdaPrinter.printDeBruijnTree(deBruijnLambda);

                    StandardLambda standardLambda = TermConverter.deBruijnToStandardLambda(deBruijnLambda);
                    LambdaPrinter.printStandardLambdaTerm(standardLambda);
                    LambdaPrinter.printStandardLambdaTree(standardLambda);
                }
            } else {
                System.out.println("Please enter correct input!\n first line = lambda or debruijn, second line = term");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
