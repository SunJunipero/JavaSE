import java.util.*;

public class EqualsAndHashCodeAllCollections {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "AM", "FOALS", "3", "TLSP");

        /**
         * List
         * ArrayList
         * LinkedList
         */

        Iterable<String> iterable = new LinkedList<>(strings);
        Collection<String> arrayList = new ArrayList<>(strings);
        AbstractCollection<String> stringAbstractCollection = new ArrayList<>(strings);
        List<String> stringList = new ArrayList<>(strings);
        AbstractList<String> abstractList = new ArrayList<>(strings);
        ArrayList<String> strings1 = new ArrayList<>(strings);
        LinkedList<String> linkedList = new LinkedList<>(strings);

        /**
         * Same hashCodes for all hierarchy of List
            Iterable<String>  - -1868732777
            Collection<String> - -1868732777
            List<String> - -1868732777
            AbstractList<String> -1868732777
            ArrayList<String> - -1868732777
            LinkedList<String> - -1868732777

            therefore Equals methods returns true for all combination (C from n by k )
         */
        System.out.println("\t\t--<List>--");
        System.out.println("Iterable<String>  - " + iterable.hashCode());
        System.out.println("Collection<String> - " + arrayList.hashCode());
        System.out.println("AbstractCollection<String> - " + stringAbstractCollection.hashCode());
        System.out.println("List<String> - " + stringList.hashCode());
        System.out.println("AbstractList<String> " + abstractList.hashCode());
        System.out.println("ArrayList<String> - " + strings1.hashCode());
        System.out.println("LinkedList<String> - " + linkedList.hashCode());

        /**
         *Queue
         *  LinkedList
         *  ArrayDeque
         *  PriorityQueue
         * Different hashCodes for all interfaces and implementation, except  Queue<String> queueLinkedList = new LinkedList<>(strings)
         * because LinkedList implements Deque and List.
             Iterable<String>- 1639705018
             Collection<String>- 1627674070
             Queue<String> - -1868732777
             Deque<String> - 1360875712
             AbstractCollection<String> - 1625635731
             ArrayDeque<String> 1580066828
             PriorityQueue<String> - 491044090     *
         *
         */
        System.out.println("\t\t--<Queue>--");
        Iterable<String> IterableArrayDeque = new ArrayDeque<>(strings);
        Collection<String> collectionArrayDeque = new ArrayDeque<>(strings);
        Queue<String> queueLinkedList = new LinkedList<>(strings);
        Deque<String> dequeStrings = new ArrayDeque<>(strings);
        AbstractCollection<String> stringArrayDeque = new ArrayDeque<>(strings);
        ArrayDeque<String> stringAbstractArrayDeque = new ArrayDeque<>(strings);
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(strings);

        System.out.println("Iterable<String>- " + IterableArrayDeque.hashCode());
        System.out.println("Collection<String>- " + collectionArrayDeque.hashCode());
        System.out.println("Queue<String> - " + queueLinkedList.hashCode());
        System.out.println("Deque<String> - " + dequeStrings.hashCode());
        System.out.println("AbstractCollection<String> - " + stringAbstractArrayDeque.hashCode());
        System.out.println("ArrayDeque<String> " + stringArrayDeque.hashCode());
        System.out.println("PriorityQueue<String> - " + stringPriorityQueue.hashCode());


        /**
         * Set
         *
         * Iterable ---->Collection---->Set---------------------->SortedSet---->NavigableSet---->TreeSet
                                 \                            \                               /
                                  \---->AbstractCollection---->AbstractSet-------------------
                                                                     /   \
                                                                    /    \
                                                             EnumSet     HashSet---->LinkedHashSet
         Same hashcode for all hierarchy of Set
             Iterable<String> stringHashSetSet - 69645238
             Collection<String> stringLinkedHashSet - 69645238
             Set<String> stringTreeSet - 69645238
             SortedSet<String> sortedSet - 69645238
             NavigableSet<String> navigableSet - 69645238
             TreeSet<String> treeSet - 69645238
             AbstractCollection<String> - 69645238
             AbstractSet<String> - 69645238
             HashSet<String> hashSet - 69645238
             LinkedHashSet<String> linkedHashSet - 69645238
         */
        System.out.println("\t\t--<Set>--");
        Iterable<String> stringHashSetSet = new HashSet<>(strings);
        Collection<String> stringLinkedHashSet = new LinkedHashSet<>(strings);
        Set<String> stringTreeSet = new TreeSet<>(strings);
        SortedSet<String> sortedSet = new TreeSet<>(strings);
        NavigableSet<String> navigableSet = new TreeSet<>(strings);
        TreeSet<String> treeSet = new TreeSet<>(strings);
        AbstractCollection<String> abstractHashSet = new HashSet<>(strings);
        AbstractSet<String> abstractSetHashSet = new HashSet<>(strings);
        HashSet<String> hashSet = new HashSet<>(strings);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(strings);

        navigableSet.first();
        System.out.println("Iterable<String> stringHashSetSet - " + stringHashSetSet.hashCode());
        System.out.println("Collection<String> stringLinkedHashSet - " + stringLinkedHashSet.hashCode());
        System.out.println("Set<String> stringTreeSet - " + stringTreeSet.hashCode());
        System.out.println("SortedSet<String> sortedSet - " + sortedSet.hashCode());
        System.out.println("NavigableSet<String> navigableSet - " + navigableSet.hashCode());
        System.out.println("TreeSet<String> treeSet - " + treeSet.hashCode());
        System.out.println("AbstractCollection<String> - "+ abstractHashSet.hashCode());
        System.out.println("AbstractSet<String> - " + abstractSetHashSet.hashCode());
        System.out.println("HashSet<String> hashSet - "+hashSet.hashCode());
        System.out.println("LinkedHashSet<String> linkedHashSet - " + linkedHashSet.hashCode());

    }
}
