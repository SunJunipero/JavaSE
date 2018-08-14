package InstanceMethWithObjRef;

public class TemperatureCalc {
    int highTemp;

    TemperatureCalc(int highTemp){
        this.highTemp = highTemp;
    }

    boolean sameTemp(TemperatureCalc temp){
        return highTemp == temp.highTemp;
    }

    boolean lowTemp(TemperatureCalc temp){
        return highTemp < temp.highTemp;
    }
}
