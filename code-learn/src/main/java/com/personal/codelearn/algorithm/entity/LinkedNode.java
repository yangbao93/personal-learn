package com.personal.codelearn.algorithm.entity;

/**
 * @author ：yangbao
 * @description：
 * @version: $
 * @date ：Created in 2020/7/20 3:09 下午
 * @modified By：
 */
public class LinkedNode<T> {

    private final T value;
    private LinkedNode<T> next;

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public void linkNext(LinkedNode<T> n) {
        this.next = n;
    }

    public LinkedNode<T> next() {
        return this.next;
    }

    public T value() {
        return this.value;
    }

    public static <ST> boolean contains(LinkedNode<ST> node, ST value) {
        while (node != null) {
            if (node.value() == value) {
                return true;
            }

            node = node.next();
        }

        return false;
    }
}
