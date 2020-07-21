package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSort {

    public int[] sort(int[] oriList, int left, int right) {
        if (left >= right) {
            return oriList;
        }
        int start = left;
        int end = right;
        // 使用pivotVal会导致排序出错,暂时没想清楚问题原因[3,10,9,3,6,7,7,6] -> [3,3,6,6,9,7,7,10]
        // int pivot = (right - left) / 2;
        // int pivotVal = oriList[pivot];
        int pivotVal = oriList[left];
        while (left < right) {
            while ((left < right) && oriList[right] > pivotVal) {
                right--;
            }
            while ((left < right) && oriList[left] < pivotVal) {
                left++;
            }
            // 开始使用integer数组,在次数left = right = 4656 时候 == 判断它们是不相等的,陷入死循环
            if ((left < right) && oriList[left] == oriList[right]) {
                left++;
                continue;
            }
            if ((left < right) && oriList[left] >= oriList[right]) {
                swap(oriList, left, right);
            }
        }
        // 使用如下方法会导致Stack Overflow,因为边界设置的问题;比如两分[(0-1/2),(1/2-1)]后的两分,会导致出现[(0-1/4),(1/4-1)]
        // oriList = sort(oriList, 0, left - 1);
        // oriList = sort(oriList, right + 1, oriList.length - 1);
        oriList = sort(oriList, start, left - 1);
        oriList = sort(oriList, right + 1, end);
        return oriList;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public static void main(String[] args) {
        QuickSort qc = new QuickSort();
        log.info("排序前的数组为:{}", JSONObject.toJSONString(AlgorithmUtil.SORT_ARR_2));
        int[] sortArr = qc.sort(AlgorithmUtil.SORT_ARR_2, 0, AlgorithmUtil.SORT_ARR_2.length - 1);
        log.info("排序后的数组为:{}", JSONObject.toJSONString(sortArr));
    }


}
