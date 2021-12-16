package com.personal.codelearn.leetcode;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

class Solution52 {
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
        System.out.println(JSON.toJSONString(queenArr));
        // 利用回溯法进行处理
        putQueen(queenArr, 0, 0);
        System.out.println(JSON.toJSONString(queenArr));
        return null;

    }

    public void putQueen(String[][] queenArr, int i, int j) {
        if (j < queenArr.length) {
            putQueen(queenArr, i, j++);
        }
        if (i < queenArr.length) {
            putQueen(queenArr, i++, j);
        }
        boolean canPut = canPutQueen(queenArr, i, j);
        if (canPut) {
            queenArr[i][j] = "Q";
        } else {
            queenArr[i][j] = ".";
        }
    }

    private boolean canPutQueen(String[][] queenArr, int h, int s) {
        // 检查横
        for (int i = 0; i < queenArr.length; i++) {
            if (queenArr[i][s] == "Q") {
                return false;
            }
        }
        // 检查竖
        for (int i = 0; i < queenArr.length; i++) {
            if (queenArr[h][i] == "Q") {
                return false;
            }
        }
        // 检查左斜
        int h1 = h;
        int s1 = s;
        while (h1 >= 0 && s1 >= 0) {
            if (isQueen(queenArr, h1, s1)) {
                return false;
            }
            h1--;
            s1--;
        }
        while (h1 < queenArr.length && s1 < queenArr.length) {
            if (isQueen(queenArr, h1, s1)) {
                return false;
            }
            h1++;
            s1++;
        }
        // 检查右斜
        int h2 = h;
        int s2 = s;
        while (h2 >= 0 && s2 < queenArr.length) {
            if (isQueen(queenArr, h2, s2)) {
                return false;
            }
            h2--;
            s2++;
        }
        while (h2 < queenArr.length && s2 >= 0) {
            if (isQueen(queenArr, h2, s2)) {
                return false;
            }
            h2++;
            s2--;
        }
        return true;
    }

    private boolean isQueen(String[][] queenArr, int h, int s) {
        return "Q".equals(queenArr[h][s]);
    }

    public static void main(String[] args) {
        // Solution so = new Solution();
        // so.solveNQueens(4);
    }
}
// @lc code=end
