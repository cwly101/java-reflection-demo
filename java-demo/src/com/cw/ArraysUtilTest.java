package com.cw;

import java.util.Arrays;

/**
 * java.util.Arrays:操作数组的工具类
 *
 * @author caowei
 * @create 2020/1/16
 */
public class ArraysUtilTest {

    public static void main(String[] args) {

        int[] arr_a = {2,4,6,8};
        int[] arr_b = {2,8,6,4};

        // 是否相等
        boolean equals = Arrays.equals(arr_a, arr_b);
        System.out.println(equals);

        // 排序。底层使用的快速排序。
        Arrays.sort(arr_b);

        // 填充, 指定值将替换数组中的所有值
        Arrays.fill(arr_b,88);

        // 输出数组元素信息，无需遍历了。
        String arr_print = Arrays.toString(arr_b);
        System.out.println(arr_print);

        // 二分查找前提：数据一定是有序的。可以先排序，再查找。
        int[] arr_search = {-5,7,31,51,59,87,96,153,300};
        int index = Arrays.binarySearch(arr_search, 153);
        System.out.println(index);

        /**
         * 数组中的常见异常：
         * 1. 数组角标越界异常： ArrayIndexOutOfBoundsException
         * 2. NullPointerException
         */
    }
}
