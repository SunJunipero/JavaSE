package catchPolymorphism;

/**
 *  EXCEPTION
 *  NEXT
 */
public class chooseCatchHappnsInRunTime {
    public static void main(String[] args) {
        try {
            Throwable t = new Exception();
            throw t;
        }
        catch (Error error){
            System.out.println(" ERROR ");
        }
        catch (Exception e){
            System.out.println(" EXCEPTION ");
        }
        /**
         * without  catch (Throwable throwable) - compile exception
         */
        catch (Throwable throwable){
            System.out.println(" THROWABLE ");
        }
        System.out.println(" NEXT ");
    }
}
