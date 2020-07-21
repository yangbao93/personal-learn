package com.personal.codelearn.algorithm;

public class AlgorithmUtil {

    /**
     * 排序数组1
     */
    public static int SORT_ARR_1[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};

    /**
     * 排序数组2
     */
    public static int SORT_ARR_2[] = new int[]{3, 10, 9, 3, 6, 7, 7, 6};

    /**
     * 翻转
     *
     * @param array 数组
     * @param x     下标
     * @param y     下标
     */
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
