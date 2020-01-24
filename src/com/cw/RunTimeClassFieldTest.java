package com.cw;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 调用运行时类中的指定属性
 * @author caowei
 * @create 2020/1/12
 */
public class RunTimeClassFieldTest {

    /**
     * 不推荐此种方式。
     * @throws Exception
     */
    @Test
    public void Test1() throws Exception {
        Class<?> clazz = Class.forName("com.cw.Person");
        // 创建运行时类的对象
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // 获取指定的属性：要求运行时类中的属性声明为public，否则抛NoSuchFieldException
        // 注：但声明为public的属性情况极少，通常不用这种方式。
        Field id = clazz.getField("id");
        System.out.println(id.get(instance));

        id.set(instance,520);
        System.out.println(id.get(instance));
    }

    /**
     * 推荐的方式
     */
    @Test
    public void Test2() throws Exception {
        Class<?> clazz = Class.forName("com.cw.Person");
        // 创建运行时类的对象
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // 获取运行时类中的指定属性（没有public或private的限制）
        Field name = clazz.getDeclaredField("name");
        // Accessible: 可理解的 / 可进入的 / 平易近人的 / 易得到的
        name.setAccessible(true); // 设置开放访问权限，否则抛 IllegalAccessException

        name.set(instance,"象象");
        System.out.println(name.get(instance));
    }
}
