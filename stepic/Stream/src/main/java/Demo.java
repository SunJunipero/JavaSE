import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
 *
 * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 * Первый элемент последовательности устанавливается равным этому числу.
 * Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(R2n), где mid — это функция, выделяющая второй,
 * третий и четвертый разряд переданного числа. Например, mid(123456)=345.
 * Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
 *
 * Пример
 *
 * pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
 *
 * 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
 */

public class Demo {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed,
                i -> {
                    String s = String.valueOf(i * i);
                    String res ;
                    //System.out.println("S = " + s + "  length s - " + s.length());
                    if(s.length() >= 4){
                        char c = s.charAt(s.length()-4);
                        char c1 = s.charAt(s.length()-3);
                        char c2 = s.charAt(s.length()-2);
                        res = c+""+c1+""+c2;
                    }
                    else if (s.length() == 1) {
                        res = "0";
                    }
                    else if (s.length() == 2)
                    {
                        char c = s.charAt(s.length()-2);
                        res = String.valueOf(c);
                    }
                    else
                    {
                        char c1 = s.charAt(s.length() - 3);
                        char c2 = s.charAt(s.length() - 2);
                        res = c1 + "" + c2;
                    }

                    return Integer.valueOf(res);
                }); // your implementation here
    }

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(15).forEach(i -> System.out.print(i + " "));
        System.out.println();
        pseudoRandomStream(2).limit(15).forEach(i -> System.out.print(i + " "));
        System.out.println();
        pseudoRandomStream(131).limit(15).forEach(i -> System.out.print(i + " "));
        System.out.println();
        pseudoRandomStream(4).limit(15).forEach(i -> System.out.print(i + " "));



    }
}
