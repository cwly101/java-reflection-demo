package com.cw;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author caowei
 * @create 2020/1/12
 */
public class RunTimeClassMethodTest {

    @Test
    public void test1() throws Exception {
        Class<?> clazz = Class.forName("com.cw.Person");
        // 创建运行时类的对象
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // 运行时类实例方法的调用

        // 参数1：方法名称  参数2：方法参数类型
        Method show = clazz.getDeclaredMethod("show", String.class);
        System.out.println(show);
        // 保证当前方法是可访问。（仅针对非public的方法，公有方法无需设置，自然可访问）
        show.setAccessible(true);

        // 参数1：运行时类对象  参数2：方法参数 （给方法形参赋值的实参）
        Object china = show.invoke(instance, "china");
        System.out.println(china);

        // 运行时类静态方法的调用

        Method message = clazz.getDeclaredMethod("message");
        message.setAccessible(true);
        // 调用静态方法时 invoke 参数1 传一个null也可以。clazz知道静态方法是什么。只有非静态方法才必须要一个运行时类对象
        message.invoke(instance);
    }
}
