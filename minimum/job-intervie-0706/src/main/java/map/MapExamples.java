package map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, null);
        map.put(3, "2");
        map.put(5, "3434");
        map.put(4, "23");
        map.put(1313, "2322");
        System.out.println(map.size());

        System.out.println(map);


        //Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("Values");
        System.out.println(map.values());

        System.out.println("Key set");
        System.out.println(map.keySet());

        System.out.println("entrySet");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue() );
        }

        System.out.println("map.size();");
        System.out.println(map.size());

        String remove = map.remove(null);
        System.out.println("remove - " + remove);
        System.out.println("after remove");
        System.out.println(map.size());


    }
}

