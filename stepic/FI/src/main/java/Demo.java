import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Давайте научимся комбинировать функции в более сложные функции.
 * Для примера построим следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.
 * Напишите метод ternaryOperator, который из них построит новую функцию, возвращающую значение функции
 * ifTrue, если предикат выполнен, и значение ifFalse иначе.
 *
 * Пример использования метода (можно было все свернуть в одну строчку,
 * но для наглядности все элементы вынесены в отдельные переменные):
 */
public class Demo {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;

        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    }
}