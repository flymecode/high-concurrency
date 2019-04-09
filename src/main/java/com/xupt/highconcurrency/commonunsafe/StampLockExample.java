package com.xupt.highconcurrency.commonunsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class StampLockExample {

    private final StampedLock lock = new StampedLock();
    private final List list = new ArrayList();

    public void put(int i) {
        long stamp = lock.writeLock();
        list.add(i);
        lock.unlock(stamp);
    }
}
