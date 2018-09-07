package CycleReetrantLock;

public class Demo {
    public static void main(String[] args) {
        Work work = new Work();
        new DecThread(work);
        new IncThread(work);
    }
}
