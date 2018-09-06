package ExecuteExample;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        Runnable task = ()-> {
            System.out.println(Thread.currentThread().getName());
            IntStream.range(1, 20)
                    .boxed()
                    .forEach(System.out::println);
        };

        new MyTask().execute(task);
    }
}
