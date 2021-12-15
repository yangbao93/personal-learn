package com.personal.codelearn.leetcode;

/**
 * 字符串匹配问题
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // 动态规划
        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1] [len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s = "abcabczzzde";
        String p = "*abc???de*";
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch(s, p));
    }
}
