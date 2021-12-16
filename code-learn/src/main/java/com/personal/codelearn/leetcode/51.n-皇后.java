package com.personal.codelearn.leetcode;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
import java.util.List;

import com.google.common.collect.Lists;

class Solution222 {
    public List<List<String>> solveNQueens(int n) {
        // 判断是否超出了界限范围
        if (n > 9 || n < 0) {
            return Lists.newArrayList();
        }
        // 初始化棋盘
        String[][] queenArr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queenArr[i][j] = ".";
            }
        }
        // 利用回溯法进行处理
        return null;

    }

    public static void main(String[] args) {
        System.out.println("n queens");
    }
}
// @lc code=end
