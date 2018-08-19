import model.ImpPerson;
import model.Person;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

/**
 * Optional<T>
 *     - public static <T> Optional<T> empty()
 *     - public static <T> Optional<T> of(T var0)
 *     - public static <T> Optional<T> ofNullable(T var0)
 *     - public T get()
 *     - public boolean isPresent()
 *     - public Optional<T> filter(Predicate<? super T> var1)
 *     - public <U> Optional<U> map(Function<? super T, ? extends U> var1)
 *     - public <U> Optional<U> flatMap(Function<? super T, Optional<U>> var1)
 *     - public T orElse(T var1)
 *     - public T orElseGet(Supplier<? extends T> var1)
 *     - public <X extends Throwable> T orElseThrow(Supplier<? extends X> var1)
 */

public class Demo {
    public static void main(String[] args) {
        /**
         * empty
         */
        Optional empty = Optional.empty();

        /**
         * of
         */
        Optional<Person> alex = Optional.of(new Person("Alex", 32));
        System.out.println(alex.get());

        Person p = null;
        //Optional<Person> p1 = Optional.of(p); // NPE

        /**
         * ofNullable
         */
        Person person = null;
        Optional<Person> person1 = Optional.ofNullable(person);
        System.out.println(person1.isPresent()); //false

        Person person2 = new Person("Bob", 43);
        Optional<Person> bob = Optional.ofNullable(person2);
        System.out.println(bob.isPresent()); //true

        /**
         * ifPresent
         */

        Person jordan = new Person("Jordan", 44);
        Optional<Person> jordanOpt = Optional.of(jordan);
        jordanOpt.ifPresent( jordanPerson -> jordanPerson.setAge(56));

        System.out.println(jordanOpt.get());


        /**
         * filter
         */
        Optional<Person> gats = Optional.of(new Person("Gats", 30));
        Optional<Person> person4 = gats.filter(person3 -> person3.getAge() > 25);
        System.out.println(person4.get().getAge());//30

        /**
         * map
         */
        Optional<Person> casca = Optional.of(new Person("Casca", 27));
        Optional<ImpPerson> impPerson = casca.map(person3 -> new ImpPerson(person3.getName()));

        System.out.println("improve person - " + impPerson.get().getName());

        /**
         * flatMap
         */
        Optional<String> s = Optional.of("input");
        System.out.println(s.map(Demo::getOutput));
        System.out.println(s.flatMap(Demo::getOutputOpt));

        /**
         * orElse
         */

        Person inputOpt = null;
        Optional<Person> opt = Optional.ofNullable(inputOpt);
        Person person3 = opt.orElse(new Person("Test", 12));
        System.out.println(person3);

        /**
         * orElseGet
         */
        Person inputOpt1 = null;
        Optional<Person> opt1 = Optional.ofNullable(inputOpt1);
        Person person5 = opt1.orElseGet(() -> new Person("test person", 12));
        System.out.println(person5);


    }
    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }
}
