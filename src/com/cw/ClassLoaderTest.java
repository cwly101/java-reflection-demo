package com.cw;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author caowei
 * @create 2020/1/10
 */
public class ClassLoaderTest {

    /**
     * IO流读取文件 和 ClassLoader读取文件
     * @throws Exception
     */
    @Test
    public void readLocationFile() throws Exception {

        Properties properties = new Properties();
        // 方式1：正常通过文件流读取文件。 （项目模块下的test.properties文件,这是方式1的默认识别目录）
        InputStream is = new FileInputStream("test.properties");
        properties.load(is);
        System.out.println(properties.get("name")+","+properties.get("pwd"));

        System.out.println("====");

        // 方式2：通过类加载器访问流读取文件。（src目录下的test.properties文件,这是方式2的默认识别目录)
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("test.properties");
        properties.load(in);
        System.out.println(properties.get("name")+","+properties.get("pwd"));

        // 实际项目中，建议将文件放置在src目录下。因为放到项目模块目录下，如果部署到服务器的web容器，可能会导致文件缺失。
    }
}
