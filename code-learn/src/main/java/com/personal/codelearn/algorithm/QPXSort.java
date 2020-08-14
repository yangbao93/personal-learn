package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.apache.spark.sql.sources.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：yangbao
 * @description：从N个数中取K个数
 * @version: $
 * @date ：Created in 2020/8/4 7:46 下午
 * @modified By：
 */
public class QPXSort {

    public static void sort(int[] a, int m, int k) {
        int i, j;
        for (i = m; i >= k; i--) {
            a[k] = i;
            if (k > 1) {
                sort(a, i - 1, k - 1);
            } else {
                for (j = a[0]; j > 0; j--) {
                    System.out.printf("%d", a[j]);
                }
                System.out.printf("\n");
            }
        }
    }


    /**
     * 计算n的阶乘：n! = n * (n-1) * (n-2) * ... *2 * 1
     */
    public static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数：A(n, m) = n!/(n-m)!  -- 从n个数中取出m个数进行排列 ,需要考虑数的顺序 (如果n个数进行排列，有n!种情况)
     */
    public static long arrangement(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 计算组合数：C(n, m) = n!/((n-m)! * m!)  --  从n个数中取出m个数进行排列 ,不考虑数的顺序 （如 1234 和 4321 属于一种组合，都包含1，2，3，4这四个数）
     */
    public static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / (factorial(n - m) * factorial(m)) : 0;
    }

    /**
     * 排列：从数组a中选择n个数进行排列
     */
    public static void arrangementSelect(int[] a, int n) {
        System.out.println(String.format("A(%d, %d) = %d", a.length, n, arrangement(a.length, n)));
        arrangementSort(a, new int[n], 0);
    }

    /**
     * 通过递归的方式罗列出所有的排列结果
     *
     * @param a：初始数组
     * @param result：排列数组初始状态
     * @param resultIndex：比较的起始索引
     */
    public static void arrangementSort(int[] a, int[] result, int resultIndex) {
        int result_length = result.length;
        if (resultIndex >= result_length) {
            System.out.println(Arrays.toString(result));  // 输出排列结果
            return;
        }
        //
        for (int i = 0; i < a.length; i++) {
            // 判断待选的数是否存在于排列的结果中
            boolean exist = false;
            for (int j = 0; j < resultIndex; j++) {
                if (a[i] == result[j]) {  // 若已存在，则不能重复选
                    exist = true;
                    break;
                }
            }
            if (!exist) {  // 若不存在，则可以选择
                result[resultIndex] = a[i];
                arrangementSort(a, result, resultIndex + 1);
            }
        }
    }

    /**
     * 组合：从数组a中选择n个数进行组合
     */
    public static void combinationSelect(int a[], int n) {
        System.out.println(String.format("C(%d, %d)= %d", a.length, n, combination(a.length, n)));
//        combinationSort(a, 0, new int[n], 0);
        combinationSort2(a, new int[n], 0, 0);

    }

    /**
     * 通过递归的方式罗列出所有的组合结果
     *
     * @param a：初始数组
     * @param a_index：初始数组起始下标
     * @param result：初始组合数组
     * @param r_index：初始组合数组的起始下标
     */
    public static void combinationSort(int[] a, int a_index, int[] result, int r_index) {
        int r_len = result.length;
        int r_count = r_index + 1;
        if (r_count > r_len) {
            System.out.println(Arrays.toString(result));  // 输出组合结果
            return;
        }
        for (int i = a_index; i < a.length + r_count - r_len; i++) {
            result[r_index] = a[i];
            combinationSort(a, i + 1, result, r_index + 1);
        }
    }


    // 修改后的
    public static void combinationSort2(int[] a, int[] result, int left, int right) {
        if (right >= result.length) {
            System.out.println(Arrays.toString(result));  // 输出组合结果
            return;
        }
        for (int i = left; i < a.length ; i++) {
            result[right] = a[i];
            combinationSort2(a, result, i + 1, right + 1);
        }
    }


    public static void arrangementSelectBySelf(int[] a, int n) {
        System.out.println(String.format("A(%d, %d) = %d", a.length, n, arrangement(a.length, n)));
        arrangementSortBySelf(a, new int[n], 0);
    }

    // 修改后的
    public static void arrangementSortBySelf(int[] a, int[] result, int index) {
        if (index >= result.length) {
            System.out.println(JSONObject.toJSONString(result));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            // 如果已经选择,则不能重复选择
            boolean exist = false;
            for (int j = 0; j < index; j++) {
                if (a[i] == result[j]) {  // 若已存在，则不能重复选
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                result[index] = a[i];
                arrangementSortBySelf(a, result, index + 1);
            }
        }
    }


    public static void main(String[] args) {
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] b = new int[3];
////        sort(a, 9, 2);

        int[] a = {1, 2, 3, 4, 5, 6};  // 初始数组
//        arrangementSelect(a, 3);
        combinationSelect(a, 6);
        arrangementSelectBySelf(a, 3);
    }
}
