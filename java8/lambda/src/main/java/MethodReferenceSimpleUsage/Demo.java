package MethodReferenceSimpleUsage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        ArrayList<CostumClass> costumClasses = new ArrayList<>();

        costumClasses.add(new CostumClass(12));
        costumClasses.add(new CostumClass(3));
        costumClasses.add(new CostumClass(6));
        costumClasses.add(new CostumClass(99));
        costumClasses.add(new CostumClass(16));
        costumClasses.add(new CostumClass(42));
        costumClasses.add(new CostumClass(83));

        CostumClass max = Collections.max(costumClasses);

        System.out.println(max.val);


        ArrayList<CostumClassSimple> costumClassSimples = new ArrayList<>();
        costumClassSimples.add(new CostumClassSimple(12));
        costumClassSimples.add(new CostumClassSimple(3));
        costumClassSimples.add(new CostumClassSimple(6));
        costumClassSimples.add(new CostumClassSimple(99));
        costumClassSimples.add(new CostumClassSimple(16));
        costumClassSimples.add(new CostumClassSimple(42));
        costumClassSimples.add(new CostumClassSimple(83));

        CostumClassSimple max1 = Collections.max(costumClassSimples, CompareCC::compare);

        System.out.println(max1.val);

       Comparator<CostumClassSimple> cc = new Comparator<CostumClassSimple>() {
           @Override
           public int compare(CostumClassSimple costumClassSimple, CostumClassSimple t1) {
               return costumClassSimple.val - t1.val;
           }
       };

        System.out.println(Collections.max(costumClassSimples, cc).val);


    }
}
