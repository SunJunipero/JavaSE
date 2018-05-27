import java.util.*;

public class GenericClassExample {
    public static void main(String[] args) {
        Example<String> stringExample = new Example<String>("string");
        Example<Integer> integerExample = new Example<Integer>(42);
        System.out.println("stringExample - " + stringExample.getT());
        System.out.println("integerExample - " + integerExample.getT());

        System.out.println(" \n\t\tArrayList<Example<String>>");
        ArrayList<Example<String>> examples = new ArrayList<>();
        examples.add(new Example<>("Alex"));
        examples.add(new Example<>("Jamie"));
        examples.add(new Example<>("Miles"));
        examples.add(new Example<>("Math"));

        examples.get(0).Sett("Alex Turner");

        for (Example<String> example : examples) {
            System.out.println(example.getT());
        }

        /**
         * If we type this - "Example stringExample1 = new Example<String>() "
         * Return type of example will be object
         */
        System.out.println(" \n\t\tExample stringExample1 = new Example<String>()");
        Example stringExample1 = new Example<String>();
        stringExample1.Sett(12222);
        System.out.println(stringExample1.getT());

    }

    }

class Example <T>{
    private T t;

    Example(){

    }
    Example (T t){
        this.t = t;
    }

    public void Sett(T t){
        this.t = t;
    }

    public T getT(){
        return t;
    }

}
