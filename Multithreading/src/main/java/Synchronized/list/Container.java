package Synchronized.list;

import java.util.LinkedList;
import java.util.List;

public class Container {
    static List<String> list = new LinkedList<>();

    public synchronized void addValye (String s){
        list.add(s);
    }

}
