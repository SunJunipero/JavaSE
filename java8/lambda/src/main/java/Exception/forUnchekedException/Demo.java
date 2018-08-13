package Exception.forUnchekedException;

public class Demo {
    public static void main(String[] args) {
        FuncInt up = str -> {
            if (str.length() == 0) {
                throw new EmptyStringException();
            }
            return str.toUpperCase();
        };

        System.out.println(up.sam("correct string"));
        System.out.println(up.sam(""));

    }
}
