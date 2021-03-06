
package jdbaird;

import jdbaird.tokens.Token;

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
        this.outputList = new ArrayList<Token>();
    }

    public ArrayList<Token> getOutputList(){
        return outputList;
    }

    public void algorithm(){
        for(int i=0;i<tokenArrayList.size();i++){
            switch (tokenArrayList.get(i).getType()){
                case 0: //Is number
                    outputList.add(tokenArrayList.get(i));
                    break;
                case 2: //Is operator
                        boolean operatorNotPlaced = true;
                        while(operatorNotPlaced) { //While the operator hasn't been added to the stack
                            if(!operators.isEmpty()){
                                //Check PEMDAS against top of stack
                                if (firstOperatorHasPrecedence(tokenArrayList.get(i), operators.peek())) {
                                    //If current is higher priority than the one on the stack just put the current on the stack
                                    operators.add(tokenArrayList.get(i));
                                    operatorNotPlaced = false;
                                } else {
                                    //If not, pop the top of the stack, append it to the outputList, then again try to attach the current on the stack
                                    outputList.add(operators.pop());

                                }
                            }else{
                                operators.add(tokenArrayList.get(i));
                                operatorNotPlaced = false;
                            }
                        }
                    break;
                case 3: //Is (
                    operators.add(tokenArrayList.get(i));
                    break;
                case 4: //Is )
                    boolean parenthesisIsNotFound = true;
                    while(parenthesisIsNotFound){
                        Token popOperator = operators.pop();
                        if(popOperator.getType() == 3){ //If LeftParenthesisToken
                            parenthesisIsNotFound = false;
                        }else{
                            outputList.add(popOperator);
                        }
                    }
                    break;
                default: //Something went horrendously wrong :(
                    System.out.println("No such type found for "+i+" Type "+tokenArrayList.get(i).getType());
            }

            /*
            System.out.println();
            for(int a = 0; a<outputList.size();a++){
                System.out.print(outputList.get(a).getContents()+" ");
            }
            */
        }
        //After For Loop
        while(!operators.isEmpty()){
            outputList.add(operators.pop());
        }

    }

    private static boolean firstOperatorHasPrecedence(Token first, Token second){
        int firstN = 0;
        int secondN = 0;

        if(first.getContents() == "^" ){firstN+=3;}
        if(second.getContents() == "^" ){secondN+=3;}

        if(first.getContents() == "/" || first.getContents() == "*"){firstN+=2;}
        if(first.getContents() == "+" || first.getContents() == "-"){firstN++;}

        if(second.getContents() == "/" || second.getContents() == "*"){secondN+=2;}
        if(second.getContents() == "+" || second.getContents() == "-"){secondN++;}

        if(firstN>secondN){
            return true;
        }else{
            return false;
        }
    }

}
