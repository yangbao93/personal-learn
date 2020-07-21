package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * 全排列
 */
public class Pernum {

    /**
     * 错误例子
     *
     * @param arr 数组
     * @param p   开始位置
     * @param q   长度
     */
    public static void pernum(int[] arr, int p, int q) {
        if (p == q) {
            System.out.println(JSONObject.toJSON(arr));
        }
        for (int i = p; i < q; i++) {
            AlgorithmUtil.swap(arr, i, p);
            pernum(arr, p + 1, q);
            AlgorithmUtil.swap(arr, i, p);
        }
    }

    public static void perm(int[] array, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                AlgorithmUtil.swap(array, start, i);
                perm(array, start + 1, end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                AlgorithmUtil.swap(array, start, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = new int[]{1, 2, 3};
        Pernum.perm(arr, 0, arr.length - 1);
    }

}
