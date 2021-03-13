package com.cjs.scalaAdvanceLearn.chapter2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person cjs = new Person("cjs", 10);
        Class<? extends Person> aClass = cjs.getClass();
        Constructor<? extends Person> constructor = aClass.getDeclaredConstructor(String.class, int.class);
        Person cys = constructor.newInstance("cys", 20);
        System.out.println(cys);
    }
}

class Person {
    private String name;
    private int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}