package tryAndFinally;

/**
 *  TRY
 *  EXCEPTION
 *  FINALLY
 *  NEXT
 */
public class ExceptinoInTry {
    public static void main(String[] args) {
        try {
            System.out.println(" TRY");
            throw new Exception();
        }
        catch (Exception e){
            System.out.println(" EXCEPTION ");
        }
        finally {
            System.out.println(" FINALLY ");
        }
        System.out.println(" NEXT ");
    }
}
