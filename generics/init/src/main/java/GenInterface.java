public class GenInterface {
    public static void main(String[] args) {
        Integer[] integers = {12, -23, 0, 72, 5, 2, -1};
        MinMax<Integer> tMinMax = new MinMaxClass<>(integers);
        System.out.println(tMinMax.max());
        System.out.println(tMinMax.min());
    }
}

interface MinMax<T extends Comparable<T>>{
    T max();
    T min();
}

class MinMaxClass <T extends Comparable<T>> implements MinMax<T>{
    T[] arr;

    MinMaxClass(T[] arr){
        this.arr = arr;
    }
    @Override
    public T max() {
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(max) > 0 )
            {
                System.out.println("max " + arr[i].compareTo(max));
            max = arr[i];
            }
        }
        return max;
    }

    @Override
    public T min() {
        T min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(min) < 0 ) {
                System.out.println("min " + arr[i].compareTo(min));
                min = arr[i];
            }
        }
        return min;
    }
}
