package com.personal.codelearn.leetcode.leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1617 👎 0

// 2021-04-22 17:25:10
//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {

    int sum = 0;

    public int climbStairs(int n) {
        climb(n);
        return sum;
    }

    public void climb(int n) {
        if (n <= 0) {
            if (n == 0) {
                sum+=1;
            }
            return;
        }
        climb(n - 1);
        climb(n - 2);
    }

    public static void main(String[] args) {
        Solution70 so = new Solution70();
        System.out.println(so.climbStairs(44));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
