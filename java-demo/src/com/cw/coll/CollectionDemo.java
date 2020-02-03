package com.cw.coll;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author caowei
 * @create 2020/1/25
 */
public class CollectionDemo {

    public static void main(String[] args) {
        /**
         * 向Collection接口的实现类（如ArrayList）添加对象时，要求重写被添加对象类的equals方法，
         * 因为比较集合中的两个对象是否相等时，会调用对象类的equals()方法进行比较。
         */
        Collection<User> users = new ArrayList<>();
        users.add(new User("用户A",32));

        System.out.println(users.size());
        boolean contains = users.contains(new User("用户A", 32));
        System.out.println(contains);

        System.out.println(users); // 相当于调用集合中每个对象的toString()方法。
        // 删除也会调用equals()方法。相等才删除。
        boolean remove = users.remove(new User("用户A", 32));
        System.out.println(remove);
    }
}
