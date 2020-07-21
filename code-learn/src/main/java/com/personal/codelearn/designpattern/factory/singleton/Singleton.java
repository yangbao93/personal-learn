package com.personal.codelearn.designpattern.factory.singleton;

/**
 * 单例模式-饿汉模式
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
