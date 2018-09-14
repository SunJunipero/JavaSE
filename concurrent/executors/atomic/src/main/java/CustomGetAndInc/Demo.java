package CustomGetAndInc;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    static int getAndInc(AtomicInteger i){
        int cur;
        do {
            cur = i.get();
        }while (!i.compareAndSet(cur,cur + 1));
            return cur;
    }

    static int getAndDouble(AtomicInteger i){
        int cur;
        do {
            cur = i.get();
        }while (!i.compareAndSet(cur,cur * 2));
        return cur;
    }

    static int incAndGet(AtomicInteger i){
        return getAndInc(i) + 1;
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println("\t\t get and increment");
        System.out.println(getAndInc(atomicInteger));
        System.out.println(atomicInteger.get());

        System.out.println("\t\t increment and get");
        System.out.println(incAndGet(atomicInteger));
        System.out.println(atomicInteger.get());

        System.out.println("\t\t get and double");
        System.out.println(getAndDouble(atomicInteger));
        System.out.println(atomicInteger.get());


        /**
         * since 1.8
         */
        System.out.println("\t\t get and update");
        System.out.println(atomicInteger.getAndUpdate(val -> val + 10));
        System.out.println(atomicInteger.get());


        System.out.println("\t\t get and accumulate");
        int accum = 10;
        System.out.println(atomicInteger.getAndAccumulate(accum, (x, y) -> x * y));
        System.out.println(atomicInteger.get());
        System.out.println("accum = " + accum);



    }
}
