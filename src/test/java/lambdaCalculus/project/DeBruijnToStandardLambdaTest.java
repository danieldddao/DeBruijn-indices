package lambdaCalculus.project;

import lambdaCalculus.project.TermConverter;
import lambdaCalculus.project.TermRunner;
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
public class DeBruijnToStandardLambdaTest {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/lambdaCalculus/project/deBruijnInput"));
            String line = br.readLine();
            List<String> list = new ArrayList<String>();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
            if (list.size() != 0) {
                for (String term : list) {
                    TermRunner.setError(false);
                    DeBruijnLambda deBruijnLambda = TermRunner.setupDeBruijn(term);
                    TermRunner.printDeBruijn(deBruijnLambda);
                    StandardLambda standardLambda = TermConverter.deBruijnToStandardLambda(deBruijnLambda);
                    TermRunner.printLambda(standardLambda);
                }
            } else {
                System.out.println("There's no input term, please enter some input terms");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
