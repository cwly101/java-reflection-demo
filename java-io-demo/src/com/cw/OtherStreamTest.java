package com.cw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 标准的输入、输出流
 * InputStream 标准输入流
 * OutputStream 标准输出流
 * @author caowei
 * @create 2020/2/1
 */
public class OtherStreamTest {

    public static void main(String[] args) throws IOException {

        // 方法一：使用Scanner实现，调用.next()方法获取输入的数据。底层调用的System.in
        // 方法二：使用System.in实现。System.in返回的是字节流，通过转换流变成字符流。
        //        System.in ---> 转换流 ---> BufferedReader

        /**
         * System.in 返回的就是 InputStream
         * System.out 返回的就是 OutputStream
         * 转换流
         * InputStreamReader OutputStreamWriter
         */
        InputStream in = System.in;  // 输入流
        InputStreamReader isr = new InputStreamReader(in);  // 转换流。（经由转换流将字节转换为字符）
        BufferedReader reader = new BufferedReader(isr);  // 字符输入流
        // BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));  // 上面简写形式

        System.out.println("请输入字符串（回车提交）：");
        while (true){
            String input = reader.readLine();  // 获取数据
            // 建议将被比较的数据放在前，可以一定程度是避免空指针异常。
            if("e".equalsIgnoreCase(input)){
                System.out.println("程序退出");
                break;
            }
            System.out.println(input.toUpperCase());
        }

        // 正式场合请使用try..catch..finally保证流通道被关闭
        reader.close();

//        Integer integer = Integer.valueOf("11");
//        Long num = Long.valueOf("290");
//        Integer.parseInt("33");
    }
}
