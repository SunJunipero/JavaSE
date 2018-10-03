package catchPolymorphism;

public class RNEcantcatchException {
    public static void main(String[] args) {
        try {
            System.out.println(" #1 ");
            if(true)
//                throw new Exception(); // unhandled exception
            System.out.println(" #2 ");
        }
//        catch (Throwable throwable){
//
//        }
        catch (RuntimeException e){
            System.out.println(" #3 ");
        }

        System.out.println(" # 4");
    }
}
