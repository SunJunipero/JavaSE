package tryAndFinally;

/**
 *  TRY
 *  FINALLY
 */
public class returnAndFinally {
    public static void main(String[] args) {
        try {
            System.out.println(" TRY ");
            if (true)return;
        }
        finally {
            System.out.println(" FINALLY ");
        }
        System.out.println("NEXT");
    }
}
