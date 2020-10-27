package com.cjs.scalaLearn.objectLearn;

import java.lang.reflect.Field;

public class JavaObjectTest {
    public static void main(String[] args) throws IllegalAccessException {
//        Son cjs = new Son("cjs1", 11);

        Field[] fields = Son.class.getFields();
//        Field[] declaredFields = Son.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }


    }
}

class Father{

    protected String name = "cjs";
    protected int age;

    Father(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Son extends Father{
    public Son(String name, int age) {
        super(name, age);
    }
}