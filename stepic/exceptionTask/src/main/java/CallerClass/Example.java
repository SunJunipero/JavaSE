package CallerClass;

public class Example {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1(){
        System.out.println(getCallerClassAndMethodName());
    }


    static String getCallerClassAndMethodName() {
            NullPointerException nullPointerException = new NullPointerException();
            StackTraceElement[] stackTrace = nullPointerException.getStackTrace();
        if (stackTrace.length < 3)
            return null;
        return stackTrace[2].getClassName()+"#"+stackTrace[stackTrace.length - 1].getMethodName();
    }
}
