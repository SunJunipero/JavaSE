package GenericHierarchy;

public class TwoGenParameterSubClass {
    public static void main(String[] args) {
        SubGenT<Integer, Double> integerDoubleSubGenT = new SubGenT<>(12, 0.32);
        System.out.println("SubGenT<Integer, Double> - " + integerDoubleSubGenT.t + " " + integerDoubleSubGenT.v);
    }
}


class SuperGenT<T>{
    T t;

    SuperGenT(T t){
        this.t = t;
    }
}

class SubGenT<T,V> extends SuperGenT<T>{
    V v;

    SubGenT(T t, V v){
        super(t);
       this.v = v;
    }
}