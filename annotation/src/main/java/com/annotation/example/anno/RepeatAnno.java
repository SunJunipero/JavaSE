package com.annotation.example.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Container.class)
public @interface RepeatAnno {
    String str();
    int getInt();
}


