package GenericHierarchy;

public class InstanceOfGenericClasses {
    public static void main(String[] args) {
        SupGenClass<Integer> integerSupGenClass = new SupGenClass<>(12);
        SubGenClass<Integer> integerSubGenClass = new SubGenClass<>(21);
        SubGenClass<String> st = new SubGenClass<>("st");

        if (integerSubGenClass instanceof SubGenClass<?>){
            System.out.println("true " + "integerSubGenClass instanceof SubGenClass<?>");
        }
        else
            System.out.println("false");

        if(integerSubGenClass instanceof SupGenClass<?>){
            System.out.println("true " + "integerSubGenClass instanceof SupGenClass<?>");
        }
        else
            System.out.println("false");

        if (st instanceof SupGenClass<?>){
            System.out.println("true " + "st instanceof SupGenClass<?>");
        }
        else
            System.out.println("false");

        if (st instanceof SubGenClass<?>){
            System.out.println("true " + "st instanceof SubGenClass<?>");
        }
        else
            System.out.println("false");

        if (integerSupGenClass instanceof SubGenClass<?>){
            System.out.println("true " + "integerSupGenClass instanceof SubGenClass<?>");
        }
        else
            System.out.println("false");

        if (integerSupGenClass instanceof SupGenClass<?>){
            System.out.println("true " + "integerSupGenClass instanceof SupGenClass<?>");
        }
        else
            System.out.println("false");
        /**
         * Compile error below, because information about type is absent in compile time
         */
//        if (st instanceof SupGenClass<String>){
//            System.out.println("true " + "st instanceof SupGenClass<String>");
//        }
//        else
//            System.out.println("false");


    }
}

class SupGenClass<T>{
    T t;
    SupGenClass(T t){
        this.t = t;
    }
}

class SubGenClass<T> extends SupGenClass<T>{
    SubGenClass(T t){
        super(t);
    }
}
