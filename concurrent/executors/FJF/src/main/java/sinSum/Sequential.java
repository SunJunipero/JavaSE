package sinSum;

public class Sequential {
    public static void main(String[] args) {
        int[] ints = Commons.prepareArr();

        long l = System.currentTimeMillis();

        double calculate = Commons.calculate(ints);

        System.out.println("time - " + (System.currentTimeMillis() - l));

        System.out.println("sum  = " + calculate);


    }
}
