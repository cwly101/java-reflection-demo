package com.cw;

import java.io.*;

import static java.io.File.separator;

/**
 * 文件操作类
 */
class FileOperation {

    /**
     * 文本文件复制
     * 注：读取的是字符
     * @param file     要复制的文本文件路径和文件名称
     * @param destFile 要复制到的目标位置及新名称
     */
    public boolean textFileCopy(String file, String destFile) {
        boolean isOk = false;

        File file1 = new File(file);
        File file2 = new File(destFile);

        Reader fr = null;
        Writer fw = null;
        try {
            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] char_buffer = new char[64];
            int len;
            while ((len = fr.read(char_buffer)) != -1) {
                String content = new String(char_buffer, 0, len);
                fw.write(content);
            }
            isOk = true;
        } catch (IOException e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return isOk;
    }


    /**
     * 文本文件复制（通过包装流的形式）
     * 注：读取的是字符
     * @param file     要复制的文本文件路径和文件名称
     * @param destFile 要复制到的目标位置及新名称
     * @return
     */
    public boolean textFileCopyByFileStream(String file, String destFile) {
        boolean isOk = false;

        File file1 = new File(file);
        File file2 = new File(destFile);

        Reader br = null;
        Writer bw = null;
        try {
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            char[] cbuff = new char[64];
            int len;
            while ((len = br.read(cbuff)) != -1) {
                String content = new String(cbuff, 0, len);
                bw.write(content);
            }
            isOk = true;
        } catch (IOException e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return isOk;
    }


    /**
     * 非文本文件的复制
     * 注：读取是字节
     * @param file     要复制的文本文件路径和文件名称
     * @param destFile 要复制到的目标位置及新名称
     * @return
     */
    public boolean notTextFileCopy(String file, String destFile) {
        boolean isOk = false;

        File file1 = new File(file);
        File file2 = new File(destFile);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] b = new byte[128];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            isOk = true;
        } catch (IOException e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return isOk;
    }

    /**
     * 非文本文件的复制（通过包装流的形式）
     * 注：读取是字节
     * @param file     要复制的文本文件路径和文件名称
     * @param destFile 要复制到的目标位置及新名称
     * @return
     */
    public boolean notTextFileCopyByBuffer(String file, String destFile){
        boolean isOk = false;

        File file1 = new File(file);
        File file2 = new File(destFile);

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file1));
            os = new BufferedOutputStream(new FileOutputStream(file2));

            byte[] b = new byte[128];
            int len;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            isOk = true;
        } catch (IOException e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println("流通道关闭完成");
        }

        return isOk;
    }

    /**
     * 加解密非文本文件
     * 注：操作的是字节
     * @param file  要加密或解密的文件
     * @param destFile 加密或解密后的文件存放位置和名称
     * @return
     */
    public boolean encryptionNotTextFile(String file, String destFile){
        boolean isOk = false;

        File file1 = new File(file);
        File file2 = new File(destFile);

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file1));
            os = new BufferedOutputStream(new FileOutputStream(file2));

            byte[] b = new byte[128];
            int len;
            while ((len = is.read(b)) != -1) {
                for (int i = 0; i < b.length; i++) {
                    b[i] = (byte) (b[i] ^ 5);  // ^ 一遍加密，再 ^ 一遍回复原值
                }
                os.write(b, 0, len);
            }
            isOk = true;
        } catch (IOException e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println("流通道关闭完成");
        }

        return isOk;
    }

    /**
     * 向指定文件末尾追加文本内容
     * 说明：文件不存在会自动创建并将内容写入
     * @param file  文件路径
     * @param content 追加的内容
     */
    public void appendTextToFile(String file,String content){
        BufferedWriter writer = null;
        try {
            // 参数2：true向末尾追加文件，false为覆盖原内容。不指定，默认false
            FileWriter fileWriter = new FileWriter(file, true);
            writer = new BufferedWriter(fileWriter);
            writer.write(content,0,content.length());
            writer.newLine();
            System.out.println("写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer !=null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

/**
 * 文件流的示例
 * @author caowei
 * @create 2020/2/1
 */
public class FileCopyDemo {

    public static void main(String[] args) {

        /** 文本文件复制示例 **/

//        String file_path = "java-io-demo"+separator+"dir"+separator;
//        String file = file_path+"1.txt";
//        String destFile = file_path + "dest1.txt";
//
//        FileOperation fileOperation = new FileOperation();
//        long startTime = System.currentTimeMillis();
//        // boolean isOk = fileOperation.textFileCopy(file, destFile);
//        boolean isOk = fileOperation.textFileCopyByFileStream(file,destFile);  // 大文件复制才看到速度优势，小文件不明显。
//        long endTime = System.currentTimeMillis();
//        System.out.println("操作结果："+isOk+"\t耗时："+(endTime-startTime));

        /** 非文本文件复制示例 **/

//        String file_path = "java-io-demo" + separator + "dir" + separator;
//        String file = file_path + "02.png";
//        String destFile = file_path + "dest02.png";
//
//        FileOperation fileOperation = new FileOperation();
//        long startTime = System.currentTimeMillis();
//        // 测试图片大小：1.13MB
////        boolean isOk = fileOperation.notTextFileCopy(file, destFile);  // 耗时：62
//        boolean isOk = fileOperation.notTextFileCopyByBuffer(file, destFile); // 耗时：4
//        long endTime = System.currentTimeMillis();
//        System.out.println("操作结果：" + isOk + "\t耗时：" + (endTime - startTime));

        /** 非文本文件加解密示例 **/

//        String file_path = "java-io-demo" + separator + "dir" + separator;
//        String file = file_path + "02.png";
//        String destFile = file_path + "encrypt02.png";
//
//        FileOperation fileOperation = new FileOperation();
//        // fileOperation.encryptionNotTextFile(file,destFile);  // 加密
//
//        file = file_path + "decrypt02.png";
//        fileOperation.encryptionNotTextFile(destFile,file);  // 解密

        /** 向指定文件末尾追加文本内容示例 **/

        String file_path = "java-io-demo" + separator + "dir" + separator;
        String file = file_path + "1.txt";
        String content ="A B C D! This text content";
        FileOperation fileOperation = new FileOperation();
        fileOperation.appendTextToFile(file,content);
    }
}
