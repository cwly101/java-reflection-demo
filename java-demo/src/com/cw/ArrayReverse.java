package com.cw;

import java.util.Arrays;

/**
 * @author caowei
 * @create 2020/1/14
 */
public class ArrayReverse {

    public static void main(String[] args) {

        String[] arr = {"jj","dd","mm","bb","gg","aa","qq"};

        // 方式1
//        ArrayReverseWay1(arr);

        // 方式2 (二分法,只需要遍历一半的长度即可。无需考虑数组长度个数奇偶问题，如是奇数，最中间那个保持原样）
//        String first,last = null;
//        for (int i = 0; i < arr.length / 2; i++) {
//            // 取出要对调位置两个元素
//            first = arr[i];
//            last = arr[arr.length -i -1];
//            // 位置对调
//            arr[i] = last;
//            arr[arr.length -i -1] = first;
//        }
//        Arrays.stream(arr).forEach(item -> System.out.print(item + "\t"));

        // 方式3 (和方式2本质上一样)
        for (int i = 0,j = arr.length -1; i < j; i++,j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
        }
        Arrays.stream(arr).forEach(item -> System.out.print(item + "\t"));

    }

    /**
     * 数组反转方式1
     * @param arr
     */
    private static void ArrayReverseWay1(String[] arr) {
        String[] temp =new String[arr.length];
        int index = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            temp[index] = arr[i];
            index ++ ;
        }
        arr = temp;
        temp = null;
        Arrays.stream(arr).forEach(item -> System.out.print(item + "\t"));
    }
}
