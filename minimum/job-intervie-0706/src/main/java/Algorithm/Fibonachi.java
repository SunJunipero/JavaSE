package Algorithm;

public class Fibonachi {
    static int fib(int i){
        // 1 1 2 3 5 8 13 21
        if(i == 1) return 1;
        if(i == 2) return 1;
        return fib(i - 1) + fib(i - 2);
    }

    /**
     * 1 -> 1
     * 2 -> 2
     * 3 -> 2 * 3 = 6
     * 4 -> 6 * 4 = 24
     * 5 -> 24 * 5 = 120
     * @param i
     * @return
     */
    static int fact(int i){
        if(i == 1) return 1;
        return fact(i - 1) * i;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));

        System.out.println(fact(5));
    }
}


