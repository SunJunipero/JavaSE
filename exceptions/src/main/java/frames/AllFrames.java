package frames;

/**
 * in 1
 *     in 2
 *         in 3
 *                 in 4
 *                 out of  4
 *         out of  3
 *     out of  2
 * out of  1
 */
public class AllFrames {
    public static void main(String[] args) {
        f();
    }

    private static void f() {
        System.out.println("in 1");
        g();
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
        System.out.println("                out of  4");
    }
}
