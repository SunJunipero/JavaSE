package com.annotation.example;

import com.annotation.example.anno.Container;
import com.annotation.example.anno.RepeatAnno;

import java.lang.reflect.Method;

public class DemoRepeatAnno {
    @RepeatAnno(str = "one time", getInt = 121)
    @RepeatAnno(str = "two time", getInt = 122)
    public static void method(){
        try {
            Method method = DemoRepeatAnno.class.getMethod("method");
            RepeatAnno[] annotationsByType = method.getAnnotationsByType(RepeatAnno.class);
            for (RepeatAnno container : annotationsByType) {
                System.out.println(container);
                System.out.println(container.str() + "  " + container.getInt() );
                System.out.println("---");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method();
    }
}
