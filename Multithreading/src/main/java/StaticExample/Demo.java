package StaticExample;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client(10);
        Client client1 = new Client(30);

        client.start();
        client1.start();

        client.join();
        client1.join();

        System.out.println(Resorce.sum);
    }
}
