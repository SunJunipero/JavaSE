package GenericHierarchy;

public class GenericSuperClass {
    public static void main(String[] args) {
        SubGen<Integer> subGen = new SubGen<>(42, "subGen");
        SuperGen<Integer> superGen = new SubGen<>(32, "lol");

        System.out.println("subGen - " +  subGen.t + " " + subGen.str);
        /**
         * superGen.str is not available
         */
        //System.out.println("superGen - " +  superGen.t + " " + superGen.str);
        System.out.println("superGen - " +  superGen.t );




    }

}

class SuperGen<T>{
    T t;

    SuperGen (T t){
        this.t = t;
    }

    void testSuperGen(){
        System.out.println("test super Gen");
    }

}

class SubGen<T> extends SuperGen<T>{
    String str;

    SubGen(T t, String str){
        super(t);
        this.str = str;
    }

    void testSubGen(){
        System.out.println("test SubGen");
    }
}
