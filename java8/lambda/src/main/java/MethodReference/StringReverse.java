package MethodReference;

public class StringReverse {
    static String reverse(String str){
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(reverse("Turner"));
//    }
}
