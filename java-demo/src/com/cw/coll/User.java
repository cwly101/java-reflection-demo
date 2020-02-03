package com.cw.coll;

import java.util.Objects;

/**
 * @author caowei
 * @create 2020/1/25
 */
public class User {

    private String name;
    private int age;

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

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 默认是比较引用地址。如果期望按指定的方式比较，请重写equals()方法.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        System.out.println("对象比较,调用equals()...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
