package ConstructorReferences;

public class Demo {
    public static void main(String[] args) {
        FuncInt constructor = MyClass::new;

        MyClass myClass = constructor.func(45);


        System.out.println(myClass.getVal());
    }
}
