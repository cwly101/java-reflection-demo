package com.cw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理示例
 *
 * @author caowei
 * @create 2020/1/13
 */
public class ProxyDemo {

    public static void main(String[] args) {

        // 示例1
        IHuman chinese = new Demo1(); // 被代理类对象
        // 生成代理类对象
        IHuman proxyInstance = (IHuman) ProxyFactory.getProxyInstance(chinese);
        //当通过代理类对象调用方法时，会自动的调用被代理类中的同名方法
        proxyInstance.say();
        proxyInstance.eat("饺子");

        // 示例2
        IAnimal dog = new Demo2();
        IAnimal proxyInstance1 = (IAnimal) ProxyFactory.getProxyInstance(dog);
        proxyInstance1.call();

        // 通过两个示例，验证了动态代理的通用性。根据被代理对象再去动态生成代理对象，避免静态代理存在多个代理对象的问题。
    }
}

/**
 * 动态生成代理对象
 *
 * 实现动态代理，需要解决2个问题。
 * 1. 如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
 * 2. 当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法？
 */
class ProxyFactory {

    /**
     * 获取动态生成的代理对象
     *
     * @param object 被代理对象
     * @return 动态生成的代理对象
     */
    public static Object getProxyInstance(Object object) {

        // 解决问题2的疑问。
        // 当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用
        InvocationHandler handler = new MyInvocationHandler(object);

        // 解决问题1的疑问。
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                handler
                );
    }
}

/**
 * 当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用
 */
class MyInvocationHandler implements InvocationHandler {

    private Object object;  // 被代理对象

    /**
     * 仅提供这一个有参构造，防止实例化时忘记传递 被代理对象
     * @param object 被代理对象
     */
    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy 动态生成的代理对象
     * @param method 被调用的方法
     * @param args 方法参数
     * @return 被调用方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object invoke = method.invoke(object, args);
        System.out.println("after...");
        return invoke;
    }
}
