package com.example.model;

/**
 * Created by MOMO on 2017/3/9.
 */
public class Result {
    String value;
    String name;

    public Result( String name,String value) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
