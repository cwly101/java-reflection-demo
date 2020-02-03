package com.cw;

import java.io.*;

/**
 * 数据流： DataInputStream、DataOutputStream
 * 作用：将（内存中）基本数据类型的变量写入文件中、或读取文件到内存中。
 * 注意：生成的文件不是让直接双击去读取，要使用DataInputStream去读取。
 *
 * 如果要存储对象到文件中，请使用对象流： ObjectOutputStream、ObjectInputStream
 * @author caowei
 * @create 2020/2/2
 */
public class DataStreamDemo {

    public static void main(String[] args)
            throws IOException {

        String path ="java-io-demo"+File.separator+"dir"+File.separator+"data.txt";
//        dataOutputStreamWriteFile(path);

        // 注意：生成的文件不是让直接双击去读取，要使用DataInputStream去读取。
        DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
        // 读取顺序和写入顺序必须一致，不能乱序读取。
        String utf = dis.readUTF();
        System.out.println(utf+","+dis.readInt()+","+dis.readBoolean());
        dis.close();
    }

    /**
     * 将内存中基本类型数据写入到文件
     * @param path
     * @throws IOException
     */
    private static void dataOutputStreamWriteFile(String path) throws IOException {
        // 构造参数：要写出到的文件流
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(path)));
        // 假设有一个User对象（模拟）
        dos.writeUTF("Tom");
        dos.flush();  // 将内容立即写入到文件中并将内存中内容擦除
        dos.writeInt(22);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        // 正式场合请使用try...catch..finally （保证通道被关闭）
        dos.close();
    }
}
