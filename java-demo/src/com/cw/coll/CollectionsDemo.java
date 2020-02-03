package com.cw.coll;

import java.util.*;

/**
 * Collections 工具类的使用
 * @author caowei
 * @create 2020/1/27
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(33, 66, 9, 101,55,19);
//        Collections.reverse(list);  // 反转list集合顺序
//        Collections.shuffle(list);  // 对list集合进行随机排序

        // 对list集合根据Comparator接口实现进行定制排序 （这里采用降序）。 也可以自然排序，要排序的类对象所在类请实现comparable接口
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -Integer.compare(o1,o2);
//            }
//        });

//        Collections.swap(list,2,5);  // 对集合中两个指定索引位置处元素互换位置。

//        Integer max = Collections.max(list);  // 按自然排序返回集合中最大的元素。也可以按定制排序，实现Comparator接口。返回最小同理，用min()
//        System.out.println(max);

//        int frequency = Collections.frequency(list, 19);  // 返回给定元素在集合中出现的次数。也得实现Comparable接口。
//        System.out.println("出现次数："+frequency);

        //将第二参数集合的值，复制到第一个集合中。注意：会覆盖集合原来的值，从索引0位置开始覆盖。
        // 注意使用场景。一般用于临时存放到一个空集合中。  Arrays.asList(5,66,516)
//        List<Object> list2 = new ArrayList<>(6);
//        System.out.println(list2);  // 输出：[]
//        /**
//         * 注意：这样写不行，会抛 IndexOutOfBoundsException。因为空集合没有填充任何数据，索引不存在。
//         * copy()方法内部，是根据索引值，一个一个替换的。空集合（空数组）索引自然不存在。
//         */
//        Collections.copy(list2,list);
//        List<Object> objects = Arrays.asList(new Object[list.size()]); // 创建一个指定长度空数组，向集合填充时，会以null填充
//        System.out.println(objects); // 输出：[null, null, null, null, null, null]
//        Collections.copy(objects,list);

        // 将集合转换成一个线程安全的集合。ArrayList是非线程安全的。Arrays.asList()内部返回的就是一个ArrayList对象。
        List<Integer> list1 = Collections.synchronizedList(list);

        System.out.println(list);
    }
}
