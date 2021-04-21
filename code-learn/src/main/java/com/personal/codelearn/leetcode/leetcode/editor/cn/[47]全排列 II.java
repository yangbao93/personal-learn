package com.personal.codelearn.leetcode.leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 679 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        // 用于标记是否选择过该数字
        boolean[] pick = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            core(nums, i, new ArrayList<Integer>(), pick, res);
        }
        return res.stream().collect(Collectors.toList());
    }

    private void core(int[] nums, int i, List<Integer> tmp, boolean[] pick, Set<List<Integer>> res) {
        // 如果临时数组与nums的长度一致,表可输出
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 从头遍历
        for (int j = 0; j < nums.length; j++) {
            if (pick[j]) {
                continue;
            }
            tmp.add(nums[j]);
            pick[j] = true;
            core(nums, j, tmp, pick, res);
            tmp.remove(tmp.size() - 1);
            pick[j] = false;
        }
    }

    //public static void main(String[] args) {
    //    int[] nums = new int[] {1, 1, 3};
    //    //int[] nums = new int[] {1};
    //    Solution47 solution = new Solution47();
    //    System.out.println(JSON.toJSONString(solution.permuteUnique(nums)));
    //    System.out.println("end");
    //}

}
//leetcode submit region end(Prohibit modification and deletion)
