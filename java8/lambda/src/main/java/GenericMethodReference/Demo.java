package GenericMethodReference;

public class Demo {
    static<T> int countSameObject(FuncInt<T> f, T vals[], T v){
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 4, 4, 5 , 6 ,7, 4 };
        System.out.println(countSameObject(CounterClass::<Integer>countVals, integers, 4));

        /**
         * тип указывать не обхательно
         */

        System.out.println(countSameObject(CounterClass::countVals, integers, 4));


        String[] strings = {"ol", "ok","op" , "ok" , "ok"};

        System.out.println(countSameObject(CounterClass::<String>countVals, strings, "ok"));
    }
}
