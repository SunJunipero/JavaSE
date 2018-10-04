package checkedUncheked;

import java.io.IOException;

public class PessimistWayDemo {
    /**
     * throws required ( >= throw Exception)
     *
     *  + public static void main(String[] args) throws Exception
     *  - public static void main(String[] args) throws IOException
     *  + public static void main(String[] args) throws Throwable
     *
     *  --------------------------------------------------------
     *
     *  we may just scare
     *   private static void boo() throws Exception{
     *
     *     }
     *
     *
     */
    public static void main(String[] args) throws Throwable {
        if (true)throw new Exception();

        boo();
    }

    private static void boo() throws Exception{

    }

}
