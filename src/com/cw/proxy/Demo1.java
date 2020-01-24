package com.cw.proxy;

interface IHuman{
    String say();
    void eat(String food);
}

/**
 * 被代理类1
 * @author caowei
 * @create 2020/1/13
 */
public class Demo1 implements IHuman {

    @Override
    public String say() {
        System.out.println("说汉语");
        return "chinese";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃"+ food);
    }
}
