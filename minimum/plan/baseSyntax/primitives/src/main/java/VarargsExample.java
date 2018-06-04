public class VarargsExample {
    public static void main(String[] args) {
        Varargs.test(1);
        Varargs.test();
        String s = "\r\n\t\"\\";
        System.out.println(s);
        //'\t' + '\u0003'
        char t = '\t';
        char c =  '\u0003';
        System.out.println((int)c + "  " + (int)t);
        System.out.println(t + c);

    }
}

class Varargs{
    int lol;
    int[] kek;

    static void test(){

    }
    static void test (boolean... booleans){
        System.out.println("from test of booleans");
    }

    static void test (int... ints){
        System.out.println("from test of ints");
    }

    static void test (int val){
        System.out.println("from test of int");
    }
    static void test (int val, int ... vals){
        System.out.println("from test of int  and vals");
    }


}

class subVarargs extends Varargs{
    static void test1(int... ints){
        System.out.println("from sub varargs");
    }


}
