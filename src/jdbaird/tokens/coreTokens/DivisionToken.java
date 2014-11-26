package jdbaird.tokens.coreTokens;

import jdbaird.tokens.Token;

import java.math.BigDecimal;

/**
 * Created by Daniel on 11/25/2014.
 */
public class DivisionToken implements Token {
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
        return "/";
    }

    @Override
    public String evaluate(String[] arguments) {
        String result = (new BigDecimal(arguments[0]).divide(new BigDecimal(arguments[1]))).toString();
        return result;
    }
}
