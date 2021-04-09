package com.personal.codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {

    public int jump(int[] nums) {
        // 思路为：选择能到达位置上最大的点，直到他们的和大于等于数组长度。选择几个数字就是需要跳跃几步
        // 记录我们走了几步
        int step = 0;
        // 记录我们在走到最远步的过程中，我可以到达的最远位置
        int maxPos = 0;
        // 记录我们最远到达的位置
        int maxStepPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // maxPos是计算当前位置能到达的最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            // 判断是否到达了最远位置，因为到了最远位置，我们这一步就算走完了，需要step++
            // 同时将我们的最远位置，设置成在到达此处时，我们可以走的最远位置
            if (i == maxStepPos) {
                maxStepPos = maxPos;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 4, 3, 2, 5, 4, 3 };
        Solution a2 = new Solution();
        System.out.println(a2.jump(nums));
    }
}
// @lc code=end
