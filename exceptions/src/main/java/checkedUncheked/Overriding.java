package checkedUncheked;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * overriding exception  < =  root exception
 */

class Parent{
    public void boo() throws IOException, InterruptedException {

    }
}

class Child extends Parent{
    public void boo() throws FileNotFoundException {

    }
}
public class Overriding {
}
