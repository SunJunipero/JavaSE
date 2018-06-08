package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWorkExample {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/home/kostya/IdeaProjects/JavaSE/minimum/job-intervie-0706/src/main/java/file/file.txt");

        int c = 1;

        while ((c = fileReader.read()) != -1) {
            System.out.println(((char) c));
        }


    }
}
