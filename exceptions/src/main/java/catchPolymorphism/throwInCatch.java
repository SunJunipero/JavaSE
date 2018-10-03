package catchPolymorphism;

/**
 * #1
 * Exception in thread "main" java.lang.Error
 *  #3
 * 	at catchPolymorphism.throwInCatch.main(throwInCatch.java:13)
 */
public class throwInCatch {
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
        System.out.println(" #4 ");
    }
}
