package jdbaird.tokens.coreTokens;

import jdbaird.tokens.Token;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        String result = (new BigDecimal(arguments[1]).divide(new BigDecimal(arguments[0]),20,RoundingMode.HALF_UP)).toString();
        return result;
    }
}
