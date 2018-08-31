package JMM.singleton.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        HashSet<Integer> integers = new HashSet<>();

        List<MyThread> collect = Stream.generate(MyThread::new).limit(1_000)
                   .peek(MyThread::start)
                   .collect(Collectors.toList());


        for (MyThread myThread : collect) {
            integers.add(myThread.gethCode());
            myThread.join();
        }

        System.out.println(integers);


    }
}
