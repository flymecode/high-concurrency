package com.xupt.highconcurrency.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
@Slf4j
public class MapExample {
    // 线程数量
    private static int ThreadNumber = 1;
    // 客户端总数
    private static int clientTotal = 5000;
    // TODO 为什么int 与 long 是有区别的呢？
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(ThreadNumber);
        for (int i = 0; i < clientTotal; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    fun(threadNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("map size is:{}", map.size());
    }

    private static void fun(int i) {
        map.put(i, i);
    }
}
