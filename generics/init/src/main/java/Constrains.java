public class Constrains {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 5, 6 };
        ConstrainsExample<Integer> integerConstrainsExample = new ConstrainsExample<>(12, integers);// ALL OK

        ConstrainsExample<?>[] constrainsExamples = new ConstrainsExample<?>[3];

        constrainsExamples[2] = new ConstrainsExample<>(1222, integers);
        constrainsExamples[1] = new ConstrainsExample<>(122, integers);
        constrainsExamples[0] = new ConstrainsExample<>(12, integers);

        for (int i = 0; i < constrainsExamples.length; i++) {
            System.out.println(constrainsExamples[i].t + " " + constrainsExamples[i].val.length);
        }

        ConstrainsExample<?>[] constrainsExamples1 = new ConstrainsExample[20];

    }
}

class ConstrainsExample < T extends Number>{
    T t;
    T[] val;

    ConstrainsExample(T t, T[] val){
        this.t = t;
        //WRONG
        //this.val = new T[10]; WRONG
        this.val = val;
    }
}

