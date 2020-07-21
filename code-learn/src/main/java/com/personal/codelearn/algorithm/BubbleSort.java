package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSort {

    // 参考资料:https://www.cnblogs.com/bigdata-stone/p/10464243.html
    // 时间复杂度,最好是O(n),最坏是O(n^2)

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    AlgorithmUtil.swap(arr, i, j);
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] sort1 = sort.sort(AlgorithmUtil.SORT_ARR_1);
        log.info("原始数组1为:{}", JSONObject.toJSONString(AlgorithmUtil.SORT_ARR_1));
        log.info("排序后数组1为:{}", JSONObject.toJSONString(sort1));
        int[] sort2 = sort.sort(AlgorithmUtil.SORT_ARR_2);
        log.info("原始数组2为:{}", JSONObject.toJSONString(AlgorithmUtil.SORT_ARR_2));
        log.info("排序后数组2为:{}", JSONObject.toJSONString(sort2));
    }
}
