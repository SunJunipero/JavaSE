package JMM.singleton;

public class Container {
    private Container(){
    }

    int x = 1;

    private static final Container CONTAINER = new Container();

    public static Container getCONTAINER() {
        return CONTAINER;
    }
}
