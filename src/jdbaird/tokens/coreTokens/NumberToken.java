package jdbaird.tokens.coreTokens;

import jdbaird.tokens.Token;

/**
 * Created by Daniel on 11/25/2014.
 */
public class NumberToken implements Token {

    double value;

    public NumberToken(double value){
        this.value = value;
    }

    @Override
    public int evaluationStackConsumption() {
        return 0;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getContents(){
        return evaluate(new String[0]);
    }

    @Override
    public String evaluate(String[] arguments) {
        return "" + value;
    }
}
