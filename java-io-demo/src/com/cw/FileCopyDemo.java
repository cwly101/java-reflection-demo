package com.cw;

import java.io.*;

import static java.io.File.separator;

/**
 * �ļ�������
 */
class FileOperation {

    /**
     * �ı��ļ�����
     * ע����ȡ�����ַ�
     * @param file     Ҫ���Ƶ��ı��ļ�·�����ļ�����
     * @param destFile Ҫ���Ƶ���Ŀ��λ�ü�������
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
     * �ı��ļ����ƣ�ͨ����װ������ʽ��
     * ע����ȡ�����ַ�
     * @param file     Ҫ���Ƶ��ı��ļ�·�����ļ�����
     * @param destFile Ҫ���Ƶ���Ŀ��λ�ü�������
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
     * ���ı��ļ��ĸ���
     * ע����ȡ���ֽ�
     * @param file     Ҫ���Ƶ��ı��ļ�·�����ļ�����
     * @param destFile Ҫ���Ƶ���Ŀ��λ�ü�������
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
     * ���ı��ļ��ĸ��ƣ�ͨ����װ������ʽ��
     * ע����ȡ���ֽ�
     * @param file     Ҫ���Ƶ��ı��ļ�·�����ļ�����
     * @param destFile Ҫ���Ƶ���Ŀ��λ�ü�������
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
            System.out.println("��ͨ���ر����");
        }

        return isOk;
    }

    /**
     * �ӽ��ܷ��ı��ļ�
     * ע�����������ֽ�
     * @param file  Ҫ���ܻ���ܵ��ļ�
     * @param destFile ���ܻ���ܺ���ļ����λ�ú�����
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
                    b[i] = (byte) (b[i] ^ 5);  // ^ һ����ܣ��� ^ һ��ظ�ԭֵ
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
            System.out.println("��ͨ���ر����");
        }

        return isOk;
    }

    /**
     * ��ָ���ļ�ĩβ׷���ı�����
     * ˵�����ļ������ڻ��Զ�������������д��
     * @param file  �ļ�·��
     * @param content ׷�ӵ�����
     */
    public void appendTextToFile(String file,String content){
        BufferedWriter writer = null;
        try {
            // ����2��true��ĩβ׷���ļ���falseΪ����ԭ���ݡ���ָ����Ĭ��false
            FileWriter fileWriter = new FileWriter(file, true);
            writer = new BufferedWriter(fileWriter);
            writer.write(content,0,content.length());
            writer.newLine();
            System.out.println("д�����");
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
 * �ļ�����ʾ��
 * @author caowei
 * @create 2020/2/1
 */
public class FileCopyDemo {

    public static void main(String[] args) {

        /** �ı��ļ�����ʾ�� **/

//        String file_path = "java-io-demo"+separator+"dir"+separator;
//        String file = file_path+"1.txt";
//        String destFile = file_path + "dest1.txt";
//
//        FileOperation fileOperation = new FileOperation();
//        long startTime = System.currentTimeMillis();
//        // boolean isOk = fileOperation.textFileCopy(file, destFile);
//        boolean isOk = fileOperation.textFileCopyByFileStream(file,destFile);  // ���ļ����Ʋſ����ٶ����ƣ�С�ļ������ԡ�
//        long endTime = System.currentTimeMillis();
//        System.out.println("���������"+isOk+"\t��ʱ��"+(endTime-startTime));

        /** ���ı��ļ�����ʾ�� **/

//        String file_path = "java-io-demo" + separator + "dir" + separator;
//        String file = file_path + "02.png";
//        String destFile = file_path + "dest02.png";
//
//        FileOperation fileOperation = new FileOperation();
//        long startTime = System.currentTimeMillis();
//        // ����ͼƬ��С��1.13MB
////        boolean isOk = fileOperation.notTextFileCopy(file, destFile);  // ��ʱ��62
//        boolean isOk = fileOperation.notTextFileCopyByBuffer(file, destFile); // ��ʱ��4
//        long endTime = System.currentTimeMillis();
//        System.out.println("���������" + isOk + "\t��ʱ��" + (endTime - startTime));

        /** ���ı��ļ��ӽ���ʾ�� **/

//        String file_path = "java-io-demo" + separator + "dir" + separator;
//        String file = file_path + "02.png";
//        String destFile = file_path + "encrypt02.png";
//
//        FileOperation fileOperation = new FileOperation();
//        // fileOperation.encryptionNotTextFile(file,destFile);  // ����
//
//        file = file_path + "decrypt02.png";
//        fileOperation.encryptionNotTextFile(destFile,file);  // ����

        /** ��ָ���ļ�ĩβ׷���ı�����ʾ�� **/

        String file_path = "java-io-demo" + separator + "dir" + separator;
        String file = file_path + "1.txt";
        String content ="A B C D! This text content";
        FileOperation fileOperation = new FileOperation();
        fileOperation.appendTextToFile(file,content);
    }
}
