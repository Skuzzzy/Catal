package jdbaird;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //3.2+32*(45.12+5)+5/14.7 = 1607.38013605

        TokenMaker test = new TokenMaker("333+(56-32)");

        for(int i = 0; i<test.getTokenList().size();i++){
            System.out.print(test.getTokenList().get(i).getValue()+" "+test.getTokenList().get(i).getType()+" | ");
        }

        ShuntingYard railroad = new ShuntingYard(test.getTokenList());
        railroad.algorithm();

        ArrayList<Token> out = railroad.getOutputList();

        for(int i = 0; i<out.size();i++){
            System.out.print(out.get(i).getValue()+" | ");
        }
        */
    }
}
