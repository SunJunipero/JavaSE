package EffectivelyFinal;

import java.util.Random;
import java.util.function.BinaryOperator;

public class Example {

    private Integer val = 100;
    public static void main(String[] args) {

        String outerString = "from out world";

        FuncInterface<String> addEnding = str -> {
            Random random = new Random();
            //return str + "  " + String.valueOf(random.nextInt(1000));
            //Compile exception
            //outerString = "sdss";
            return str + "  " + outerString;
        };

        String example = "ArcticMonkeys";

        /**
         * for variable of instance of class
         */

        FuncInterface<Integer> simpleAdd = val -> {
            return new Example().val += val;
        };

        System.out.println(simpleAdd.apply(23));


        System.out.println(addEnding.apply(example));
        BinaryOperator <Integer> add = (x, y) -> x + y;

        System.out.println(add.apply(222, 4444));




    }
}
