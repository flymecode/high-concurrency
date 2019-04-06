package com.xupt.highconcurrency.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author maxu
 */
@Slf4j
public class CountExample {

    // 线程数量
    private static int ThreadNumber = 1;
    // 客户端总数
    private static int clientTotal = 5000;
    // TODO 为什么int 与 long 是有区别的呢？
    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(ThreadNumber);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }
}
