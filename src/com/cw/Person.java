package com.cw;

import java.lang.annotation.Native;

/**
 * @author caowei
 * @create 2020/1/11
 */
public class Person {

    private String name;
    private int age;
    public int id;

    public Person() {
        this("小青蛙",1);  // 构造函数中调用其它构造函数，必须写在第一行。
        System.out.println("Person() 默认无参构造");
    }

    public Person(String name, int age) {
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

    private String show(String country){
        return "我来自："+ country;
    }

    private static void message(){
        System.out.println("我是一个java程序员");
    }

}
