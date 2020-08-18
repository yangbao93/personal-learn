package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ：yangbao
 * @description：希尔排序
 * @version:
 * @date ：Created in 2020/8/4 4:00 下午
 * @modified By：
 */
public class XierSort {

    public static void sort(int[] arr, int left, int right) {
        // 找出递归的结束条件
        if (left >= right) {
            return;
        }
        // 找出中间索引
        int center = (left + right) / 2;
        // 左边数组进行递归
        sort(arr, left, center);
        // 右边数据进行递归
        sort(arr, center + 1, right);
        // 合并数据
        merge(arr, left, center, right);

    }

    private static void merge(int[] arr, int left, int center, int right) {
        // 创建临时数组
        int[] tmpArr = new int[arr.length];
        // 右边数组第一个元素索引
        int mid = center + 1;
        // 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (arr[left] <= arr[mid]) {
                tmpArr[third++] = arr[left++];
            } else {
                tmpArr[third++] = arr[mid++];
            }
            // 剩余部分依次放入临时数组(实际上两个 while 只会执行其中一个)
            while (mid <= right) {
                tmpArr[third++] = arr[mid++];
            }
            while (left <= center) {
                tmpArr[third++] = arr[left++];
            }
            // 将临时数组中的内容拷贝回原数组中
            // (原 left-right 范围的内容被复制回原数组)
            while (tmp <= right) {
                arr[tmp] = tmpArr[tmp++];
            }
        }
    }

    public static void newShellSort(int[] arr) {
        // 希尔排序开始        
        // 设gap为增量        
        int addValue = 2;
        int gap = arr.length / addValue;
        // 外循环：增量gap每次变小，直到为1
        for (; gap > 0; gap /= addValue) {
            // 内循环：进行插入排序，从每个分组的第gap个元素开始，而不是从它的第一个元素开始    
            for (int i = gap; i < arr.length; i++) {
                // 如果小于前一个元素，进行交换，把小的换到前面来
                if (arr[i] < arr[i - gap]) {
                    // 保存小的元素    
                    int temp = arr[i];
                    // 记录前一个比它大的角标    
                    int k = i - gap;
                    // 如果该组元素中，前几个元素都比a[i]大，则执行后移，把比a[i]大的都移动到a[i]后面   
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    // 此时a[k]<a[i],a[i]放到啊a[k]右边    
                    arr[k + gap] = temp;
                }
            }
        }

    }

    /**
     * 修改后的希尔排序
     * @param array
     */
    public static void shell(int[] array) {
        //希尔排序的增量
        int d = array.length;
        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7,10};
//        sort(data, 0, data.length - 1);
//        System.out.println(JSONObject.toJSONString(data));
//        newShellSort(data);
        shell(data);
        System.out.println(JSONObject.toJSONString(data));

    }

}