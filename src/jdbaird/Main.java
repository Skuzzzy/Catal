package jdbaird;

public class Main {

    public static void main(String[] args) {
        //3.2+32*(45.12+5)+5/14.7 = 1607.38013605
        TokenMaker test = new TokenMaker("3.2+32*45.12+5/14.7");
        ShuntingYard railroad = new ShuntingYard(test.getTokenList());

    }
}
