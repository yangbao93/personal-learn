package com.personal.codelearn.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：yangbao
 * @description：
 * @version: $
 * @date ：Created in 2020/7/6 9:03 下午
 * @modified By：
 */
public class ReentrantLockLearn {

    private Lock lock = new ReentrantLock();
    //Lock lock=new ReentrantLock(true);//公平锁
    //Lock lock=new ReentrantLock(false);//非公平锁
    //创建 Condition
    private Condition condition = lock.newCondition();

    public void testMethod() {
        try {
            lock.lock();
            //lock 加锁
            // 1:wait 方法等待:
            //System.out.println("开始 wait");
            condition.await();
            //通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
            //:2:signal 方法唤醒
            condition.signal();//condition 对象的 signal 方法可以唤醒 wait 线程
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockLearn rL = new ReentrantLockLearn();
        rL.testMethod();
    }
}
