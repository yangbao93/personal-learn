package com.personal.codelearn.leetcode.leetcode.editor.cn;
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串 
// 👍 391 👎 0

import com.alibaba.fastjson.JSON;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution344 {
    public void reverseString(char[] s) {
        rev(s, 0);
    }

    public void rev(char[] s, int pos) {
        if (pos > (s.length - pos - 1)) {
            return;
        }
        char tmp = s[pos];
        s[pos] = s[s.length - pos - 1];
        s[s.length - pos - 1] = tmp;
        rev(s, ++pos);
    }

    //public static void main(String[] args) {
    //    Solution344 so = new Solution344();
    //    char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
    //    so.reverseString(s);
    //    System.out.println(JSON.toJSONString(s));
    //}
}
//leetcode submit region end(Prohibit modification and deletion)

