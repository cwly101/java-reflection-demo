package com.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class CountNumber {
    /**
     * 使用volatile关键字修饰后的属性，能保证其在【多线程并发更新】情况下的【内存可见性】。
     * 但不保证原子性
     */
    volatile int num;

    /**
     * 保证原子性的Integer类型
     */
    AtomicInteger atomicNum = new AtomicInteger();

    public int getNum() {
        return num;
    }

    void addTo60() {
        this.num = 60;
    }

    void addPlusPlus() {
        this.num++;
    }

    void AtomicAdd() {
        // 先获取再加1 （保证原子性）
        atomicNum.getAndIncrement();
    }
}

/**
 * @author caowei
 * @create 2020/1/28
 */
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {

        CountNumber countNumber = new CountNumber();

//        VisibilityVolatileDemo(countNumber);
//        VolatileNotAotmicDemo(countNumber);

        AtomicIntegerDemo(countNumber);
    }

    /**
     * 保证原子性的示例。AtomicInteger类附带也保证可见性。
     * @param countNumber
     */
    private static void AtomicIntegerDemo(CountNumber countNumber) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    countNumber.AtomicAdd();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {  // 返回当前线程的活动线程数的估计值。
            Thread.yield();   // 向调度程序提示当前线程愿意放弃其当前对处理器的使用。
        }
        System.out.println(countNumber.atomicNum);
    }

    /**
     * Volatile不保证原子性示例
     *
     * @param countNumber
     * @throws InterruptedException
     */
    private static void VolatileNotAotmicDemo(CountNumber countNumber) throws InterruptedException {
        // 创建10线程，每个线程调用addPlusPlus()函数50次，这种情况下volatile不保证原子性的问题就显现出来了。
        // 在并发线程极少或计算很少的情况下，问题也许不会突现。

        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    countNumber.addPlusPlus();
                }
                latch.countDown();  // 递减闩锁的计数，如果计数达到零，则释放所有等待的线程。
            }, String.valueOf(i)).start();
        }
        latch.await();

        // 使用CountDownLatch是一种方式，还可以使用方式2。当然，要把方式注释掉。
//        while (Thread.activeCount() > 2){  // 返回当前线程的活动线程数的估计值。
//            Thread.yield(); // 向调度程序提示当前线程愿意放弃其当前对处理器的使用。
//        }

        System.out.println(countNumber.getNum());
    }

    /**
     * volatile可见性示例
     * 使用volatile关键字修饰后的属性，能保证其在【多线程并发更新】情况下的【内存可见性】
     *
     * @param countNumber
     */
    private static void VisibilityVolatileDemo(CountNumber countNumber) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t value:" + countNumber.getNum());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {

                }
                countNumber.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t new value:" + countNumber.getNum());
            }
        }, "AA").start();

        // 即便调用属性封装的getter方法，其内存可见性也不受影响，同样保证会收到修改后的通知。
        while (countNumber.getNum() == 0) {
            // 如果未收到值变更的通知，将一直无限循环下去。
        }
        // 使用volatile关键字修饰后的属性，能保证其在【多线程并发更新】情况下的【内存可见性】。
        System.out.println("main 收到通知num值已修改，新值：" + countNumber.getNum());
    }
}
