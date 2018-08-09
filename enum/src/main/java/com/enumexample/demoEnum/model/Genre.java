package com.enumexample.demoEnum.model;


public enum Genre{
    GENRE1("RnB"), GENRE2, GENRE3("House");

    String name;

    Genre (String name){
        this.name = name;
    }

    Genre(){
    }

    public String getName(){
        return this.name;
    }
}
