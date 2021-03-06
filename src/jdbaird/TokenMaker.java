package jdbaird;

import jdbaird.tokens.Token;
import jdbaird.tokens.coreTokens.*;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/24/2014.
 */
public class TokenMaker {

    private String expression;
    private ArrayList<Token> tokenList;

    public TokenMaker(String expression){
        this.expression = expression;
        this.tokenList = new ArrayList<Token>();
        createTokens();
    }

    public ArrayList<Token> getTokenList(){
        return tokenList;
    }

    public void createTokens(){ //Assume expression is well formed
        tokenList.clear();
        String tokenString = "";

        int i = 0;
        while(i<expression.length()){
            char currentChar = expression.charAt(i);

            if(IsPartOfNumber(currentChar)){
                tokenString += currentChar;
                while(tokenString != ""){
                    i++;

                    if(i>= expression.length()){ //If it is the end of the expression
                        tokenList.add(new NumberToken(tokenString));
                        tokenString = "";
                    }else{
                        if(IsPartOfNumber(expression.charAt(i))){
                            currentChar = expression.charAt(i);
                            tokenString += currentChar;
                        }else{
                            tokenList.add(new NumberToken(tokenString));
                            tokenString = "";
                        }
                    }


                }
            }else if(currentChar == '+'){
                tokenList.add(new AdditionToken());
                tokenString = "";
                i++;
            }else if(currentChar == '-'){
                tokenList.add(new SubtractionToken());
                tokenString = "";
                i++;
            }else if(currentChar == '*'){
                tokenList.add(new MultiplicationToken());
                tokenString = "";
                i++;
            }else if(currentChar == '/') {
                tokenList.add(new DivisionToken());
                tokenString = "";
                i++;
            }else if(currentChar == '^'){
                tokenList.add(new ExponentToken());
                tokenString = "";
                i++;
            }else if(currentChar == '('){
                tokenList.add(new LeftParenthesisToken());
                tokenString = "";
                i++;
            }else if(currentChar == ')'){
                tokenString = ")";
                tokenList.add(new RightParenthesisToken());
                tokenString = "";
                i++;
            }else{
                System.out.println("Char not found");
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
