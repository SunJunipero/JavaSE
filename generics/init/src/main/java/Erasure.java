import java.util.ArrayList;
import java.util.List;

public class Erasure {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        List list = integers;
        ArrayList<String> strings = (ArrayList<String>) list;



    }
}
