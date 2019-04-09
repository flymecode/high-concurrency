package com.xupt.highconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureJoinExample extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public FutureJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start <= 10) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            FutureJoinExample left = new FutureJoinExample(start, middle);
            FutureJoinExample right = new FutureJoinExample(middle, end);
            left.fork();
            right.fork();

            int leftRes = left.join();
            int rightRes = right.join();
            sum = leftRes + rightRes;
        }
        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(new FutureJoinExample(1,100));
        System.out.println(future.get());
    }
}

