package GenericHierarchy;

public class RedefinitionMethod {
    public static void main(String[] args) {
        GenClass<Integer> integerGenClass = new GenClass<>(14);
        System.out.println(integerGenClass.getT());

        SubGenClass1<Integer> integerSubGenClass1 = new SubGenClass1<>(88);
        System.out.println(integerSubGenClass1.getT());

        GenClass<Integer> i = new SubGenClass1<>(12);
        System.out.println(i.getT());
    }
}

class GenClass <T>{
    T t;

    GenClass (T t){
        this.t = t;
    }

    T getT(){
        System.out.println("GenClass");
        return t;
    }
}

class SubGenClass1 <T> extends GenClass<T>{
    T t;

    SubGenClass1(T t){
        super(t);
        this.t = t;
    }

    T getT(){
        System.out.println("SubGenClass1");
        return t;
    }

}
