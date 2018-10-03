package frames;

/**
 * in 1
 *     in 2
 *         in 3
 *                 in 4
 *                 THROW
 * CATCH
 * out of  1
 */
public class catchInFirstFrame {
    public static void main(String[] args) {
        f();
    }

    private static void f() {
        System.out.println("in 1");
        try {
            g();
        }
        catch (Error e){
            System.out.println("CATCH");
        }

        System.out.println("out of  1");
    }

    private static void g() {
        System.out.println("    in 2");
        h();
        System.out.println("    out of  2");
    }

    private static void h() {
        System.out.println("        in 3");
        k();
        System.out.println("        out of  3");
    }

    private static void k() {
        System.out.println("                in 4");
        if(true){
            System.out.println("                THROW");
            throw new Error();
        }
        System.out.println("                out of  4");
    }
}
