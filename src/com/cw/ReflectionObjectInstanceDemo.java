package com.cw;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射方式创建运行时对象实例
 *
 * @author caowei
 * @create 2020/1/10
 */
public class ReflectionObjectInstanceDemo {

    /**
     * 反射创建运行时对象实例，使用newInstance()
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void createInstanceTest()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        System.out.println("======");
        Class<Person> clazz = Person.class;
        Person person = clazz.getDeclaredConstructor().newInstance();
        System.out.println(person);
    }

    @Test
    public void Test2() throws Exception{
        Object instance = createInstance("com.cw.Person");
        System.out.println(instance);
    }

    /**
     * 根据类全类名创建运行时类对象实例
     * @param classPath 全类名
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private Object createInstance(String classPath)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Class<?> clazz = Class.forName(classPath);
        Object o = clazz.getDeclaredConstructor().newInstance();
        return  o;
    }
}
