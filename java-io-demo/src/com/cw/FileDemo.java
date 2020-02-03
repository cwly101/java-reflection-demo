package com.cw;

import java.io.File;
import java.io.IOException;

import static java.io.File.separator;

/**
 * @author caowei
 * @create 2020/1/30
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

        // ����Ŀ¼
        //File file = new File("java-io"+separator+"dir");  // ������Ĺ���һ����
//        File dir = new File("java-io-demo","dir");
//        boolean mkdirs = dir.mkdirs();  // Ŀ¼���ڲ�����������false
//        if(mkdirs){
//            System.out.println(dir.getAbsolutePath()+" �������");
//        }
//
//
//        // �����ļ�  1.txt
//        File file = new File("java-io-demo"+separator+"dir","1.txt");
//        if(!file.exists()){
//            boolean create = file.createNewFile();
//            System.out.println(file.getAbsolutePath()+" �������");
//        }
//
//        // �����ļ�  2.txt
//        File file2 = new File("java-io-demo"+separator+"dir","2.txt");
//        if(!file2.exists()){
//            boolean create = file2.createNewFile();
//            System.out.println(file2.getAbsolutePath()+" �������");
//        }
//
//        // �����ļ�  pic.jpg
//        File file_jpg = new File("java-io-demo"+separator+"dir","pic.jpg");
//        if(!file_jpg.exists()){
//            boolean create = file_jpg.createNewFile();
//            System.out.println(file_jpg.getAbsolutePath()+" �������");
//        }

        // ɾ��ָ���ļ� 2.txt
//        if (file2.delete()) {
//            System.out.println(file2.getName()+" ɾ���ɹ�");
//        }

        // ����ָ��Ŀ¼�µ������ļ�
        // �������ļ�����string[]����
//        for (String s : dir.list()) {
//            boolean b = s.endsWith(".jpg");   // �Ƿ����ָ���ĺ�׺��
//            System.out.println(s+"\t"+(b?"ͼƬ�ļ�":""));
//        }

        // Ŀ¼������Ŀ¼�����������ļ�
        FileDemo fileDemo = new FileDemo();
        fileDemo.dirFileList("java-io-demo"+separator+"dir");
    }


    /**
     * �ݹ��ȡ��ǰĿ¼�������ļ�����Ŀ¼�����ļ�
     * @param path
     */
    public void dirFileList(String path){
        File dir = new File(path);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {  // �Ƿ��Ǹ�Ŀ¼
                System.out.println(file.getName()+"\t ��Ŀ¼");
                //System.out.print("\t");
                dirFileList(file.getAbsolutePath());
            }else {
                System.out.println(file.getName()+"\t��С��"+file.length()); // .length()�ļ��ĳ���
            }
        }
        // ˵����ɾ��Ҳ���õݹ顣�ǿյ�Ŀ¼������ɾ������ʹ��windows��ɾ���������ڲ�Ҳ�ǵݹ顣
    }
}
