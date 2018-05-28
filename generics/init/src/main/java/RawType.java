public class RawType {
    public static void main(String[] args) {
        Gen<Integer> integerGen = new Gen<>(42);
        int i = integerGen.getT();

        Gen<String> lol = new Gen<>("lol");
        String strLol = lol.getT();

        /**
         * Init raw type, without type's parameter, therefore necessary make cast to current type
         */
        Gen doubleGen = new Gen(0.42);
        double raw = (double)doubleGen.getT();
        /**
         * Class cast exception, runtime error.
         */
        int t = (Integer) doubleGen.getT();
        System.out.println(t);

    }
}

class Gen<T>{
    T t;

    Gen(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
