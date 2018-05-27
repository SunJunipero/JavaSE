import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        System.out.println("\t\t List list");
        List list = new ArrayList();
        list.add("val1");
        list.add(1);
        list.add(new A(12));

        //All ok
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("\t\t List<Object>");
        List<Object> list1 = new ArrayList<>();
        list1.add(121);
        list1.add("loll");
        list1.add(new A(33));

        //All ok
        for (Object o : list1) {
            System.out.println(o);
        }

    }
}

class A{
    int a;

    A(int a){
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);

    }
}
