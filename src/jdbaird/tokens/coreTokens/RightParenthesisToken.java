package jdbaird.tokens.coreTokens;

import jdbaird.tokens.Token;

/**
 * Created by Daniel on 11/25/2014.
 */
public class RightParenthesisToken implements Token{
    @Override
    public int evaluationStackConsumption() {
        return 0;
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getContents(){
        return ")";
    }

    @Override
    public String evaluate(String[] arguments) {
        return "";
    }
}
