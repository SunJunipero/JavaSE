package JMM.totalOrderSynchronized;

public class Data {
    int x;

    public void modifyX(){
        synchronized (this){
        for (int i = 0; i < 10; i++) {
            x++;
            System.out.println("after for x = " + x + " " + Thread.currentThread().getName());
            synchronized (this){
                x += 20;
                System.out.println("after change x = " + x + " " + Thread.currentThread().getName());
            }
        }
    }
    }
}
