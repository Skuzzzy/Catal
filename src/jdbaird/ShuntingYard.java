package jdbaird;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Daniel on 11/24/2014.
 * This class implements the Shunting-yard Algorithm on a list of tokens supplied by TokenMaker.java
 */

public class ShuntingYard {

    private ArrayList<Token> tokenArrayList;

    private Stack operators = new Stack();
    private ArrayList<Token> outputList;

    public ShuntingYard(ArrayList<Token> tokenArrayList){
        this.tokenArrayList = tokenArrayList;
    }

}
