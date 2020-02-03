package com.mianshi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA ����ģ��ʾ��
 *
 * @author caowei
 * @create 2020/1/29
 */
public class ABADemo {

    /**
     * ģ�����ڴ湲�����ݱ��� �����ܲ���ABA���⣩
     */
    static AtomicReference<Integer> atomic = new AtomicReference<>(100);
    /**
     * ���ڴ湲�������ݱ��� �� ��ܽ��ABA���⣩
     * �������1�����������ʼ��ֵ
     * �������2������ʱ����İ汾��
     */
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        // ======== ABA�����ģ����� =======
        System.out.println("======== ABA�����ģ����� =======");

        new Thread(new Runnable() {
            @Override
            public void run() {
                // A--B--A ģ��
                atomic.compareAndSet(100,101);  // A--B
                atomic.compareAndSet(101,100);  // B--A
                System.out.println("...");
            }
        }, "AA").start();

        new Thread(()-> {
            // ģ��BB�̴߳����ʱ��������֤AA�߳������һ��ABA�������̡�
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ִ�н���� true	2020
            // ��¶����ABA����
            System.out.println(atomic.compareAndSet(100, 2020)+"\t"+atomic.get());

        },"BB").start();

        // ��ͣ2�롣�������ֿ���
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ======== ABA����Ľ������ =======
        System.out.println("======== ABA����Ľ������ =======");

        new Thread(()-> {
            int stamp = stampedReference.getStamp();  // ��ȡ��ǰ�汾��
            System.out.println(Thread.currentThread().getName()+"\t1�ΰ汾�ţ�"+stamp);
            // �ȴ�t2�̺߳��Լ��õ���ͬ�İ汾�š�����������ģ��ABA�Ľ�����̣�
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    // ����������ֵ��Ҫ���µ�ֵ�������汾�š�Ҫ���µİ汾��
                    stampedReference.compareAndSet(
                            100,101, stamp,stampedReference.getStamp()+1)
                            +"\t"+stampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"\t2�ΰ汾�ţ�"+stampedReference.getStamp());
            // ����������ֵ��Ҫ���µ�ֵ�������汾�š�Ҫ���µİ汾��
            System.out.println(stampedReference.compareAndSet(
                    101,100, stampedReference.getStamp(),stampedReference.getStamp()+1)
                    +"\t"+stampedReference.getReference());
            System.out.println(Thread.currentThread().getName()+"\t3�ΰ汾�ţ�"+stampedReference.getStamp());
        },"t1").start();

        new Thread(()-> {
            int stamp = stampedReference.getStamp();  // ��ȡ��ǰ�汾��
            System.out.println(Thread.currentThread().getName()+"\t1�ΰ汾�ţ�"+stamp);
            // ģ��t2�̴߳����ʱ3�룬������֤t1�߳������һ��ABA�������̡�
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ִ�н���� false	3
            // Ԥ��ֵ��Ȼһ�£����汾�Ų�һ�£������ABA����
            System.out.println(
                    // ����������ֵ��Ҫ���µ�ֵ�������汾�š�Ҫ���µİ汾��
                    stampedReference.compareAndSet(
                            100,101, stamp,stampedReference.getStamp()+1)
                    +"\t"+Thread.currentThread().getName()+"\tʵ�ʰ汾�ţ�"+stampedReference.getStamp());

        },"t2").start();
    }
}
