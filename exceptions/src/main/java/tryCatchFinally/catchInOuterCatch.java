package tryCatchFinally;

/**
 *  #0
 *  #1
 *  #4
 *  #6
 *  #7
 *  #8
 */
public class catchInOuterCatch {
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
        catch (Exception e){
            System.out.println( " #6");
        }
        finally {
            System.out.println( " #7");
        }
        System.out.println(" #8");
    }

}
