package com.personal.codelearn.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String str = "()(())";
        LongestValidParentheses32 longestValidParentheses32 = new LongestValidParentheses32();
        System.out.println(longestValidParentheses32.longestValidParentheses(str));
    }
}
