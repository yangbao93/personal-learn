package com.personal.codelearn.java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadLearn {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void useExecutor() {
        List<Long> timeList = new ArrayList<>();
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 100; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        timeList.add(System.currentTimeMillis());
                        Thread.sleep(100);
                        timeList.add(System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
//            executorService.execute(task);
            executorService.submit(task);
        }
        sw.stop();
        log.info("useExecutor:{}", sw.getTotalTimeMillis());
        log.info("useExecutor,最小时间为:{},最大时间为{},差值为{}", Collections.min(timeList), Collections.max(timeList),
                Collections.max(timeList) - Collections.min(timeList));
    }

    public void noUseExecutor() {
        List<Long> timeList = new ArrayList<>();
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 100; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        timeList.add(System.currentTimeMillis());
                        Thread.sleep(100);
                        timeList.add(System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(task).start();
        }
        sw.stop();
        log.info("noUseExecutor:{}", sw.getTotalTimeMillis());
        log.info("noUseExecutor,最小时间为:{},最大时间为{},差值为{}", Collections.min(timeList), Collections.max(timeList),
                Collections.max(timeList) - Collections.min(timeList));
    }




    public static void main(String[] args) {
        ThreadLearn tl = new ThreadLearn();
        tl.noUseExecutor();
        tl.useExecutor();
        log.info("测试结束");
    }

}
