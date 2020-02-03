package com.mianshi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@AllArgsConstructor
@ToString
class Student{

    private String name;
    private Integer age;

}

/**
 * AtomicReference �Զ�����ԭ������ʾ��
 * @author caowei
 * @create 2020/1/29
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        Student tom = new Student("tom",20);
        Student will = new Student("will", 36);

        // �Զ������ԭ������
        AtomicReference<Student> atomicReference = new AtomicReference<>();
        atomicReference.set(tom);

        // �Ƚϲ��滻����
        System.out.println("���������"+atomicReference.compareAndSet(tom, will)+"\t"+atomicReference.get().toString());
        System.out.println("���������"+atomicReference.compareAndSet(tom, will)+"\t"+atomicReference.get().toString());
    }
}
