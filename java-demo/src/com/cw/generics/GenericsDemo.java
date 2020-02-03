package com.cw.generics;

import java.util.ArrayList;
import java.util.List;

class Person{

}

class Student extends Person{}

class User extends Person{}

/**
 * @author caowei
 * @create 2020/1/30
 */
public class GenericsDemo {

    public static void main(String[] args) {
        // 上界通配符,只能是Person或其子类
        List<? extends Person> list=new ArrayList<Person>();
        // 下界通配符，只能是Person或其父类
        List<? super Person> list2=new ArrayList<Object>();

        List<Student> students = new ArrayList<>();
        List<User> users = new ArrayList<>();

        // 上界<? extends T>不能往里存，只能往外取
        // list.add(new Student()) // 想添加，错误！

        // 下界<? super T>不影响往里存，但往外取只能放在Object对象里
        list2.add(new Person());
        list2.add(new Student());
        list2.add(new User());

        /**
         * 频繁往外读取内容的，适合用上界Extends。
         * 经常往里插入的，适合用下界Super。
         *
         * 资料：https://www.cnblogs.com/zhaoyibing/p/9051428.html
         */
    }
}
