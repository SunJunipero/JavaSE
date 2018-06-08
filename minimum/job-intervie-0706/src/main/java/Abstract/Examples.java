package Abstract;

public class Examples {
}


abstract class A{
    private void print1(){
        System.out.println("private void print1()");
    }

    protected void print2(){
        System.out.println("System.out.println(\"private void print1()");
    }

    abstract void lol();
}

class B extends A{
    @Override
    void lol() {
        System.out.println("lol implements");
    }

    protected void print2(){
        System.out.println("System.out.println(\"private void print1()");
    }


}
