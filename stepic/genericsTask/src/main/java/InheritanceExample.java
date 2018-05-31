import java.util.Optional;

public class InheritanceExample {
    public static void main(String[] args) {
        Optional <?> optional = Optional.of(1);
        /**
         * All ok
         */
        Object o = optional.get();
        System.out.println(o);

        /**
         * But, cos compiler don't see current parameter of type
         */
        //Object lol = optional.orElse("lol");

        Optional<? extends Number> optionalNumber = Optional.of(12.00);
        Integer number = (Integer) optionalNumber.get(); // ClassCast Exception here



    }
}
