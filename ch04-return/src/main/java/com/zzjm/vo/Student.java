package com.zzjm.vo;

public class Student {
    String name;
    Integer age;

    public Student() {
        System.out.println("这是一个空参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
