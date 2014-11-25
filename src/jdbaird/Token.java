package jdbaird;

/**
 * Created by Daniel on 11/24/2014.
 */
public class Token {

    private String value;
    private int type;

    public Token(String tokenString,int tokenType){
        this.value = tokenString;
        this.type = tokenType;
    }

    public String getValue(){
        return value;
    }

    public int getType(){
        return type;
    }

}
