package com.annotation.example;

import com.annotation.example.anno.MyMarker;

import java.lang.reflect.Method;

public class DemoAnnotationMarker {
    @MyMarker
    public static void method(){
        try {
            Method method = DemoAnnotationMarker.class.getMethod("method");

            if (method.isAnnotationPresent(MyMarker.class)) {
                System.out.println("marker annotation is present");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method();
    }
}
