package CommonLambda;

public class Example {
    public static void main(String[] args) {
        CommonFi commonFi = Integer::parseInt;

        System.out.println(commonFi.getNumber("4545"));

        commonFi = Double::parseDouble;

        System.out.println(commonFi.getNumber("545.43"));
    }
}
