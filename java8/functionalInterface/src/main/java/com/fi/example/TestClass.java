package com.fi.example;

import java.util.Random;

public class TestClass {
    private Integer val;

    public TestClass(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public boolean lessThan (){
        return this.val > 50;
    }

    public void forConsumer(){
        //testClass.val = testClass.val * 10;
        this.val *=10;
    }

    public Integer add100(){
        return this.val + 100;
    }

    public TestClass changeVal(){
        this.val += 20;
        return this;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "val=" + val +
                '}';
    }
}
