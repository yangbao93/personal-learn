package com.personal.codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class CombinationSum39 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        core(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }

    public void core(int[] candidates, int target, int pos, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            core(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        CombinationSum39 cs = new CombinationSum39();
        int[] c = new int[] {2, 3, 6, 7};
        int target = 7;
        cs.combinationSum(c, target);
        System.out.println(JSON.toJSONString(cs.result));
    }
}
