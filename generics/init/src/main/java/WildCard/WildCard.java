package WildCard;

public class WildCard {
    public static void main(String[] args) {
        Integer[] integers = {1, 0, 4, 10, 5, 0};
        Double[] doubles = {0.0, 0.0, 10.0, 4.0, 5.0, 1.0};

        CorrecArr<Integer> integerCorrecArr = new CorrecArr<>(integers);
        CorrecArr<Double> doubleCorrecArr = new CorrecArr<>(doubles);

        if (integerCorrecArr.sameAvg(doubleCorrecArr)) {
            System.out.println("Arrays are same ");
        }
        else System.out.println("Arrays not same");
    }
}

class CorrecArr<T extends Number> {
    T[] arr;

    CorrecArr(T[] arr){
        this.arr = arr;
    }

    double getAvg(){
        double sum = 0;
        for (T t : arr) {
            sum += t.doubleValue();
        }
        return sum / arr.length;
    }

    /**
     * Why we can used CorrectArr<T> in this method ?
     *  Because object's type, that call method CorrectAll must match with object ob
     *         CorrectArr<Integer> != CorrectArr<Double>
     * Good way - CorrecArr<?>
     * @param ob
     * @return
     */
    boolean sameAvg(CorrecArr<?> ob){
        return getAvg() == ob.getAvg();
    }
}
