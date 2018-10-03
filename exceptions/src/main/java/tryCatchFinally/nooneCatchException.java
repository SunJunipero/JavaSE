package tryCatchFinally;

/**
 * Exception in thread "main"  #0
 *  #1
 *  #4
 *  #7
 * java.lang.RuntimeException
 * 	at tryCatchFinally.nooneCatchException.main(nooneCatchException.java:10)
 */
public class nooneCatchException {
    public static void main(String[] args) {
        try {
            System.out.println(" #0 ");
            try {
                System.out.println( " #1 ");
                if (true)
                    throw new RuntimeException();
                System.out.println( " #2 ");
            }
            catch (Error e){
                System.out.println( " #3");
            }
            finally {
                System.out.println( " #4");
            }
            System.out.println(" #5");

        }
        catch (Error e){
            System.out.println( " #6");
        }
        finally {
            System.out.println( " #7");
        }
        System.out.println(" #8");
    }
}
