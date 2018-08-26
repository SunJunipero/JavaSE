package Synchronized.caller;

import java.util.Random;

public class Callme {
    public void call(String message){
        System.out.print(" [ " + message);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(" ] ");
    }

    public void simpleMethod(){
        System.out.println(new Random().nextInt(100));
    }

}
