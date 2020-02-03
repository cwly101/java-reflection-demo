package com.cw;

import java.io.*;

/**
 * �������� DataInputStream��DataOutputStream
 * ���ã������ڴ��У������������͵ı���д���ļ��С����ȡ�ļ����ڴ��С�
 * ע�⣺���ɵ��ļ�������ֱ��˫��ȥ��ȡ��Ҫʹ��DataInputStreamȥ��ȡ��
 *
 * ���Ҫ�洢�����ļ��У���ʹ�ö������� ObjectOutputStream��ObjectInputStream
 * @author caowei
 * @create 2020/2/2
 */
public class DataStreamDemo {

    public static void main(String[] args)
            throws IOException {

        String path ="java-io-demo"+File.separator+"dir"+File.separator+"data.txt";
//        dataOutputStreamWriteFile(path);

        // ע�⣺���ɵ��ļ�������ֱ��˫��ȥ��ȡ��Ҫʹ��DataInputStreamȥ��ȡ��
        DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
        // ��ȡ˳���д��˳�����һ�£����������ȡ��
        String utf = dis.readUTF();
        System.out.println(utf+","+dis.readInt()+","+dis.readBoolean());
        dis.close();
    }

    /**
     * ���ڴ��л�����������д�뵽�ļ�
     * @param path
     * @throws IOException
     */
    private static void dataOutputStreamWriteFile(String path) throws IOException {
        // ���������Ҫд�������ļ���
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(path)));
        // ������һ��User����ģ�⣩
        dos.writeUTF("Tom");
        dos.flush();  // ����������д�뵽�ļ��в����ڴ������ݲ���
        dos.writeInt(22);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        // ��ʽ������ʹ��try...catch..finally ����֤ͨ�����رգ�
        dos.close();
    }
}
