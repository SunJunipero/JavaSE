package StaticExample;

public class Resorce {

    static int sum = 100;

    public synchronized static void change(int n){
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum++;
        }
    }

}
