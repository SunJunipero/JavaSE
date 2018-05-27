public class TypeSafetyExample {
    public static void main(String[] args) {
        NonGenType nonGenType = new NonGenType(1);
        nonGenType.typeOfValue();
        int t = (Integer) nonGenType.getT();
        System.out.println(t);
        NonGenType lol = new NonGenType("lol");
        lol.typeOfValue();
        String t1 = (String) lol.getT();
        System.out.println(t1);
        NonGenType nonGenType1 = new NonGenType(0.0001);
        nonGenType1.typeOfValue();
        double t2 = (Double) nonGenType1.getT();
        System.out.println(t2);

        nonGenType = lol;
        //Integer t5 = (Integer) nonGenType.getT(); // runtime error (ClassCastException)
//        System.out.println(t3);

        GenType<Integer> integerGenType = new GenType<>(12);
        int t3 = integerGenType.getT();
        System.out.println(t3);
        GenType<String> kek = new GenType<>("kek");
        String t4 = kek.t;
        System.out.println(t4);

        /**
         * Compile error - incompatible class
         */
        //integerGenType = kek;


    }
}

class GenType<T>{
    T t;

    GenType(T t){
        System.out.println("\t\t from constructor " + t.getClass().getCanonicalName());
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void typeOfValue(){
        System.out.println(t.getClass().getName());
    }
}


/**
 * Bad way, because necessary cart type, and hides runtime error
 */
class NonGenType{
    Object t;

    NonGenType(Integer i){
        System.out.println("\t\tInteger constructor");
        t = i;
    }

    NonGenType(String s){
        System.out.println("\t\tString constructor");
        t = s;
    }

    NonGenType(Number n){
        System.out.println("\t\tNumber constructor");
        t = n;
    }

    NonGenType(Object ob){
        System.out.println("Object constructor");
        t = ob;
    }

    public Object getT() {
        return t;
    }

    public void typeOfValue(){
        System.out.println(t.getClass().getName());
    }
}
