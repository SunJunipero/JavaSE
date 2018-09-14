package fromBrokenToCorrectDoer;

import java.util.concurrent.atomic.AtomicBoolean;

public class Test {
    public static void main(String[] args) {
        final AtomicBoolean flag = new AtomicBoolean(false);

        System.out.println(!flag.get());

        if(!flag.get()){
            System.out.println("lol");
        }

        System.out.println(flag.get());

        if(flag.get()){
            System.out.println("lol");
        }



        }
    }
