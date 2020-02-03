package com.cw.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author caowei
 * @create 2020/1/26
 */
public class ListDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 5, 1, 5, 3, 3, 3, 1);
        List list = duplicateList(integers);
        for(Object i:list){
            System.out.println(i);
        }
    }


    /**
     * 集合过滤掉重复数据
     * @param list
     * @return
     */
    private static List duplicateList(List list){
        // HashSet是无序集合、不可重复数据
        // 注：如果是自定义的对象，请重写equals()、hashCode()方法，这样才能比较出相同的对象。
        HashSet set = new HashSet();
        set.addAll(list);  // 自然会过滤掉传入集合中存在的重复数据
        return new ArrayList(set);
    }


    /**
     * 【特别注意】
     * HashSet中存放的对象数据，是按照最初存入时的值，计算对应的Hash值（存放位置）的，
     * 如果中途修改了对象中的值，对象对应的Hash值是不会变的。这时，你企图删除修改后的对象，
     * 那么HashSet是按照新值来的计算Hash值（对象存放位置）的，然后去这个位置删除对象。
     * 但是，这个位置并不存在对象，这就造成想删除的对象删除不掉了。
     */
}
