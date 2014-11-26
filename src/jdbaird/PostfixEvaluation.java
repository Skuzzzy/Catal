package jdbaird;

import jdbaird.tokens.Token;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Daniel on 11/25/2014.
 */
public class PostfixEvaluation {

    Stack<Token> evaluationStack;
    ArrayList<Token> postfixExpression;

    public PostfixEvaluation(ArrayList<Token> postfixExpression){
        evaluationStack = new Stack<Token>();
        this.postfixExpression = postfixExpression;
    }
}
