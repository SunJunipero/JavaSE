package ThreadFactory;

public class TFDemo {
    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();

        myFactory.newThread(()->{
            System.out.println("one thread");
            System.out.println(Thread.currentThread().getName());
        }).start();

        myFactory.newThread(()->{
            System.out.println("other thread");
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
