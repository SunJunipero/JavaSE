package readwritelock;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(12, 45, 76, 33, 1, 19, 38);

        ReadWriterList<Integer> list = new ReadWriterList<>(integers);


        for (int i = 0; i < 2; i++) {
            new Writer(list).start();
        }

        for (int i = 0; i < 10; i++) {
            new Reader(list).start();

        }

    }
}
