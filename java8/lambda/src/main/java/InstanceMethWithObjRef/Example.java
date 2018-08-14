package InstanceMethWithObjRef;

public class Example {

    static <T> int tempCounter (T[] temps, FuncInt<T> f, T val){
        int count = 0;
        for (T temp : temps) {
            if (f.func(temp, val)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TemperatureCalc[] temps1 = {new TemperatureCalc(55),
                new TemperatureCalc(32), new TemperatureCalc(21),
                new TemperatureCalc(25), new TemperatureCalc(37),
                new TemperatureCalc(21), new TemperatureCalc(28),
                new TemperatureCalc(21), new TemperatureCalc(51)};

        System.out.println(tempCounter(temps1, TemperatureCalc::lowTemp, new TemperatureCalc(50)));
        System.out.println(tempCounter(temps1, TemperatureCalc::sameTemp, new TemperatureCalc(21)));



    }
}
