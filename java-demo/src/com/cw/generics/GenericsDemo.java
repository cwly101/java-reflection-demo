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
        // �Ͻ�ͨ���,ֻ����Person��������
        List<? extends Person> list=new ArrayList<Person>();
        // �½�ͨ�����ֻ����Person���丸��
        List<? super Person> list2=new ArrayList<Object>();

        List<Student> students = new ArrayList<>();
        List<User> users = new ArrayList<>();

        // �Ͻ�<? extends T>��������棬ֻ������ȡ
        // list.add(new Student()) // ����ӣ�����

        // �½�<? super T>��Ӱ������棬������ȡֻ�ܷ���Object������
        list2.add(new Person());
        list2.add(new Student());
        list2.add(new User());

        /**
         * Ƶ�������ȡ���ݵģ��ʺ����Ͻ�Extends��
         * �����������ģ��ʺ����½�Super��
         *
         * ���ϣ�https://www.cnblogs.com/zhaoyibing/p/9051428.html
         */
    }
}
