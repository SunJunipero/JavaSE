package FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        int read;

        try {
            fileIn = new FileInputStream("/home/kostya/IdeaProjects/JavaSE/io/src/main/java/FileReader/text.txt");
            fileOut = new FileOutputStream("/home/kostya/IdeaProjects/JavaSE/io/src/main/java/FileReader/textout.txt");
            do {
                read = fileIn.read();
                if (read != -1 ) fileOut.write(read);
                System.out.println(((char) read));
            }while (read != -1);
        }
        catch (IOException e){
            System.out.println("input/output exception" + e);
        }

        finally {
                try {
                    if (fileIn != null)
                    fileIn.close();
                } catch (IOException e) {
                    System.out.println("closing file exception");
                }
                try {
                    if (fileOut != null)
                    fileOut.close();
                } catch (IOException e) {
                System.out.println("closing file exception");
                }
        }


    }
}
