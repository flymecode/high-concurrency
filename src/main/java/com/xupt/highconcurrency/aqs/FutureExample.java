package com.xupt.highconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {
    static class Mycallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something");
            Thread.sleep(5000);
            return "OK";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> submit = executorService.submit(new Mycallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
    }

}
