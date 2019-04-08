package com.xupt.highconcurrency.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonExample2 {
    // 私有构造函数
    private SingletonExample2() {
    }

    // 单列对象
    private volatile static SingletonExample2 instance = null;
    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample2.class) {
                if (instance == null) {
                    instance = new SingletonExample2();
                }
            }
        }
        return instance;
    }
}
