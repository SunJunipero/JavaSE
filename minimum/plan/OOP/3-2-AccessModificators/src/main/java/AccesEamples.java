public class AccesEamples {
    public static void main(String[] args) {
        SubExample subExample = new SubExample(12);
        System.out.println(subExample.i + "  " + subExample.a);

        subExample.Test(12);

    }
}

class SuperExample{
    int i;

    SuperExample(int i ){
        this.i = i;
    }

    /**
     * may be static
     */
    private void Test(){
        System.out.println("private void test");
    }
/**
 * Exception - test already defined
 */
//    private int Test(int i){
//        System.out.println("private void test");
//        return 23;
//    }
    /**
     * may be static
     */
    protected void Test(int i){
        System.out.println("protected void Test(int i)");
    }
    /**
     * may be static
     */
    void  Test(String s){
        System.out.println("void Test(String s)");
    }
    /**
     * may be static
     */
    public void Test (Object ob){
        System.out.println("public void Test (Object ob)");
    }
    /**
     * Exception - already defined
     */
//    public void Test (Object ob){
//        System.out.println("public void Test (Object ob)");
//    }
    String getString(String s){
        return s + " lol";
    }
}

class SubExample extends SuperExample{

    int a = i + 100;
    SubExample (int i){
        super(i);
    }

   private void Test(){
       System.out.println("private void Test() from SUBCLASS");
   }

   public void Test(int i){
       System.out.println(" protected void Test(int i) from SUBCLASS");
   }



}
