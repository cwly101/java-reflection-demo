package com.cw.coll;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author caowei
 * @create 2020/1/26
 */
public class SetDemo {

    public static void main(String[] args) {

        /**
         * Set<T>接口，无序的、不可重复数据的列表
         * 实现类： HashList、LinkedHashList、TreeSet
         *
         * TreeSet特点：
         * 1. 存储的对象类型必要一致（因为不同类型无法排序）
         * 2. 必需实现Comparable接口 （这个TreeSet才能根据Comparable实现自然排序）
         * 3. 如果要实现定制排序，TreeSet构造函数需要传入一个Comparator接口的实现对象。
         */

        // TreeSet 定制化排序实现示例
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compare = o1.getName().compareTo(o2.getName());
                if(compare == 0){
                     return Integer.compare(o1.getAge(),o2.getAge());
                }
                return compare;
            }
        };

        Set<User> users = new TreeSet<>(comparator);
        users.add(new User("will",31));
        users.add(new User("cw",35));
        users.add(new User("will",53));
        users.add(new User("tom",35));

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
