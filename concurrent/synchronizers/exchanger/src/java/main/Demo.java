public class Demo {
    public static void main(String[] args) {
        String s = "";

        char ceed = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                s+=((char) ceed++);
            }
            System.out.println(s);
            s="";
        }
    }
}
