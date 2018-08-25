package JoinIsAlive;

public class MyThread implements Runnable {
    String name;
    Thread thread;

    MyThread(String name){
        this.name = name;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
            try {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("from - " + thread.getName());
                    System.out.println("i - " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(thread.getName() + "stopped");
        }
    }

