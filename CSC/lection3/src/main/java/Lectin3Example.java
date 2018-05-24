import java.util.Random;

public class Lectin3Example {
    public static void main(String[] args) {
        //
        int size = 10;
        int[] ints = new int[size + 10];
        ints[ints.length -1 ] = 100;

//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }

        //
        Random random = new Random();
        Random random1 = random;
        Random random2 = random;
        Random random3 = random1;

        System.out.println(random == random3);
        System.out.println(random1 == random2);


    }
}
