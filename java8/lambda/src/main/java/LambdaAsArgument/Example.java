package LambdaAsArgument;

public class Example {
    static String strOp(FuncInt<String> operation, String str){
        return (operation.sam(str));
    }

    public static void main(String[] args) {
        FuncInt<String> toUpper = String::toUpperCase;
        FuncInt<String> toLower= String::toLowerCase;

        System.out.println(strOp(toLower, "OLOOLO"));
        System.out.println(strOp(toUpper, "kekke !!!!"));
    }
}
