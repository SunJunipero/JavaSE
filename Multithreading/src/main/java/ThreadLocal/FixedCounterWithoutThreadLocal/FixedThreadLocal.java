package ThreadLocal.FixedCounterWithoutThreadLocal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixedThreadLocal {
    public static class Builder{

        HashMap<String, Integer> map = new HashMap<>();

        public void build(){
            System.out.println(Thread.currentThread().getName() + " something build" );

            if(!map.containsKey(Thread.currentThread().getName()))
                map.put(Thread.currentThread().getName(), 0);
            map.put(Thread.currentThread().getName(), map.get(Thread.currentThread().getName()) + 1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return map.get(Thread.currentThread().getName());
        }
    }

    public static class MyThread extends Thread{
        Builder builder;

        public MyThread(Builder builder) {
            this.builder = builder;
        }

        @Override
        public void run() {
            for (int i = 0; i < Math.random() * 10; i++) {
                builder.build();
            }
            System.out.println("I'm " + getName() + " and built  " + builder.getCount() + " things" );
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * s1 - 2
         * s2 - 4
         * s3 - 5
         */
       // List<String> strings = Arrays.asList("s1", "s2", "s3", "s3", "s2", "s1", "s2", "s3","s4", "s3", "s2", "s3");

       // Map<String, Integer> map1 = strings.stream().collect(Collectors.toMap(str -> str, str -> 1, (integer, integer2) -> integer +1));

        Builder builder = new Builder();
        MyThread myThread = new MyThread(builder);
        MyThread myThread2 = new MyThread(builder);

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println("finished");


    }
}
