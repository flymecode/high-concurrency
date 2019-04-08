package com.xupt.highconcurrency.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 对写分离
 * 最终一致性
 */
@Slf4j
public class ConcurrentHashMapExample {
    // 可以使一段代码只执行一次
    public static int clientTotal = 5000;
    public static int threadTotal = 100;

    public static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int index = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    test(index);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception,{}", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        log.info("count:{}", map.size());
    }

    public static void test(int i) {
        map.put(i, i);
    }
}
