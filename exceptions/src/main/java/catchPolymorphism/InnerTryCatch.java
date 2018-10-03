package catchPolymorphism;

/**
 *  #1
 *  #3
 *  #4
 *  #6
 */
public class InnerTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println(" #1 ");
            if (true)
                throw new Exception();
            System.out.println(" #2 ");
        }
        catch (Exception e){
            try {
                System.out.println(" #3 ");
                throw new Error();
            }
            catch (Error error){
                System.out.println(" #4 ");
            }

        }
        catch (Error e){
            System.out.println(" #5 ");
        }
        System.out.println(" #6 ");
    }
}
