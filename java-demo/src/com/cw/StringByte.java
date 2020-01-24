package com.cw;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author caowei
 * @create 2020/1/19
 */
public class StringByte {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中文编码成byte";

        // 编码
        byte[] bytes = str.getBytes("gbk"); //默认是utf-8，这里手动设置为gbk
        System.out.println(Arrays.toString(bytes));  // 编码后输出

        System.out.println("========");

        // 解码
        String str_decoding = new String(bytes,"gbk");  // 解码需要和编码字符集一致
        System.out.println(str_decoding);

    }
}
