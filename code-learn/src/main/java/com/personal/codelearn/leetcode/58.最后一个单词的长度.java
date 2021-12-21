package com.personal.codelearn.leetcode;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution58 {
    public int lengthOfLastWord(String s) {
        int wordSize = 0;
        int tmpWordSize = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != ' ') {
                ++tmpWordSize;
            } 
            if (sChar[i] == ' ' || i == sChar.length-1) {
                wordSize = tmpWordSize == 0 ? wordSize : tmpWordSize;
                tmpWordSize = 0;
            }
        }
        return wordSize;
    }

    // public static void main(String[] args) {
    //     Solution so = new Solution();
    //     int a = so.lengthOfLastWord("luffy is still joyboy");
    //     System.out.println(a);
    // }
}
// @lc code=end
