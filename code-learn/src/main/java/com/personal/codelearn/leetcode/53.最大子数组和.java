package com.personal.codelearn.leetcode;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start

class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            // 此处是解决问题的关键，最大的子数之和不能加出来负数
            // 所以当加出来是负数的时候就应该对其抛弃，即只需要一次遍历即可
            if (sum < 0) {
                sum = 0;
            }

        }
        return max;
    }

    /**
     * 可解决，但是超出时间限制，需要更优的解决方案
     * 
     * @param nums 数组
     * @return 结果
     */
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmpMax = nums[i];
            max = tmpMax > max ? tmpMax : max;
            for (int j = i + 1; j < nums.length; j++) {
                tmpMax += nums[j];
                max = tmpMax > max ? tmpMax : max;
            }
        }
        return max;
    }

    // public static void main(String[] args) {
    //     Solution so = new Solution();
    //     int[] nums = new int[] { -2, 1 };
    //     System.out.println(so.maxSubArray(nums));
    // }
}
// @lc code=end
