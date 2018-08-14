package FabricConstructor;

public class Demo {

    public static <R,T> R factory (FuncInt<R,T> f, T val){
        return f.func(val);
    }

    public static void main(String[] args) {
        FuncInt<MyClass, Integer> stringFuncInt = MyClass::new;

        MyClass func = stringFuncInt.func(123);

        System.out.println(func.getVal());

        /**
         * OR
         */

        MyClass factory1 = factory(stringFuncInt, 101);

        System.out.println(factory1.getVal());


        FuncInt<MyGenClass<String>, String> myGenClassIntegerFuncInt = MyGenClass::new;

        MyGenClass<String> lolll = myGenClassIntegerFuncInt.func("lolll");

        System.out.println(lolll.getVal());

        /**
         * OR
         */

        MyGenClass<String> from_factory = factory(myGenClassIntegerFuncInt, "from factory");

        System.out.println(from_factory.getVal());
    }
}
