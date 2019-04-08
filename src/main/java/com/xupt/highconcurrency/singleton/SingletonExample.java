package com.xupt.highconcurrency.singleton;

import lombok.extern.slf4j.Slf4j;

// 懒汉模式
@Slf4j
public class SingletonExample {
    // 私有构造函数
    private SingletonExample() {
    }

    // 单列对象
    // 线程不安全
    // private static SingletonExample instance = null;
    // 线程安全
    private static SingletonExample instance = new SingletonExample();

    // 静态的工厂方法
    public static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
}
