import java.util.Arrays;

public class GenMethod {
    static < T extends Comparable<T>, V extends T>  boolean contains(T t, V[] v){
        for (int i = 0; i < v.length; i++) {
            if (t.equals(v[i])) {
                return true;
            }
        }
    return false;
    }

    public static void main(String[] args) {
        Integer[] integers = {5, 343, 31, 901, 321};
        System.out.println(contains(31, integers));

        String[] strings = {"lol", "kek", "kkk"};
        System.out.println(contains("kek", strings));
        System.out.println(contains("kek1", strings));
    }
}
