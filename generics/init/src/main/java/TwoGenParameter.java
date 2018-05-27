public class TwoGenParameter {
    public static void main(String[] args) {
        TwoGen<Integer, String> v = new TwoGen<>(1111, "val1");
        v.ShowsTypes();
    }
}

class TwoGen <T , V> {
    T t;
    V v;

    TwoGen(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public void ShowsTypes(){
        System.out.println(t.getClass().getName() + "\n" + v.getClass().getName());
    }

}
