package GenericMethodReference;

public class CounterClass {
    public static <T> int countVals (T[] vals, T v){
        int count = 0;
        for (T val : vals) {
            if (val.equals(v)) {
                count++;
            }
        }
        return count;
    }
}
