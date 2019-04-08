package com.xupt.highconcurrency.interceptor;

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static long get() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
