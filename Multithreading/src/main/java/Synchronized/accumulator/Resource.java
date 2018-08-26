package Synchronized.accumulator;

public class Resource {
    private int i;

    public Resource(int i){
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public synchronized void changeI(){
        /**
         * or may synchronized(this){
         *      int i = this.i;
         *         i++;
         *         this.i = i;
         * }
         */
        int i = this.i;
        i++;
        this.i = i;
    }
}
