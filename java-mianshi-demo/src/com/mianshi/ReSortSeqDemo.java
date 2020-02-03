package com.mianshi;

/**
 * 为什么要禁止指令重排序的示例演示。
 * @author caowei
 * @create 2020/1/28
 */
public class ReSortSeqDemo {

    /**
     * 使用volatile关键字修饰变量，这将禁止指令重排序。
     * 对Volatile变量进行写操作时，会在写操作后加入一条store屏障指令，将线程私有工作内存中的变量值刷新加到主内存中。
     * 对volatile变量进行读操作时，会在读操作前加入一条load屏障指令，从主内存中读取共享变量。
     */
    volatile int a = 0;
    boolean flag=false;

    public void method01(){
        a =1;
        flag = true;
        /**
         * 编译器和处理器都能进行指令重排的优化。
         * 编译器进行指令重排序的优化规则是，两个变量间【没有依赖性】。
         * a和flag两个变量显然没有依赖关系。存在重排序的可能。
         * 在多线程高并发情况，假设编译器重排序了。 flag = true 排在前，而这行刚执行完成，
         * 另一个线程抢到了资源，调用 method02()函数，这样会导致 最终计算结果的不确定性。
         *
         * 解决指令重排序：使用volatile关键字修饰变量，这将禁止指令重排序。
         */
    }

    public void method02(){
        if(flag){
            a = a+5;
            System.out.println("a的值："+a);
        }
    }
}
