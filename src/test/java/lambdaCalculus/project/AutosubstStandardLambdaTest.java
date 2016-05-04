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
 * Test the translation from standard lambda terms to De Bruijn terms
 */
public class AutosubstStandardLambdaTest {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/lambdaCalculus/project/autosubstStandardLambdaInput"));
            String line = br.readLine();
            List<String> list = new ArrayList<String>();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }

            for (String term : list) {
                LambdaPrinter.setError(false);
                StandardLambda standardLambda = LambdaPrinter.setupLambda(term);
                LambdaPrinter.printStandardLambdaTerm(standardLambda);  // print out given term

                DeBruijnLambda deBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
                LambdaPrinter.printDeBruijnTerm(deBruijnLambda);        // print out converted term

                /* AutoSubst */
                Autosubst autosubst = new Autosubst(standardLambda);
                LambdaPrinter.printLambdaAutosubstTerm(autosubst.getStandardLambda());
                LambdaPrinter.printStandardLambdaFullReductionSteps(autosubst);

                LambdaPrinter.printDeBruijnAutosubstTerm(autosubst.getDeBruijnLambda());
                LambdaPrinter.printDeBruijnFullReductionSteps(autosubst);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
