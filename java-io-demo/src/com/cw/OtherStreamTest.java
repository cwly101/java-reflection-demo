package com.cw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ��׼�����롢�����
 * InputStream ��׼������
 * OutputStream ��׼�����
 * @author caowei
 * @create 2020/2/1
 */
public class OtherStreamTest {

    public static void main(String[] args) throws IOException {

        // ����һ��ʹ��Scannerʵ�֣�����.next()������ȡ��������ݡ��ײ���õ�System.in
        // ��������ʹ��System.inʵ�֡�System.in���ص����ֽ�����ͨ��ת��������ַ�����
        //        System.in ---> ת���� ---> BufferedReader

        /**
         * System.in ���صľ��� InputStream
         * System.out ���صľ��� OutputStream
         * ת����
         * InputStreamReader OutputStreamWriter
         */
        InputStream in = System.in;  // ������
        InputStreamReader isr = new InputStreamReader(in);  // ת������������ת�������ֽ�ת��Ϊ�ַ���
        BufferedReader reader = new BufferedReader(isr);  // �ַ�������
        // BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));  // �����д��ʽ

        System.out.println("�������ַ������س��ύ����");
        while (true){
            String input = reader.readLine();  // ��ȡ����
            // ���齫���Ƚϵ����ݷ���ǰ������һ���̶��Ǳ����ָ���쳣��
            if("e".equalsIgnoreCase(input)){
                System.out.println("�����˳�");
                break;
            }
            System.out.println(input.toUpperCase());
        }

        // ��ʽ������ʹ��try..catch..finally��֤��ͨ�����ر�
        reader.close();

//        Integer integer = Integer.valueOf("11");
//        Long num = Long.valueOf("290");
//        Integer.parseInt("33");
    }
}
