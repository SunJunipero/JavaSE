package Exception.forCheckedException;


/**
 * Если ламбда генерирует исключение, то исключение должно быть
 * совместимо с исключениеями, перечисленными в абс. методе ФИ
 * полсе throws
 */

public class Demo {
    public static void main(String[] args)  {
        FuncInt funcInt = values -> {
            double sum = 0;
            if (values.length == 0) throw new EmptyArrayException();
            for (int value : values) {
                sum += value;
            }
            return sum / values.length;
        };

        try {
            System.out.println(funcInt.sam(new int[]{1, 3, 6, 7}));
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(funcInt.sam(new int[]{}));
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
