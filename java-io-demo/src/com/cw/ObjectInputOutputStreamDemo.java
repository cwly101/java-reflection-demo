package com.cw;

import java.io.*;
import static java.io.File.separator;

/**
 * 序列化条件：
 * 1.要序列化传输或保存的java对象，必须实现Serializable接口，否则序列化时抛：NotSerializableException异常
 * 2.提供一个全局常量serialVersionUID
 * 3.保证其内部的所有属性均是可序列化的，如果属性是一个自定义类对象，也要保证该类是可序列化的。
 *
 * ObjectInputStream \ ObjectOutputStream 两者不能序列化被 static、transient修饰的成员变量。serialVersionUID例外
 */
class User implements Serializable {

    /**
     * 表示序列化版本标识符的静态常量。
     * 如果没有定义这个常量，它的是值是java运行时环境根据类的内部细节自动生成。若类的实例变量做了修改，
     * serialVersionUID可能发生变化。如新加了几个属性，即类的结构发生了变化，这可能引发序列化时的问题。
     * 故建议，显示声明给定一个常量。
     * 简单来说，在进行反序列化时，JMV会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID比较，
     * 如果相同就认为是一致的，可以进行序列化（类结构不一致属性会使用默认值），否则就会出现序列化版本不一致的异常：InvalidClassException
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
 * 对象流：
 * ObjectInputStream \ ObjectOutputStream 两者不能序列化被 static、transient修饰的成员变量
 * 1. 将内存java对象序列化，然后保存到磁盘中
 * 2. 将磁盘中文件中数据反序列化为内存中的一个java对象，也可以是网络中数据。
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
     * 将内存java对象序列化，然后保存到磁盘中
     * @param user
     * @param path
     */
    private static void ObjectOutputSteamDemo(User user, String path) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(user);
            oos.flush(); // 刷新
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
     * 将磁盘中文件反序列化到内存中的一个java对象
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
