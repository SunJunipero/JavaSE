package InstanceMethodReference;

public class Example {

    public static String method(funcInt funcInt, String str){
        return funcInt.func(str);
    }

    public static void main(String[] args) {
        StringOp stringOp = new StringOp();

        System.out.println(method(stringOp::reverse, "DOOM"));

        System.out.println(method(stringOp::replaceAllAtoX, "DOOM"));

        System.out.println(method(StringOp::replaceAllAtoX, "OLOLOLOL"));
    }
}
