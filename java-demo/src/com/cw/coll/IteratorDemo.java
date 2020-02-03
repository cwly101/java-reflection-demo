package com.cw.coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author caowei
 * @create 2020/1/25
 */
public class IteratorDemo {

    public static void main(String[] args) {
        Collection<User> users = new ArrayList<>();
        users.add(new User("cw",35));
        users.add(new User("will",36));

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){ // 迭代器是否还存在元素
            System.out.println(iterator.next());  // 获取元素
        }

        // 错误的方式。因为每次调用users.iterator()都会返回一个新的Iterator对象。故陷入无限循环。
//        while (users.iterator().hasNext()){
//            System.out.println(users.iterator().next());
//        }
    }
}
