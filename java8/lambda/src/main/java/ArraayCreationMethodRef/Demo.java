package ArraayCreationMethodRef;

public class Demo {
    public static void main(String[] args) {

        FuncInt<MyClass[], Integer> funcInt = MyClass[]::new;

        MyClass[] func = funcInt.func(12);

        /**
         * length = 12
         */
        System.out.println(func.length);
    }
}
