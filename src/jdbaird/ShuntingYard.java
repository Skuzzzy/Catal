package jdbaird;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Daniel on 11/24/2014.
 * This class implements the Shunting-yard Algorithm on a list of tokens supplied by TokenMaker.java
 * http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */

public class ShuntingYard {

    private ArrayList<Token> tokenArrayList;

    private Stack<Token> operators = new Stack();
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
                        boolean operatorNotPlaced = true;
                        while(operatorNotPlaced) { //While the operator hasn't been added to the stack
                            if(!operators.isEmpty()){
                                //Check PEMDAS against top of stack
                                if (firstOperatorHasPrecedence(tokenArrayList.get(i), operators.peek())) {
                                    //If current is higher priority than the one on the stack just put the current on the stack
                                    operators.add(tokenArrayList.get(i));
                                } else {
                                    //If not, pop the top of the stack, append it to the outputList, then again try to attach the current on the stack
                                    outputList.add(operators.pop());

                                }
                            }else{
                                operators.add(tokenArrayList.get(i));
                            }
                        }
                    break;
                case 2: //Is (
                    operators.add(tokenArrayList.get(i));
                    break;
                case 3: //Is )
                    boolean parenthesisIsNotFound = true;
                    while(parenthesisIsNotFound){
                        Token popOperator = operators.pop();
                        if(popOperator.getValue() != "("){
                            outputList.add(operators.pop());
                        }else{
                            parenthesisIsNotFound = false;
                        }
                    }
                    break;
                default: //Something went horrendously wrong :(
                    System.out.println("No such type found for "+i+" Type "+tokenArrayList.get(i).getType());
            }


        }
    }

    private static boolean firstOperatorHasPrecedence(Token first, Token second){ //TODO Fix this, it's currently a quick hack (ONLY SUPPORTS "+-/*")
        //TODO WARNING Possible Parenthesis Error?
        if(first.getValue() == "/" || first.getValue() == "*"){
            if(second.getValue() == "/" || second.getValue() == "*"){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

}
