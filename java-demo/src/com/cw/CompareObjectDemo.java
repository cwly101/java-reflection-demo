package com.cw;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {

    private String stuNo;
    private int score;

    public Student(String stuNo, int score) {
        this.stuNo = stuNo;
        this.score = score;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * this大于形参返回 正整数
     * this小于形参返回 负数
     * this等于形参返回 零
     * @param student
     * @return
     */
    @Override
    public int compareTo(Student student) {
        // 我采用固定泛型类为Student的方式，如果不指定泛型类，默认为Object。
        // 在内部需要借助instanceof判断一下形参的类型。如果类型不对，还需要进一步处理。不如固定了形参的泛型类型。

        /*int result = 0;
        if(this.getScore() > student.getScore())
            result = 1;
        else if(this.getScore() < student.getScore())
            result = -1;
        return result;*/
        // 如果不允许相等，相等还要进行二级判断，那就建议用上边自定义重写的方式。等于0时，在再一步写判断逻辑。
        return Integer.compare(this.getScore(),student.getScore());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", score=" + score +
                '}';
    }
}

/**
 * @author caowei
 * @create 2020/1/21
 */
public class CompareObjectDemo {

    public static void main(String[] args) {

        Student stu1 = new Student("No.202",356);
        Student stu2 = new Student("No.301",386);
        Student stu3 = new Student("No.199",301);

        Student[] students = {stu1,stu2,stu3};

        // 排序方式1：对象实现Comparable接口的普通排序方式
        // Arrays.sort(students);

        // 排序方式2：Comparator接口的匿名实现类方式实现定制化排序
        // 这是非侵入式的排序实现方式，在不改动源代码的基础上实现，推荐！！
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 倒序排序（从大到小）。 前面加一个“-”负号。 负负得正，正变成负。
                return -o1.getStuNo().compareTo(o2.getStuNo());
            }
        });

        System.out.println(Arrays.toString(students));

    }
}
