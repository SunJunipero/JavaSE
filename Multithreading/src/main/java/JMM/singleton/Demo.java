/**
 * https://habr.com/post/129494/ - Правильный Singleton в Java
 */

package JMM.singleton;

public class Demo {
    public static void main(String[] args) {
        Container container = Container.getCONTAINER();

        System.out.println(container.hashCode());
        System.out.println(Container.getCONTAINER().hashCode());

    }
}
