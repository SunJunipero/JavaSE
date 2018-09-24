package BFReaer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String magenta = "\033[0;35m";
    private static String cyan = "\033[0;36m";

    public static void main(String[] args) throws IOException {

        readCharExaple(br);
        //readlineExaple(br);

    }

    static void readCharExaple(BufferedReader br) throws IOException {
        System.out.println("Type any text. Press 'q' for exit ");

        char out;

        do {
            out = (char) br.read();
            System.out.printf("%s%c", cyan, out);
        }while (out != 'q');
    }

    static void readlineExaple(BufferedReader br) throws IOException {
        System.out.println("Type any text. Press 'q' for exit ");

        String out;

        do {
            out = br.readLine();
            System.out.printf("%s%s%n", magenta, out);
        }while (!out.equals("off"));
        System.out.println();
    }


}
