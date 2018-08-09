package com.annotation.example;

import com.annotation.example.anno.Description;
import com.annotation.example.anno.MyAnno;

import java.lang.annotation.Annotation;

@MyAnno(str = "for class", val = 42)
@Description(desscription = "this is class")
public class DemoGetAllAnnotation {

    @MyAnno(str = "for method", val = 43)
    @Description(desscription = "this is method")
    public static void method(){
        DemoGetAllAnnotation demoGetAllAnnotation = new DemoGetAllAnnotation();

        Annotation[] annotations = demoGetAllAnnotation.getClass().getAnnotations();
        System.out.println("\t\t for class");
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        try {
            Annotation[] annotations1 = demoGetAllAnnotation.getClass().getMethod("method").getAnnotations();
            System.out.println("\t\t for method");
            for (Annotation annotation : annotations1) {
                System.out.println(annotation);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        method();
    }
}
