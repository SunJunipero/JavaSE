package GenrericSAM;

import java.beans.IntrospectionException;

public class Example {

    public static void main(String[] args) {
        FuncInt<String> reverse = str ->{
            String res = "";

            for (int i = str.length()-1; i >=0 ; i--) {
                res += str.charAt(i);
            }
            return res;
        };

        FuncInt<Integer> fact = val -> {
            Integer res = 1;
            for (Integer i = 1; i <= val; i++) {
                res *=i;
            }
            return res;
        };

        System.out.println("\t\t String reverse");
        System.out.println(reverse.func("one point perspective"));

        System.out.println("\t\t Factorial");
        System.out.println(fact.func(5));

    }


}
