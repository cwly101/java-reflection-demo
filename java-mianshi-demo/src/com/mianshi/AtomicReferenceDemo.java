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
 * AtomicReference 自定义类原子引用示例
 * @author caowei
 * @create 2020/1/29
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        Student tom = new Student("tom",20);
        Student will = new Student("will", 36);

        // 自定义类的原子引用
        AtomicReference<Student> atomicReference = new AtomicReference<>();
        atomicReference.set(tom);

        // 比较并替换操作
        System.out.println("操作结果："+atomicReference.compareAndSet(tom, will)+"\t"+atomicReference.get().toString());
        System.out.println("操作结果："+atomicReference.compareAndSet(tom, will)+"\t"+atomicReference.get().toString());
    }
}
