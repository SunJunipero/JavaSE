package ThreadLocal;

public class BrokenCounter {
    public static class Builder{
        private int count;

        public void build(){
            System.out.println(Thread.currentThread().getName() + " something build" );

            count++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public int getCount(){
            return count;
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
