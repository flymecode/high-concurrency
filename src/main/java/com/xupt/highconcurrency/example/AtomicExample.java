package com.xupt.highconcurrency.example;

import com.xupt.highconcurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample {
    private static AtomicIntegerFieldUpdater<AtomicExample> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample.class,"count");
    @Getter
    // 必须是volatile 而且不能被static修饰
    private volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample example = new AtomicExample();
        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success 1,{}", example.getCount());
        }
        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success 2,{}", example.getCount());
        }
    }

}

