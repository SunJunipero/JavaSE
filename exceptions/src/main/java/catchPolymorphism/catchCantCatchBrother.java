package catchPolymorphism;

/**
 *  #1 
 */
public class catchCantCatchBrother {
    public static void main(String[] args) {
        try {
            System.out.println(" #1 ");
            if (true)
                throw new Error();
            System.out.println(" #2 ");
        }
        catch (Exception e){
            System.out.println(" #3 ");
        }
        System.out.println(" #4 ");

    }
}
