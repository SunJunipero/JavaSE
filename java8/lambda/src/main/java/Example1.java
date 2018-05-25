import java.util.Comparator;

public class Example1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, it's a old style");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Runnable runnable1 = () -> System.out.println("Hello], from lambda");

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        /**
         * Effectively final
         */

        String effectivelyString  = "effectivelyString";
        FunInterface<String> funInterface = System.out::println;
        funInterface.test(effectivelyString);

        String s1 = "LOLLLL !!!!";
        String s2 = "Kekkkk";

        Comparator<String> stringComparator = Comparator.comparingInt(String::length);

        System.out.println(stringComparator.compare(s1, s2));


    }
}
