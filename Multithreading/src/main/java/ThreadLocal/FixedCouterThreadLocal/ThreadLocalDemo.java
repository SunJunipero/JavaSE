package ThreadLocal.FixedCouterThreadLocal;

public class ThreadLocalDemo {
    public static class Builder{
        ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        public void build(){
            System.out.println(Thread.currentThread().getName() + " something build" );
//
//            if (count.get() == null)
//                count.set(0);
            count.set(count.get() + 1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public int getCount(){
            return count.get();
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
        Builder builder = new Builder();

        MyThread myThread1 = new MyThread(builder);
        MyThread myThread2 = new MyThread(builder);

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println("Finished");
    }

}
