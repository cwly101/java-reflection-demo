package com.cw;

/**
 * @author caowei
 * @create 2020/1/17
 */
public class RecursionDemo {

    public static void main(String[] args) {
        RecursionDemo recursionDemo = new RecursionDemo();
        recursionDemo.fibonacci(5);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int fibonacci(int n){
        if(n == 1){
            return 1;  // 停止条件
        }else {
            System.out.println(n);
            return fibonacci(n-1); // 递归
        }
    }
}
