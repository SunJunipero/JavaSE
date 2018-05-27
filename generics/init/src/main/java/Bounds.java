public class Bounds {
    public static void main(String[] args) {
        Integer[] nums = {1,24, 45, 64, 1110};
        System.out.println(new CorrecArr<Integer>(nums).getAvg());
    }
}

class Arr <T>{
    T[] arr;

    Arr(T[] arr){
        this.arr = arr;
    }

    /**
     * Compile error in 19 line, doubleValue - can nor resolve method
     * @return
     */
    public double average(){
        double avg = 0;
        double sum = 0;
        for (T t : arr) {
          //  sum += t.doubleValue();
        }

        return sum / arr.length;
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
}
