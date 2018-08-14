package FabricConstructor;

public class MyGenClass<T> {

    private T val;

    public MyGenClass (T t){
        val = t;
    }

    T getVal(){
        return val;
    }
}
