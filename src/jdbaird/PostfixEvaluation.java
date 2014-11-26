package jdbaird;

import jdbaird.tokens.Token;
import jdbaird.tokens.coreTokens.NumberToken;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Daniel on 11/25/2014.
 */
public class PostfixEvaluation {

    Stack<Token> evaluationStack;
    ArrayList<Token> postfixExpression;
    String result;

    public PostfixEvaluation(ArrayList<Token> postfixExpression){
        evaluationStack = new Stack<Token>();
        this.postfixExpression = postfixExpression;
        String result = "";

        evaluatePostfix();
    }

    public String getResult(){
        return result;
    }

    public void evaluatePostfix(){
        String[] arguments;
        for(int i=0;i<postfixExpression.size();i++){
            arguments = new String[postfixExpression.get(i).getEvaluationStackConsumption()];
            for(int j=0;j<arguments.length;j++){
                arguments[j] = evaluationStack.pop().evaluate(new String[0]);
            }
            evaluationStack.add(new NumberToken(postfixExpression.get(i).evaluate(arguments)));
        }
        result = evaluationStack.pop().evaluate(new String[0]);
    }
}
