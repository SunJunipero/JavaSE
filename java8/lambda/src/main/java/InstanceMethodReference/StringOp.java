package InstanceMethodReference;

public class StringOp {
    public String reverse(String str){
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    public String replaceAllAtoX(String str){
       return str.replace("O", "X");
    }
}
