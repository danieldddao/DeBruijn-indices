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
 * Test the translation from De Bruijn terms to standard lambda terms
 */
public class AutosubstDeBruijnTest {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/lambdaCalculus/project/autosubstDeBruijnInput"));
            String line = br.readLine();
            List<String> list = new ArrayList<String>();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
            for (String term : list) {
                LambdaPrinter.setError(false);
                DeBruijnLambda deBruijnLambda = LambdaPrinter.setupDeBruijn(term);
                LambdaPrinter.printDeBruijnTerm(deBruijnLambda);
                StandardLambda standardLambda = TermConverter.deBruijnToStandardLambda(deBruijnLambda);
                LambdaPrinter.printStandardLambdaTerm(standardLambda);

                Autosubst autosubst = new Autosubst(deBruijnLambda);
                LambdaPrinter.printLambdaAutosubstTerm(autosubst.getStandardLambda());
                //LambdaPrinter.printLambdaAutosubstTree(autosubst.getStandardLambda());
                LambdaPrinter.printStandardLambdaFullReductionSteps(autosubst);

                LambdaPrinter.printDeBruijnAutosubstTerm(autosubst.getDeBruijnLambda());
                //LambdaPrinter.printLambdaAutosubstTree(autosubst.getDeBruijnLambda());
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
