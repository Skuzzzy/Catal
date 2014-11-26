package jdbaird.tokens.coreTokens;

import jdbaird.tokens.Token;

/**
 * Created by Daniel on 11/25/2014.
 */
public class ExponentToken implements Token {
    @Override
    public int getEvaluationStackConsumption() {
        return 2;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public String getContents(){
        return "^";
    }

    @Override
    public String evaluate(String[] arguments) {
        String result = "" + (Math.pow(Double.parseDouble(arguments[0]),Double.parseDouble(arguments[1])));
        return result;
    }
}
