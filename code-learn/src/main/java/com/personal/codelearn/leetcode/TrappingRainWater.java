package com.personal.codelearn.leetcode;

import java.util.Arrays;
import java.util.Stack;

import org.apache.commons.lang.ArrayUtils;

public class TrappingRainWater {

    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //    6
    // https://leetcode-cn.com/problems/trapping-rain-water/

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // 找到最高点
        int max = height[0];
        int maxPos = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxPos = i;
            }
        }
        int area = 0;
        // 遍历左边
        int tmpLeft = height[0];
        for (int i = 0; i < maxPos; i++) {
            if (height[i] > tmpLeft) {
                tmpLeft = height[i];
            } else {
                area += tmpLeft - height[i];
            }
        }
        // 遍历右边
        int tmpRight = height[height.length - 1];
        for (int i = height.length - 1; i > maxPos; i--) {
            if (height[i] > tmpRight) {
                tmpRight = height[i];
            } else {
                area += tmpRight - height[i];
            }
        }
        return area;
    }

    /**
     * 单调栈的方案(出自 甜姨的奇妙冒险)
     *
     * @param height 数组
     * @return 结果
     */
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 遍历每个柱体
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottomIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                    // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                    // i - stack.peek() - 1 是雨水的宽度。
                    res += (Math.min(height[stack.peek()], height[i]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] a = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.trap(a));
    }

}
