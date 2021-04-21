package com.personal.codelearn.leetcode.leetcode.editor.cn;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1309 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null) {
            return result.stream().collect(Collectors.toList());
        }
        for (int i = 0; i < nums.length; i++) {
            core(nums, 0, nums.length, new ArrayList<>(), result);
        }
        return result.stream().collect(Collectors.toList());
    }

    public void core(int[] nums, int i, int length, List<Integer> tmpList, Set<List<Integer>> result) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (tmpList.contains(nums[j])) {
                continue;
            }
            tmpList.add(nums[j]);
            core(nums, j, length, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    //public static void main(String[] args) {
    //    int[] nums = new int[] {1, 2, 3};
    //    Solution solution = new Solution();
    //    System.out.println(JSON.toJSONString(solution.permute(nums)));
    //    System.out.println("end");
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
