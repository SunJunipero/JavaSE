package com.annotation.example;

import com.annotation.example.anno.MyAnno;

import java.lang.reflect.Method;

public class DemoAnnoParamMethod {
    @MyAnno(str = "looool", val = 101)
    public static void MyParamMethod(String str, int val){
        DemoAnnoParamMethod demoAnnoParamMethod = new DemoAnnoParamMethod();
        Class<?> aClass = demoAnnoParamMethod.getClass();

        try {
            Method method = aClass.getMethod("MyParamMethod", String.class, int.class);
            MyAnno myAnno = method.getAnnotation(MyAnno.class);
            System.out.println(myAnno.str() + "  " + myAnno.val());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyParamMethod("kekkk", 43);
    }
}
