import java.lang.reflect.Array;
import java.util.*;

/**
 * -allow duplicate elements
 * -allow multiple null elements
 *
 * additional methods
 *  -add(int index, E element)
 *  -addAll(Collection<? extends E> c)
 *  -get(int index)
 *  -indexOf(Object o) Returns the index
 *  of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
 *  -lastIndexOf(Object o)Returns the index
 *  of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
 *  -listIterator() - we may travers list in either direction, and additional we may get index next and previous
 *  element and set value for elements
 *  -remove(int index)
 *  -replaceAll(UnaryOperator<E> operator)
 *  -set(int index, E element)
 *  -spliterator()
 *  -sort(Comparator<? super E> c)
 */
public class SimpleListExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "lol", "kek");
        List<String> list = new ArrayList<>(strings);

        System.out.println("\t\t add(int index, E element");
        System.out.println(list); //[1, 2, 3, lol, kek]
        list.add(4, "new val");
        System.out.println(list); //[1, 2, 3, lol, new val, kek]

        System.out.println("\t\t addAll(Collection<? extends E> c)");
        List<String> strings1 = Arrays.asList("new ", "collection", "from", "addAll");
        System.out.println(list);//[1, 2, 3, lol, new val, kek]
        boolean b = list.addAll(5, strings1);
        System.out.println(b);
        System.out.println(list);//[1, 2, 3, lol, new val, new , collection, from, addAll, kek]

        System.out.println("\t\t get(int index)");
        System.out.println(list.get(4));//new val

        System.out.println("\t\t indexOf(Object o)");
        list.add(3, "lol");
        System.out.println(list);//[1, 2, 3, lol, lol, new val, new , collection, from, addAll, kek]
        System.out.println(list.indexOf("lol"));//3

        System.out.println("\t\t last indexOf(Object o)");
        System.out.println(list.lastIndexOf("lol"));//4

        System.out.println("\t\t listIterator()");
        ListIterator<String> stringListIterator = list.listIterator(list.size());

        while (stringListIterator.hasPrevious()) {
            System.out.println(stringListIterator.previousIndex() + " " + stringListIterator.previous());
        }

        System.out.println("\t\t remove(int index)");
        System.out.println(list);
        String remove = list.remove(5);
        System.out.println("remove - " + remove);
        System.out.println(list);

        //TODO bc functional interfaces. UnaryOperator
        System.out.println("\t\t replaceAll(UnaryOperator<E> operator)");

        System.out.println("\t\tset(int index, E element)");
        System.out.println(list);//[1, 2, 3, lol, lol, new , collection, from, addAll, kek]
        String from_set_methos = list.set(5, "from Set methos");//return new because index ofo this elemet 5
        System.out.println("new val - " + from_set_methos);
        System.out.println(list);//[1, 2, 3, lol, lol, from Set methos, collection, from, addAll, kek]

        //TODO spliterator
        System.out.println("spliterator()");

        System.out.println("sort(Comparator<? super E> c)");

        class CustomClass  {
            int id;
            String text;

            public CustomClass(int id, String text) {
                this.id = id;
                this.text = text;
            }

            @Override
            public String toString() {
                return "CustomClass{" +
                        "id=" + id +
                        ", text='" + text + '\'' +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

        }

        class ComparatorCustomClass implements Comparator<CustomClass>{
            @Override
            public int compare(CustomClass customClass, CustomClass t1) {
                return customClass.getId()-t1.getId() == 0 ? customClass.getText().compareTo(t1.getText()) : customClass.getId() - t1.getId();
            }
        }

        ArrayList<CustomClass> customClasses = new ArrayList<>();
        customClasses.add(new CustomClass(12, "12"));
        customClasses.add(new CustomClass(5, "5"));
        customClasses.add(new CustomClass(0, "12"));
        customClasses.add(new CustomClass(5, "13"));
        customClasses.add(new CustomClass(-12, "-12"));

        System.out.println(customClasses);
        customClasses.sort(new ComparatorCustomClass());
        System.out.println(customClasses);


    }

}
