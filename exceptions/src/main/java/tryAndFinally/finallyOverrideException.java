package tryAndFinally;

/**
 *
 * 10
 *
 *
 */
public class finallyOverrideException {
    public static void main(String[] args) {
        System.out.println(f());
    }

    private static int f() {
        try {
            throw new RuntimeException();
        }
        finally {
            return 10;
        }
    }
}
