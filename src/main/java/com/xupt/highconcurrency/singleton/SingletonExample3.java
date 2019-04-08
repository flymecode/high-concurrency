package com.xupt.highconcurrency.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonExample3 {
    // 私有构造函数
    private SingletonExample3() {
    }

    // 单列对象
    private static SingletonExample3 instance = null;
    static {
        instance = new SingletonExample3();
    }
    // 静态的工厂方法
    public static SingletonExample3 getInstance() {
        return instance;
    }
}
