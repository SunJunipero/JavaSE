import java.util.Objects;

public class PairExample {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);


    }
}

class Pair<T,V>{
    private T t;
    private V v;

    private Pair(T t, V v){
        this.t = t;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(t, pair.t) &&
                Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {

        return Objects.hash(t, v);
    }

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    public static <T,V> Pair<T,V> of (T t, V v){
        return new Pair<>(t, v);
    }
}
