package com.personal.codelearn.java;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockLearn {

    private int NUMS = 1;

    private static ExecutorService executor = Executors.newFixedThreadPool(200);

    public void addNumsWithNoLock() {
        this.NUMS++;
    }

    public void addNumsWithLock() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            this.NUMS++;
        } catch (Exception e) {
            log.error("发生了异常,信息为{}", e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void addNumsWithSynchronized() {
        synchronized (this) {
            this.NUMS++;
        }
    }


    public static void main(String[] args) {

        LockLearn ll = new LockLearn();
        ll.runLock(ll);
//        ll.runSynchronized(ll);
        System.exit(0);
    }

    public void runNoLock(LockLearn ll) {
        Runnable noLockTask = new Runnable() {
            @Override
            public void run() {
                ll.addNumsWithNoLock();
            }
        };
        for (int i = 0; i < 10000; i++) {
            executor.execute(noLockTask);
        }
        log.info("noLock下的最后结果{}", ll.NUMS);
    }

    public void runLock(LockLearn ll) {
        for (int i = 0; i < 10000; i++) {
            Runnable lockTask = new Runnable() {
                @Override
                public void run() {
                    ll.addNumsWithLock();
                }
            };
//            executor.submit(lockTask);
            executor.execute(lockTask);
        }
        log.info("Lock下的最后结果{}", ll.NUMS);
    }

    public void runSynchronized(LockLearn ll) {
        Runnable syncTask = new Runnable() {
            @Override
            public void run() {
                ll.addNumsWithSynchronized();
            }
        };
        for (int i = 0; i < 10000; i++) {
            executor.execute(syncTask);
        }
        log.info("sync下的最后结果{}", ll.NUMS);
    }
}
