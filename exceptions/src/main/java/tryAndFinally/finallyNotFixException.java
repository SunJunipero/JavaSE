package tryAndFinally;

/**
 *  TRY
 *  FINALLY
 * Exception in thread "main" java.lang.RuntimeException
 * 	at tryAndFinally.finallyNotFixException.main(finallyNotFixException.java:8)
 */
public class finallyNotFixException {
    public static void main(String[] args) {
        try {
            System.out.println(" TRY ");
            if (true)
                throw new RuntimeException();
        }
        finally {
            System.out.println(" FINALLY ");
        }
        System.out.println(" NEXT ");

    }
}
