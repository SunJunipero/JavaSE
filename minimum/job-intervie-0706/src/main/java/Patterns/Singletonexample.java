package Patterns;

public class Singletonexample {
    public static void main(String[] args) {
        Loger.getLoger().addLogInfo("param 1");
        Loger.getLoger().addLogInfo("param  lolll");
        Loger.getLoger().addLogInfo("param Jordan");
        Loger.getLoger().addLogInfo("param kekkkk");
        Loger.getLoger().show();
    }
}


class Loger{
    private static Loger loger;
    static String log = "log init... \n\n";

    public static Loger getLoger(){
        if (loger == null)
            loger = new Loger();
        return loger;
    }

    private Loger(){}

    public void addLogInfo(String s){
        log += s + "\n";
    }

    public void show(){
        System.out.println(log);
    }


}
