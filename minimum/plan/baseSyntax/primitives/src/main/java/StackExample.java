public class StackExample {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        Stack stack1 = new Stack(191);
        System.out.println(stack.count + "  " + stack.stack.length + "  " + stack.depth);
        System.out.println(stack1.count + "  " + stack1.stack.length + "  " + stack1.depth);
        stack.push(111);
        stack.push(1131);
        stack.push(11321);
        stack.push(543);
        stack.push(132);
        stack.push(87);
        stack.push(1333);
        stack.push(14324324);
        stack.push(114234324);
        stack.push(1663543);

      //  stack.push(23213213);

        int cnt = 10;
        while (cnt > 0 ){
            System.out.println(stack.pop());
            cnt--;
        }



    }
}
class Stack{
    int depth;
    int[] stack;
    int count = -1;

    Stack(int depth){
        this.depth = depth;
        stack = new int[depth];
    }

    void push(int val){
        if(count == depth - 1){
            System.out.println("Stack is full");
            throw new RuntimeException("Stack is full");
        }
        else{
            System.out.println(this.stack.length);
            this.stack[++count] = val;
        }
        System.out.println( "stack[" + count + "] - " + stack[count] );

    }

    int pop(){
        if(count < 0 ) {
            System.out.println("Stack is empty");
            throw new RuntimeException("Stack is empty");
        }
        else
            return stack[count--];
    }
}
