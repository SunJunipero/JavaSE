package JMM.singleton.doublechekedLockingSingleton;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        HashSet<Integer> codes = new HashSet<>();
        HashSet<Integer> vals = new HashSet<>();
        List<MyThread> collect = Stream.generate(MyThread::new)
                .limit(1_000)
                .peek(MyThread::run)
                .collect(Collectors.toList());

        for (MyThread myThread : collect) {
            codes.add(myThread.gethCode());
            vals.add(myThread.getVal());
        }

        System.out.println("\t\tCODES");
        System.out.println(codes);
        System.out.println("\t\tVALS");
        System.out.println(vals);


    }
}
