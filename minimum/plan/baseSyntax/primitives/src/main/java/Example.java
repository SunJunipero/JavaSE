import java.math.BigInteger;

public class Example {
    static void print2DArr(){
        int g[][] = new int[10][10];


        for (int i = 0; i < (g.length); i++) {
            for (int j = 0; j < g.length; j++) {
                g[i][j] = i + j;
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void print2DArrAnother(){
        int g[][] = new int[10][10];


        for(int i = 0; i < g.length; i++) {
            //g[i][i] = 2* i;
            for(int j = 0; j < i; j++) {
                g[j][i] = g[i][j] = i + j;
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
                }
    public static void main(String[] args) {
        byte byteValue = 64;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        System.out.println(longValue);

        char charValue = 'g';
        intValue = charValue;
        //int intFromChar = charValue;
        System.out.println(intValue);

        float floatValue = longValue;
        double doubleValue = floatValue;
        System.out.println(doubleValue);

        float floatV =  (float) 123.00D;

        byte b1 = (byte) 1024;
        byte b2 = 127;
        System.out.println(b1 + "  " + b2);

        float ff = (float) 1e20;
        System.out.println(ff);

        double dd = 1e100;
        float fdd = (float) dd;
        System.out.println(fdd);


        System.out.println(false == false);


        int initial = 10;
        Integer ref = Integer.bitCount(255);
        System.out.println(ref);

        //print2DArr();
        print2DArrAnother();

        BigInteger bigInteger = new BigInteger("11");

        int[] arr = {1,2131, (int) 22323d};

        for (int i : arr) {
            System.out.print(i + "  " );
        }

        int[][] arr2d = {{1,2,3},{1,2}};

        for (int i = 0; i < arr2d.length; i++) {
            System.out.println("length - " + arr2d[i].length);
        }

    }
}
