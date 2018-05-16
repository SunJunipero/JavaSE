import java.util.HashMap;
import java.util.Map;

public class HasnMapExample {
    public static void main(String[] args) {
        /**
         * Ноды могут содержать ссылки друг на друга. С такими же hc, но по equals
         * они будут не равны
         *
         * initial capacity - 16
         * MAXIMUM_CAPACITY = 1073741824
         *
         * TODO
         * loadFactor
         *
         * java hashMap same bucket different hashcode
         *   -- yes, initial capacity 16
         *   1/16 and 17/16 put in same bucket
         *
         * HashMap performance improvements in Java 8. Since java8 hashMap presents as binary search tree
         *
         *Memory hashMap > memory treeMap since hashMap use loadfactor, therefor we have some empty Entry
         */
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("lol", "kek");



    }
}
