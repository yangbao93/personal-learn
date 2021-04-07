package com.personal.codelearn.leetcode;

import com.alibaba.fastjson.JSON;

public class FirstMissingPositive {

    //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    //进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
    //示例 1：
    //输入：nums = [1,2,0]
    //输出：3
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/first-missing-positive
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //    0 <= nums.length <= 300
    //    -2^31 <= nums[i] <= 2^31 - 1
    public int firstMissingPositive(int[] nums) {
        // 思路:申请一个数组tmp,为nums的length大小,然后将nums[i]中的数,放在tmp[nums[i]-1]中
        // 如果不超限则放,超限则抛弃,这样第一个为0的就是最小正整数了
        // 因为数组是0~300,所以最小正整数是1~301
        int[] tmp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int tmp_num = nums[i];
            if (tmp_num > 0 && tmp_num <= nums.length) {
                tmp[tmp_num - 1] = tmp_num;
            }
        }
        int result = 1;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 0) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] {7, 8, 9, 11, 12};
        FirstMissingPositive fp = new FirstMissingPositive();
        System.out.println(JSON.toJSONString(fp.firstMissingPositive(a)));
    }
}
