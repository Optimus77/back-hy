package com.hy.backhy.Impl;

import com.hy.backhy.repository.Person;

public class Student implements Person {

    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(this.name);
        System.out.println("50元");
    }

    @Override
    public void giveMoney2() {
        System.out.println("100元");
    }
}
