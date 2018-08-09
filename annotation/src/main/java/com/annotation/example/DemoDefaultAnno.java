package com.annotation.example;

import com.annotation.example.anno.DefaultAnno;

@DefaultAnno
public class DemoDefaultAnno {

    @DefaultAnno(defVal = "initial value")
    public static void method(){
        try {
            DefaultAnno annotation = DemoDefaultAnno.class.getMethod("method").getAnnotation(DefaultAnno.class);
            System.out.println("from method -  " + annotation.defVal());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DemoDefaultAnno demoDefaultAnno = new DemoDefaultAnno();
        DefaultAnno annotation = demoDefaultAnno.getClass().getAnnotation(DefaultAnno.class);
        System.out.println("\t\tdefault value from class");
        System.out.println(annotation.defVal());

        System.out.println("\t\tnon default value from method");
        method();
    }
}
