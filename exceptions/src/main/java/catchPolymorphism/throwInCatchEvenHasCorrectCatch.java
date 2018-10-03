package catchPolymorphism;

/**
 * Exception in thread "main" java.lang.Error
 * 	at catchPolymorphism.throwInCatchEvenHasCorrectCatch.main(throwInCatchEvenHasCorrectCatch.java:13)
 *  #1
 *  #3 
 */
public class throwInCatchEvenHasCorrectCatch {
    public static void main(String[] args) {
        try {
            System.out.println(" #1 ");
            if (true)
                throw new Exception();
            System.out.println(" #2 ");
        }
        catch (Exception e){
            System.out.println(" #3 ");
            throw new Error();
        }
        catch (Error e){
            System.out.println(" #4 ");
        }
        System.out.println(" #5 ");
    }

}
