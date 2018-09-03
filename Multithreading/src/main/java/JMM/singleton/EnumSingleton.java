package JMM.singleton;

public enum  EnumSingleton {
    INSTANCE;
}

class DemoEnumSingleton{
    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.hashCode());
        System.out.println(EnumSingleton.INSTANCE.hashCode());
    }
}


