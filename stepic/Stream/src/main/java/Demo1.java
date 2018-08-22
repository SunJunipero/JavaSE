import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * public static <T> void findMinMax(
 *         Stream<? extends T> stream,
 *         Comparator<? super T> order,
 *         BiConsumer<? super T, ? super T> minMaxConsumer) {
 *
 *     MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
 *     stream.forEach(minMaxFinder);
 *     minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
 * }
 *
 *
 * private static class MinMaxFinder<T> implements Consumer<T> {
 *
 *     private final Comparator<? super T> order;
 *     T min;
 *     T max;
 *
 *     private MinMaxFinder(Comparator<? super T> order) {
 *         this.order = order;
 *     }
 *
 *     @Override
 *     public void accept(T t) {
 *         if (min == null || order.compare(t, min) < 0) {
 *             min = t;
 *         }
 *         if (max == null || order.compare(max, t) < 0) {
 *             max = t;
 *         }
 *     }
 * }
 */
public class Demo1 {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {


        List<? extends T> minMaxList = stream.sorted(order).collect(Collectors.toList());
        if (minMaxList.size() > 1)
            minMaxConsumer.accept(minMaxList.get(0), minMaxList.get(minMaxList.size() - 1));
        else if (minMaxList.size() == 1)
            minMaxConsumer.accept(minMaxList.get(0), minMaxList.get(0));
        else
            minMaxConsumer.accept(null, null);


    }

    public static void main(String[] args) {

    }
}
