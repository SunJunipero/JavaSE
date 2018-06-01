public class ExceptionTask {
    public static void main(String[] args) {
       // System.out.println(sqrt(-12));
        System.out.println(sqrt(25));
    }

    public static double sqrt(double x) {
        String msg = "Expected non-negative number, got " + x;
        if (x < 0)
            throw new IllegalArgumentException(msg);
        else return Math.sqrt(x); // your implementation here
    }
}

