package subclasses;

public class Example {
    public static void main(String[] args) {
        /**
         * A a = new A();
         */
        A a = new A(1 , "A a = new A()");
        a.printString();

        /**
         * A a1 = new B();
         */
        A a1 = new B(1, "A a1 = new B()");
        a1.printString();
        ((B) a1).specialForB();
        /**
         * B b = new A();
         */
        //B b = ((B) new A(1, "B b = new A()")); //class cast exception here
        //b.printInt();
        /**
         * B b1 = new B();
         */
        B b1 = new B(1, "B b1 = new B()");
        b1.specialForB();



    }
}

class A {
    int i;
    String s;

    A(int i, String s){
        this.i = i;
        this.s = s;
    }

    int printInt(){
        System.out.println("printInt from A");
        return i;
    }

    String printString(){
        System.out.println("printString from A");
        return s;
    }
}

class B extends A {
    B(int i, String s) {
        super(i, s);
    }

    void specialForB(){
        System.out.println("specialForB");
    }

    String printString() {
        {
            System.out.println("printString from B");
            return s;
        }
    }
}
