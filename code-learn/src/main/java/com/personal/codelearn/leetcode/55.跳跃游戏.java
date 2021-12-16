package com.personal.codelearn.leetcode;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution55 {
    // [2,3,1,1,4]
    // [3,2,1,0,4]
    public boolean canJump(int[] nums) {
        // 我们能走的最大距离
        int weCanJump = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前索引无法被到达，则表示不能到达后续，所以直接置为false
            if (i > weCanJump) {
                return false;
            }
            // 记录最大的可到达距离，之前最大与当前最大的举例 取最大值
            // 上一步能到达的最大距离 weCanJump
            // 当前步骤能到到的最大距离，i+nums[i]]
            weCanJump = Math.max(weCanJump, i + nums[i]);
        }
        return true;
    }

    // public static void main(String[] args) {
    //     Solution so = new Solution();
    //     int[] nums = new int[] { 3, 2, 1, 0, 4 };
    //     System.out.println(so.canJump(nums));
    // }

}
// @lc code=end
