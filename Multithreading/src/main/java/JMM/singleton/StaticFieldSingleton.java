package JMM.singleton;

class Singleton{
    public static final Singleton INSTANCE = new Singleton();
}


public class StaticFieldSingleton {
    public static void main(String[] args) {
        System.out.println(Singleton.INSTANCE.hashCode());
        System.out.println(Singleton.INSTANCE.hashCode());
    }
}
