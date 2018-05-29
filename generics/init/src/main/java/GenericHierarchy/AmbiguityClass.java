package GenericHierarchy;

import java.util.Random;

public class AmbiguityClass {
    public static void main(String[] args) {
        Ambiguity<Number, Number> numberNumberAmbiguity = new Ambiguity<>(12, 23);
        System.out.println(numberNumberAmbiguity);

        // Ambiguous method call both
        // numberNumberAmbiguity.set(1001);

    }
}

class Ambiguity <T ,V extends Number>{
    T t;
    V v;

    Ambiguity (T t, V v){
        this.t = t;
        this.v = v;
    }

    void set (T t){
        this.t = t;
    }

    void set (V v){
        this.v = v;
    }

    public String toString(){
        return t + " " + v;
    }


}
