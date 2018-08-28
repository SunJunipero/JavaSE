package waitnotify.repeat;

public class Demo {
    public static void main(String[] args) {
        Text message = new Text("secret message");

        new Thread(new Consumer(message), "consumer 1").start();
        new Thread(new Consumer(message), "consumer 2").start();

        new Thread(new Supplier(message), "supplier").start();

        System.out.println("\t\t Started...");

    }
}
