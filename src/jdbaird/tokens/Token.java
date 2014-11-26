package jdbaird.tokens;

/**
 * Created by Daniel on 11/25/2014.
 */
public interface Token {

    public int getType();
    //0 Reserved for numbers
    //1 Special type reserved for special functions
    //2 Reserved for ExponentToken MultiplicationToken DivisionToken AdditionToken SubtractionToken
    //3 Reserved for LeftParenthesisToken
    //4 Reserved for RightParenthesisToken
    //5 Possibly reserved for function argument separation

    public String getContents();

    public int evaluationStackConsumption();
    public String evaluate(String[] arguments);

}

