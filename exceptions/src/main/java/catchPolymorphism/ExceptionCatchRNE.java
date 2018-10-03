package catchPolymorphism;

/**
 *  #1
 *  #3
 *  #4
 */
public class ExceptionCatchRNE {
    public static void main(String[] args) {
        try {
            System.out.println(" #1 ");
            if (true)
                throw new RuntimeException();
            System.out.println(" #2 ");

        }
        catch (Exception e){
            System.out.println(" #3 ");
        }
        System.out.println(" #4 ");



    }
}
