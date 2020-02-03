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

        // 创建目录
        //File file = new File("java-io"+separator+"dir");  // 与下面的构造一样。
//        File dir = new File("java-io-demo","dir");
//        boolean mkdirs = dir.mkdirs();  // 目录存在不创建，返回false
//        if(mkdirs){
//            System.out.println(dir.getAbsolutePath()+" 创建完成");
//        }
//
//
//        // 创建文件  1.txt
//        File file = new File("java-io-demo"+separator+"dir","1.txt");
//        if(!file.exists()){
//            boolean create = file.createNewFile();
//            System.out.println(file.getAbsolutePath()+" 创建完成");
//        }
//
//        // 创建文件  2.txt
//        File file2 = new File("java-io-demo"+separator+"dir","2.txt");
//        if(!file2.exists()){
//            boolean create = file2.createNewFile();
//            System.out.println(file2.getAbsolutePath()+" 创建完成");
//        }
//
//        // 创建文件  pic.jpg
//        File file_jpg = new File("java-io-demo"+separator+"dir","pic.jpg");
//        if(!file_jpg.exists()){
//            boolean create = file_jpg.createNewFile();
//            System.out.println(file_jpg.getAbsolutePath()+" 创建完成");
//        }

        // 删除指定文件 2.txt
//        if (file2.delete()) {
//            System.out.println(file2.getName()+" 删除成功");
//        }

        // 遍历指定目录下的所有文件
        // 仅包含文件名的string[]数组
//        for (String s : dir.list()) {
//            boolean b = s.endsWith(".jpg");   // 是否包含指定的后缀名
//            System.out.println(s+"\t"+(b?"图片文件":""));
//        }

        // 目录及其子目录包含的所有文件
        FileDemo fileDemo = new FileDemo();
        fileDemo.dirFileList("java-io-demo"+separator+"dir");
    }


    /**
     * 递归读取当前目录下所有文件及子目录所有文件
     * @param path
     */
    public void dirFileList(String path){
        File dir = new File(path);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {  // 是否是个目录
                System.out.println(file.getName()+"\t 子目录");
                //System.out.print("\t");
                dirFileList(file.getAbsolutePath());
            }else {
                System.out.println(file.getName()+"\t大小："+file.length()); // .length()文件的长度
            }
        }
        // 说明：删除也得用递归。非空的目录不允许删除。即使是windows的删除操作，内部也是递归。
    }
}
