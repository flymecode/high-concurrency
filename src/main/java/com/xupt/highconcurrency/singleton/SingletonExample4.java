package com.xupt.highconcurrency.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonExample4 {
    // 私有构造函数
    private SingletonExample4() {
    }

    // 单列对象
    private static SingletonExample4 instance = null;
    static {
        instance = new SingletonExample4();
    }
    // 静态的工厂方法
    public static SingletonExample4 getInstance() {
        return instance;
    }
}
