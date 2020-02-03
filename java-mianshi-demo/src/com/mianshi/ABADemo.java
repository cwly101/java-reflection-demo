package com.mianshi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题模拟示例
 *
 * @author caowei
 * @create 2020/1/29
 */
public class ABADemo {

    /**
     * 模拟主内存共享数据变量 （可能产生ABA问题）
     */
    static AtomicReference<Integer> atomic = new AtomicReference<>(100);
    /**
     * 主内存共享共享数据变量 （ 规避解决ABA问题）
     * 构造参数1：共享变量初始化值
     * 构造参数2：类似时间戳的版本号
     */
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        // ======== ABA问题的模拟呈现 =======
        System.out.println("======== ABA问题的模拟呈现 =======");

        new Thread(new Runnable() {
            @Override
            public void run() {
                // A--B--A 模拟
                atomic.compareAndSet(100,101);  // A--B
                atomic.compareAndSet(101,100);  // B--A
                System.out.println("...");
            }
        }, "AA").start();

        new Thread(()-> {
            // 模拟BB线程处理耗时，进而保证AA线程完成了一次ABA操作过程。
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行结果： true	2020
            // 暴露出了ABA问题
            System.out.println(atomic.compareAndSet(100, 2020)+"\t"+atomic.get());

        },"BB").start();

        // 暂停2秒。上下区分开。
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ======== ABA问题的解决方案 =======
        System.out.println("======== ABA问题的解决方案 =======");

        new Thread(()-> {
            int stamp = stampedReference.getStamp();  // 获取当前版本号
            System.out.println(Thread.currentThread().getName()+"\t1次版本号："+stamp);
            // 等待t2线程和自己拿到相同的版本号。（这样才能模拟ABA的解决过程）
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    // 参数：期望值、要更新的值、期望版本号、要更新的版本号
                    stampedReference.compareAndSet(
                            100,101, stamp,stampedReference.getStamp()+1)
                            +"\t"+stampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"\t2次版本号："+stampedReference.getStamp());
            // 参数：期望值、要更新的值、期望版本号、要更新的版本号
            System.out.println(stampedReference.compareAndSet(
                    101,100, stampedReference.getStamp(),stampedReference.getStamp()+1)
                    +"\t"+stampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"\t3次版本号："+stampedReference.getStamp());
        },"t1").start();

        new Thread(()-> {
            int stamp = stampedReference.getStamp();  // 获取当前版本号
            System.out.println(Thread.currentThread().getName()+"\t1次版本号："+stamp);
            // 模拟t2线程处理耗时3秒，进而保证t1线程完成了一次ABA操作过程。
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行结果： false	3
            // 预期值虽然一致，但版本号不一致，解决了ABA问题
            System.out.println(
                    // 参数：期望值、要更新的值、期望版本号、要更新的版本号
                    stampedReference.compareAndSet(
                            100,101, stamp,stampedReference.getStamp()+1)
                    +"\t"+Thread.currentThread().getName()+"\t实际版本号："+stampedReference.getStamp());

        },"t2").start();
    }
}
