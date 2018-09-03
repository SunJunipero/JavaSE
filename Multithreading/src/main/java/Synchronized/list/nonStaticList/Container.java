package Synchronized.list.nonStaticList;

import java.util.LinkedList;
import java.util.List;

public class Container {
    private final List<String> list = new LinkedList<>();

    public synchronized void addValye (String s){
        list.add(s);
    }

    int size(){
        return list.size();
    }

}
