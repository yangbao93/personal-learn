package com.personal.codelearn.leetcode;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        // 从左到右,即从大到小;
        int i = nums.length - 2;
        // 大于等于最低位,低位 >= 高位
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // j初始为最高位
            int j = nums.length - 1;
            // 找到
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
