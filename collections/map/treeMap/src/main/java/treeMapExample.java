import java.util.Map;
import java.util.TreeMap;


/**
 * Initial capacity - 0
 */
public class treeMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();

        /**
         * We may get subMap from tree map
         */

        treeMap.put("1", "Alex");
        treeMap.put("2", "Math");
        treeMap.put("3", "Miles");
        treeMap.put("4", "Jamie");
        treeMap.put("5", "Nick");

        System.out.println(treeMap.size());

        System.out.println("\t SubMap");
        System.out.println(treeMap.subMap("1", "4"));

        System.out.println("\t HeadMad and TailMap");
        System.out.println(treeMap.headMap("3"));
        System.out.println(treeMap.tailMap("3"));

        System.out.println("\t Last key");
        System.out.println(treeMap.headMap("3").lastKey());

        System.out.println("\t first key");
        System.out.println(treeMap.headMap("5").firstKey());


    }
}
