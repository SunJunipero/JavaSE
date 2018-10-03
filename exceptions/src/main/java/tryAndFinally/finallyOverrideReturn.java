package tryAndFinally;

/**
 *
 * 20
 *
 */
public class finallyOverrideReturn {
    public static void main(String[] args) {
        System.out.println(f());

    }

    private static int f() {
        try {
            return 10;
        }
        finally {
            return 20;
        }
    }
}
