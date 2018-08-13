package com.annotation.example.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SingleAnno {
    /**
     * only VALUE name
     */
    int value();
    /**
     * may add one and more field, BUT this filed
     * must have default value
     *
     * inr anotherField() default 232;
     */
}
