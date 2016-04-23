package lambdaCalculus.project;

import lambdaCalculus.project.definition.DeBruijnLambda;
import lambdaCalculus.project.definition.StandardLambda;

/**
 * Created by Daniel Dao on 4/21/16.
 */
public class Autosubst {

    private StandardLambda standardLambda;
    private DeBruijnLambda deBruijnLambda;

    /**
     * Autosubst for StandardLambda input
     **/
    public Autosubst (StandardLambda standardLambda) {

    }

    /**
     * Autosubst for DeBruijnLambda input
     **/
    public Autosubst (DeBruijnLambda standardLambda) {

    }

    public StandardLambda getStandardLambda() {
        return standardLambda;
    }

    public void setStandardLambda(StandardLambda standardLambda) {
        this.standardLambda = standardLambda;
    }

    public DeBruijnLambda getDeBruijnLambda() {
        return deBruijnLambda;
    }

    public void setDeBruijnLambda(DeBruijnLambda deBruijnLambda) {
        this.deBruijnLambda = deBruijnLambda;
    }


}
