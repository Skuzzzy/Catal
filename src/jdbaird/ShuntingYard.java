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

    public void algorithm(){
        for(int i=0;i<tokenArrayList.size();i++){
            switch (tokenArrayList.get(i).getType()){
                case 0: //Is number
                    break;
                case 1: //Is operator
                    break;
                case 2: //Is (
                    break;
                case 3: //Is )
                    break;
                default: //Something went horrendously wrong :(
                    System.out.println("No such type found for "+i+" Type "+tokenArrayList.get(i).getType());
            }


        }
    }

}
