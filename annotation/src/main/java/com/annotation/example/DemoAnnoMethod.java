package com.annotation.example;

import com.annotation.example.anno.MyAnno;

import java.lang.reflect.Method;

public class DemoAnnoMethod {
    @MyAnno(str = "from my Anno", val = 42)
    public static void MyMethod(){
        DemoAnnoMethod method = new DemoAnnoMethod();

        try {
            Class<?> aClass = method.getClass();
            Method myMethod = aClass.getMethod("MyMethod");
            MyAnno annotation = myMethod.getAnnotation(MyAnno.class);

            System.out.println(annotation.str() + "  " + annotation.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyMethod();
    }

}
