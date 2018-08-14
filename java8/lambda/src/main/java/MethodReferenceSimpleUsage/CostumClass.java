package MethodReferenceSimpleUsage;

public class CostumClass implements Comparable<CostumClass> {
    int val;

    public CostumClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(CostumClass costumClass) {
        return val - costumClass.val;
    }
}
