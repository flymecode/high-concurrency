package com.xupt.highconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;
import java.util.concurrent.*;

@Slf4j
public class BlockingQueueExample {
    // 有界
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    DelayQueue delayQueue = new DelayQueue();

    // 可以是有界的也可以是无界的
    LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

    PriorityBlockingQueue priorityQueue = new PriorityBlockingQueue();

    // 无界非缓存
    SynchronousQueue synchronousQueue = new SynchronousQueue();


}
