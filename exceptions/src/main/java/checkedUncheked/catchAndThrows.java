package checkedUncheked;

/**
 * in case of a child (or "brother") of exception being caught THROWS REQUIRED
 */
public class catchAndThrows {
    public static void main(String[] args) throws Throwable{
        try {
            throw new Throwable();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
