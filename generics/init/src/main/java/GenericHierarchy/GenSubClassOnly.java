package GenericHierarchy;

public class GenSubClassOnly {
    public static void main(String[] args) {
        GenSubClass<Integer> for_nonGen_class = new GenSubClass<>(42, "for NonGen class");
        System.out.println("for_nonGen_class - " + for_nonGen_class.t + "  " +  for_nonGen_class.str);
    }

}
class NonGen{
    String str;

    NonGen(String str){
        this.str = str;
    }
}

class GenSubClass <T> extends NonGen{
    T t;

    GenSubClass(T t, String str){
        super(str);
        this.t = t;
    }
}
