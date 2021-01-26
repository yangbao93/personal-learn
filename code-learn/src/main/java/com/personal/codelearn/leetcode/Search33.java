package com.personal.codelearn.leetcode;

/**
 * 33. 搜索旋转排序数组
 * 对于题目的描述产生怀疑,暴力解法即可;但考察问题并非如此
 *
 * @author yb
 */
public class Search33 {

    public static int search(int[] nums, int target) {
        // 排除一个的情况
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 找到需旋转点
        int pos = 0;
        // 标记是没有旋转点,还是旋转点是0
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pos = i;
                flag = true;
                break;
            }
        }
        // 如果没有旋转点 则需要设置整体的长度,因为在下面的if 判断条件不是很完美
        if (!flag) {
            pos = pos == 0 ? nums.length - 1 : pos;
        }
        // 确定target在左边还是右边
        if (nums[0] <= target) {
            return searchPart(0, pos, nums, target);
        } else {
            return searchPart(pos + 1, nums.length - 1, nums, target);
        }
    }

    /**
     * 二分查找判断是否满足
     *
     * @param low    低位
     * @param high   高位
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    private static int searchPart(int low, int high, int[] nums, int target) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return nums[low] == target ? low : -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] >= target) {
            return searchPart(low, mid, nums, target);
        } else {
            return searchPart(mid + 1, high, nums, target);
        }
    }


    /**
     * 暴力解法 不推荐
     *
     * @param nums   数组
     * @param target 目标
     * @return 目标下标
     */
    @Deprecated
    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // nums = [4,5,6,7,0,1,2], target = 0
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 4));
    }
}
