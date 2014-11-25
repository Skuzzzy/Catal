package jdbaird;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/24/2014.
 */
public class TokenMaker {

    private String expression;
    private ArrayList<Token> tokenList;

    public TokenMaker(String expression){
        this.expression = expression;
    }

    public void createTokens(){ //Assume expression is well formed
        tokenList.clear();
        String tokenString = "";
        int tokenType = -1; //TODO

        for(int i=0;i<expression.length();i++){
            char currentChar = expression.charAt(i);

            if(currentChar == '+' ||currentChar == '-' || currentChar == '(' || currentChar == ')'){
                tokenList.add(new Token(tokenString)); //TODO Add token based on the token Type
                tokenString = "";
            }

            if(IsPartOfNumber(currentChar)){
                tokenString += currentChar;
            }
            if(currentChar == '+'){
                tokenString = "+";
            }
            if(currentChar == '-'){
                tokenString = "-";
            }
            if(currentChar == '('){
                tokenString = "(";
            }
            if(currentChar == ')'){
                tokenString = ")";
            }



        }
    }

    private static boolean IsPartOfNumber(char digit){
        if(Character.isDigit(digit) || digit == '.'){
            return true;
        }else{
            return false;
        }
    }
}
