package com.personal.codelearn.leetcode.leetcode.editor.cn;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 481 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

import org.apache.commons.collections.CollectionUtils;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        rev(res, numRows, 0);
        return res;
    }

    public void rev(List<List<Integer>> res, int max, int cur) {
        if (cur == max) {
            return;
        }
        if (res == null || res.size() == 0) {
            res.add(Arrays.asList(1));
        } else {
            List<Integer> parentList = res.get(cur - 1);
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i <= cur; i++) {
                Integer left = (i - 1 < 0) ? 0 : parentList.get(i - 1);
                Integer right = i >= parentList.size() ? 0 : parentList.get(i);
                curList.add(left + right);
            }
            res.add(curList);
        }
        rev(res, max, ++cur);
    }

    //public static void main(String[] args) {
    //    Solution so = new Solution();
    //    System.out.println(JSON.toJSONString(so.generate(3)));;
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
