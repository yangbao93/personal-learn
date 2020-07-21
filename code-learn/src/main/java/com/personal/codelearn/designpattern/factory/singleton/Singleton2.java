package com.personal.codelearn.designpattern.factory.singleton;

/**
 * 单例模式-饱汉模式
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            // 此处加synchronized是为了提高并发,只有当进入到下面代码时候才会请求锁,如果加在方法上会导致调用getInstance时候就要获取锁
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
