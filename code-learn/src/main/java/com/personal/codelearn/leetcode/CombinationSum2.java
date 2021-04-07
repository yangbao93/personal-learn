package com.personal.codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class CombinationSum2 {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        core(candidates, target, 0, new ArrayList<Integer>(), result);
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(result);
        return set.stream().collect(Collectors.toList());
    }

    /**
     * 核心代码
     *
     * @param candidates 数组
     * @param target     目标值
     * @param pos        当前位置
     * @param tmpList    临时数组位置
     * @param result     结果存放位置
     */
    public void core(int[] candidates, int target, int pos, ArrayList<Integer> tmpList,
        List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
        }
        for (int i = pos; i < candidates.length; i++) {
            // 增加
            tmpList.add(candidates[i]);
            core(candidates, target - candidates[i], i + 1, tmpList, result);
            // 移除
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int[] c = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(JSON.toJSONString(cs.combinationSum2(c, target)));
    }
    //
    //[
    //    [1, 7],
    //    [1, 2, 5],
    //    [2, 6],
    //    [1, 1, 6]
    //    ]
}
