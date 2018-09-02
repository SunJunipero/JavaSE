package JMM.singleton.doublechekedLockingSingleton;

public class Container {

    int x = 42;

    private static volatile Container INSTANCE;

    private Container(){

    }

    public static Container getContainer(){
        if (INSTANCE == null){
            synchronized (Container.class){
                if (INSTANCE == null)
                    INSTANCE = new Container();
            }
        }
        return INSTANCE;
    }


}
