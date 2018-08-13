package MethodReference;

public class MethodReferenceExample {
    static String method(FuncInt funcInt, String str){
        return funcInt.strMethod(str);
    }

    public static void main(String[] args) {
        System.out.println(method(StringReverse::reverse, "Simpsons"));
    }
}
