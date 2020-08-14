package com.personal.codelearn.algorithm;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：yangbao
 * @description：背包问题
 * @version: $
 * @date ：Created in 2020/7/30 3:38 下午
 * @modified By：
 */
public class PackageLearn {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ExecutorService fiExecutorService = Executors.newFixedThreadPool(10);
        ExecutorService newcahExecutorService = Executors.newCachedThreadPool();
        ExecutorService singExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    }
}
