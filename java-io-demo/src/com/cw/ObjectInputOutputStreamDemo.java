package com.cw;

import java.io.*;
import static java.io.File.separator;

/**
 * ���л�������
 * 1.Ҫ���л�����򱣴��java���󣬱���ʵ��Serializable�ӿڣ��������л�ʱ�ף�NotSerializableException�쳣
 * 2.�ṩһ��ȫ�ֳ���serialVersionUID
 * 3.��֤���ڲ����������Ծ��ǿ����л��ģ����������һ���Զ��������ҲҪ��֤�����ǿ����л��ġ�
 *
 * ObjectInputStream \ ObjectOutputStream ���߲������л��� static��transient���εĳ�Ա������serialVersionUID����
 */
class User implements Serializable {

    /**
     * ��ʾ���л��汾��ʶ���ľ�̬������
     * ���û�ж������������������ֵ��java����ʱ������������ڲ�ϸ���Զ����ɡ������ʵ�����������޸ģ�
     * serialVersionUID���ܷ����仯�����¼��˼������ԣ�����Ľṹ�����˱仯��������������л�ʱ�����⡣
     * �ʽ��飬��ʾ��������һ��������
     * ����˵���ڽ��з����л�ʱ��JMV��Ѵ������ֽ����е�serialVersionUID�뱾����Ӧʵ�����serialVersionUID�Ƚϣ�
     * �����ͬ����Ϊ��һ�µģ����Խ������л�����ṹ��һ�����Ի�ʹ��Ĭ��ֵ��������ͻ�������л��汾��һ�µ��쳣��InvalidClassException
     */
    public static final long serialVersionUID = 1001L;

    private String account;
    private String nickName;
    private String pwd;

    public User(String account, String nickName, String pwd) {
        this.account = account;
        this.nickName = nickName;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

/**
 * ��������
 * ObjectInputStream \ ObjectOutputStream ���߲������л��� static��transient���εĳ�Ա����
 * 1. ���ڴ�java�������л���Ȼ�󱣴浽������
 * 2. ���������ļ������ݷ����л�Ϊ�ڴ��е�һ��java����Ҳ���������������ݡ�
 * @author caowei
 * @create 2020/2/2
 */
public class ObjectInputOutputStreamDemo {

    public static void main(String[] args) {
        User user = new User("15031@qq.com","superman","123456");
        String path = "java-io-demo"+separator+"dir"+separator+"user.dat";

//        ObjectOutputSteamDemo(user, path);
        User u = (User) ObjectInputStreamDemo(path);
        System.out.println(u.toString());
    }

    /**
     * ���ڴ�java�������л���Ȼ�󱣴浽������
     * @param user
     * @param path
     */
    private static void ObjectOutputSteamDemo(User user, String path) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(user);
            oos.flush(); // ˢ��
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null)
                try {
                    oos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * ���������ļ������л����ڴ��е�һ��java����
     * @param path
     * @return
     */
    private static Object ObjectInputStreamDemo(String path){
        ObjectInputStream ois = null;
        Object object = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            object = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return object;
    }
}
