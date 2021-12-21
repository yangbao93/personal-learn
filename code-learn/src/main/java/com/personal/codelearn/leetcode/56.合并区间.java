package com.personal.codelearn.leetcode;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 如果为空，返回默认值
        if (intervals == null) {
            return new int[0][2];
        }
        // 针对数组进行排序
        // Arrays.sort(intervals,new Comparator<int[]>{
        //     public int compare(int[] interval1, int[] interval2) {
        //         return interval1[0] - interval2[0];
        //     }
        // });
        // 排序后对数组进行解决
        return intervals;
    }
}
// @lc code=end
