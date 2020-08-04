package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ：yangbao
 * @description：归并排序
 * @version: $
 * @date ：Created in 2020/8/4 5:26 下午
 * @modified By：
 */
public class GuibingSort {

    // 递归方法，实现对序列的分割和合并
    // 传入的是待排序列，要生成的新序列，序列开始和结尾角标
    public static void mergingSort(int[] oldArray, int[] newArray, int start, int end) {
        //定义该值将序列从中间分割
        int mid;
        //定义一个临时数组容纳被分割的数组
        int[] tempArray = new int[oldArray.length];
        //如果数组头角标==尾角标，则序列待排仅一个元素，新序列就是旧序列
        //推理可知，递归进行到最后，序列一定会被分割成单个元素
        if (start == end) {
            newArray[start] = oldArray[start];
        } else {
            //取中值
            mid = (start + end) / 2;
            //分别对新分割好的序列进行分割
            mergingSort(oldArray, tempArray, start, mid);
            mergingSort(oldArray, tempArray, mid + 1, end);
            //对分割好的序列进行排序和合并操作
            merge(tempArray, newArray, start, mid, end);
        }
    }

    public static void merge(int[] tempArray, int[] newArray, int start, int mid, int end) {
        int j, k, l;
        //已知每个序列被分割成了两个序列，左和右序列
        //从左和右序列的最小角标开始，依次进行比较
        for (j = mid + 1, k = start; start <= mid && j <= end; k++) {
            //temp[i]到temp[mid]左序列 temp[mid+1]到temp[end]右序列
            //左序列当前元素小，就先放到新序列里 反之，右序列当前元素先放入
            //该句元素比较代码说明了其是稳定的
            if (tempArray[start] < tempArray[j]) {
                newArray[k] = tempArray[start++];
            } else {
                newArray[k] = tempArray[j++];
            }
        }
        //上个操作完成后，左或右序列可能有剩余，继续讲剩余元素补充到新序列中
        if (start <= mid) {
            for (l = 0; l <= mid - start; l++) {
                newArray[k + l] = tempArray[start + l];
            }
        }
        if (j <= end) {
            for (l = 0; l <= end - j; l++) {
                newArray[k + l] = tempArray[j + l];
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7, 10};
        int[] newArr = new int[data.length];
        mergingSort(data, newArr, 0, data.length - 1);
        System.out.println(JSONObject.toJSONString(newArr));
    }
}
