package throwNull;

/**
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class Demo {
    public static void main(String[] args) {
        f(null);
    }

    private static void f(NullPointerException e) {
        try {
            throw e;
        }
        catch (NullPointerException npe){
            f(npe);
        }
    }
}
