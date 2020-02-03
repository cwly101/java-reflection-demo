package com.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class CountNumber {
    /**
     * ʹ��volatile�ؼ������κ�����ԣ��ܱ�֤���ڡ����̲߳������¡�����µġ��ڴ�ɼ��ԡ���
     * ������֤ԭ����
     */
    volatile int num;

    /**
     * ��֤ԭ���Ե�Integer����
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
        // �Ȼ�ȡ�ټ�1 ����֤ԭ���ԣ�
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
     * ��֤ԭ���Ե�ʾ����AtomicInteger�฽��Ҳ��֤�ɼ��ԡ�
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

        while (Thread.activeCount() > 2) {  // ���ص�ǰ�̵߳Ļ�߳����Ĺ���ֵ��
            Thread.yield();   // ����ȳ�����ʾ��ǰ�߳�Ը������䵱ǰ�Դ�������ʹ�á�
        }
        System.out.println(countNumber.atomicNum);
    }

    /**
     * Volatile����֤ԭ����ʾ��
     *
     * @param countNumber
     * @throws InterruptedException
     */
    private static void VolatileNotAotmicDemo(CountNumber countNumber) throws InterruptedException {
        // ����10�̣߳�ÿ���̵߳���addPlusPlus()����50�Σ����������volatile����֤ԭ���Ե���������ֳ����ˡ�
        // �ڲ����̼߳��ٻ������ٵ�����£�����Ҳ����ͻ�֡�

        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    countNumber.addPlusPlus();
                }
                latch.countDown();  // �ݼ������ļ�������������ﵽ�㣬���ͷ����еȴ����̡߳�
            }, String.valueOf(i)).start();
        }
        latch.await();

        // ʹ��CountDownLatch��һ�ַ�ʽ��������ʹ�÷�ʽ2����Ȼ��Ҫ�ѷ�ʽע�͵���
//        while (Thread.activeCount() > 2){  // ���ص�ǰ�̵߳Ļ�߳����Ĺ���ֵ��
//            Thread.yield(); // ����ȳ�����ʾ��ǰ�߳�Ը������䵱ǰ�Դ�������ʹ�á�
//        }

        System.out.println(countNumber.getNum());
    }

    /**
     * volatile�ɼ���ʾ��
     * ʹ��volatile�ؼ������κ�����ԣ��ܱ�֤���ڡ����̲߳������¡�����µġ��ڴ�ɼ��ԡ�
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

        // ����������Է�װ��getter���������ڴ�ɼ���Ҳ����Ӱ�죬ͬ����֤���յ��޸ĺ��֪ͨ��
        while (countNumber.getNum() == 0) {
            // ���δ�յ�ֵ�����֪ͨ����һֱ����ѭ����ȥ��
        }
        // ʹ��volatile�ؼ������κ�����ԣ��ܱ�֤���ڡ����̲߳������¡�����µġ��ڴ�ɼ��ԡ���
        System.out.println("main �յ�֪ͨnumֵ���޸ģ���ֵ��" + countNumber.getNum());
    }
}
