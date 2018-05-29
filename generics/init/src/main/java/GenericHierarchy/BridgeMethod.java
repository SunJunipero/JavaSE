package GenericHierarchy;

/**
 * Type javap Gen2.class in current directory, and you'll see
 * bridge method
     class GenericHierarchy.Gen2 extends GenericHierarchy.Gen<java.lang.String> {
     GenericHierarchy.Gen2(java.lang.String);
     public java.lang.String getT();
     public java.lang.Object getT();

 this is it - public java.lang.Object getT();
 }

 */

public class BridgeMethod {
    public static void main(String[] args) {
        Gen2 bridge = new Gen2("bridge");
        System.out.println(bridge.getT());

        Gen<String> str = new Gen<>("str");
        System.out.println(str.getT());
    }
}

class Gen<T>{
    T t;

    Gen(T t ){
        this.t = t;
    }

    public T getT() {
        System.out.println("from Gen");
        return t;
    }
}

class Gen2 extends Gen<String>{
    Gen2(String s){
        super(s);
    }

    @Override
    public String getT() {
        System.out.println("from Gen2");
        return t;
    }
}
