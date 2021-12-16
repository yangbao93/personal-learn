package com.personal.codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 1.确定4个角
        int lt = 0;
        int rt = matrix[0].length - 1;
        int ld = 0;
        int rd = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        // while (lt <= rt && ld <= rd) {
        // // 解决上横
        // for (int i = lt; i <= rt; i++) {
        // result.add(matrix[lt][i]);
        // }
        // lt++;
        // // 解决右竖
        // for (int i = ld; i <= rd; i++) {
        // result.add(matrix[i][rt]);
        // }
        // rt--;
        // // 解决下横
        // for (int i = rt; i >= ld && ld < rd; i--) {
        // result.add(matrix[rd][i]);
        // }
        // rd--;
        // // 解决左竖
        // 有问题 { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // 如上述例子，4的坐标为(1,0)，而不是(0,1) 因为记错了，所以导致出错
        // for (int i = rd; i >= lt && lt<= rt; i--) {
        // result.add(matrix[i][ld]);
        // }
        // ld++;
        // }
        while (lt <= rt && ld <= rd) {
            for (int i = lt; i <= rt; i++) {
                result.add(matrix[ld][i]);
            }
            ld++;
            for (int i = ld; i <= rd; i++) {
                result.add(matrix[i][rt]);
            }
            rt--;
            for (int i = rt; i >= lt && ld <= rd; i--) {
                result.add(matrix[rd][i]);
            }
            rd--;
            for (int i = rd; i >= ld && lt <= rt; i--) {
                result.add(matrix[i][lt]);
            }
            lt++;
        }
        return result;
    }

    // public static void main(String[] args) {
    //     Solution so = new Solution();
    //     // String param = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";
    //     // param = param.replace("[", "{").replace("]", "}");
    //     // System.out.println(param);
    //     // int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    //     int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11,
    //             12 } };
    //     // int[][] matrix = new int[][] { { 2, 5 }, { 8, 4 }, { 0, -1 } };
    //     System.out.println(JSON.toJSONString(so.spiralOrder(matrix)));
    //     ;
    // }
}
// @lc code=end
