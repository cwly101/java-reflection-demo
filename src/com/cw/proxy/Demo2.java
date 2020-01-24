package com.cw.proxy;

interface IAnimal{
    void call();
}

/**
 * @author caowei
 * @create 2020/1/13
 */
public class Demo2 implements IAnimal {

    @Override
    public void call() {
        System.out.println("汪汪汪...");
    }
}
