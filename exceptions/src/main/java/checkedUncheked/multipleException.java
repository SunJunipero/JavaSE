package checkedUncheked;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  + public static void main(String[] args) throws EOFException, FileNotFoundException
 *  + public static void main(String[] args) throws IOException
 *
 */
public class multipleException {
    public static void main(String[] args) throws IOException {
        boo();
        woo();
    }

    private static void woo() throws EOFException{

    }

    private static void boo() throws FileNotFoundException {
    }
}
