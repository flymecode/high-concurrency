package com.xupt.highconcurrency.sync;

import com.fasterxml.jackson.databind.node.POJONode;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample {
    // 修饰一个代码块,作用于调用的对象
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}", i);
            }
        }
    }
    // 修饰一个方法，作用于调用的对象
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    // 修饰一个静态方法,作用与所有对象
    public static synchronized void test3() {
        for (int i = 0; i < 10; i++) {
            log.info("test3 - {}", i);
        }
    }

    // 修饰一个类，作用与所有对象
    public void test4() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test3 - {}", i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            example.test1();
        });
        executorService.execute(() -> {
            example.test2();
        });
    }

}
