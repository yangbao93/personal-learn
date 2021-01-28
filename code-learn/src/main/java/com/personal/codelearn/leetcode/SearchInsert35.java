package com.personal.codelearn.leetcode;

/**
 * 35. 搜索插入位置
 * 方法一:暴力遍历O(N)
 * 方法二:二分
 *
 * @author yb
 */
public class SearchInsert35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        // 有可能右边界为要返回的值,而且不怕数组越界,因为mid是小于right的,当相等时代表left = right,此时不满足while的条件,退出循环
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                // 此处很重要
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 因为到最后必然是左边等于右边
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        SearchInsert35 searchInsert35 = new SearchInsert35();
        System.out.println(searchInsert35.searchInsert(nums, 5));
        System.out.println(searchInsert35.searchInsert(nums, 2));
        System.out.println(searchInsert35.searchInsert(nums, 7));
        System.out.println(searchInsert35.searchInsert(nums, 0));
    }


}
