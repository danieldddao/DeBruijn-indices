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
                    TermRunner.setError(false);
                    StandardLambda standardLambda = TermRunner.setupLambda(list.get(2));
                    TermRunner.printLambda(standardLambda);
                    DeBruijnLambda deBruijnLambda = TermConverter.standardLambdaToDeBruijn(standardLambda);
                    TermRunner.printDeBruijn(deBruijnLambda);
                } else if (list.get(0).equals("debruijn")) {
                    TermRunner.setError(false);
                    DeBruijnLambda deBruijnLambda = TermRunner.setupDeBruijn(list.get(2));
                    TermRunner.printDeBruijn(deBruijnLambda);
                    StandardLambda standardLambda = TermConverter.deBruijnToStandardLambda(deBruijnLambda);
                    TermRunner.printLambda(standardLambda);
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