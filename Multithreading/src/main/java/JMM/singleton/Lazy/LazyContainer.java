package JMM.singleton.Lazy;

public class LazyContainer {
    int x = 1;
    private static LazyContainer INSTANCE;

    private LazyContainer(){
    }

    public static synchronized LazyContainer getContainer(){
        if (INSTANCE == null)
            INSTANCE = new LazyContainer();
        return INSTANCE;
    }


}
