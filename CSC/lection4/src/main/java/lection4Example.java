import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class lection4Example {
    public static void main(String[] args) {
        Integer[] ints = new Integer[10];
        Object[] objects = ints;
       // objects[0] = "dooo";//java.lang.ArrayStoreException

        System.out.println(IntStream.of(1, 2, 3).map(x -> x * x).sum());
        System.out.println(3 | 4);

       // System.out.println(fib(3));
        System.out.println( f(6));

        Node root = new Node();
        Node floor1left = new Node();
        Node floor1right = new Node();
        Node floor2leftleft = new Node();
        Node floor2leftright = new Node();

        root.left = floor1left;
        root.right = floor1right;
        floor1left.left = floor2leftleft;
        floor1left.right = floor2leftright;
        floor2leftleft.left = null;
        floor2leftleft.right = null;

        System.out.println(Node.height(floor1left));

    }
    static int fib(int n) {

        return fib(n - 1) + fib(n - 2);

    }

    static int f(int n) {

        if (n <= 0) {

            return 0;

        }

        return n + f(n / 2);

    }

    static class Node {

        Node left;

        Node right;


        static int height(Node node) {

            if (node == null) {

                return 0;

            }


            int left = height(node.left);

            int right = height(node.right);

            return Math.max(left, right);

        }



    }





}

class Animal {}



class Dog extends Animal {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();//from segmento

        //List< Animal> animals = dogs;//from segmento

        ArrayList<Animal> animals = new ArrayList<>();
        //List<Dog> dogList = animals;

    }

}



