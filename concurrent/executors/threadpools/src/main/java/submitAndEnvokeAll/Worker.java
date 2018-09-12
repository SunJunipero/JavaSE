package submitAndEnvokeAll;

import java.util.concurrent.Callable;

public class Worker implements Callable<String> {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        long l = (long)(Math.random() * 1000L);
        System.out.println(name + " started, going to sleep  " + l);
        Thread.sleep(l);
        System.out.println(name + " finished");
        return name;
    }
}
