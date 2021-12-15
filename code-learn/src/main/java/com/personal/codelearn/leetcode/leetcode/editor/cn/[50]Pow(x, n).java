package com.personal.codelearn.leetcode.leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 636 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {
    public double myPow(double x, int n) {
        if (x == 0 ) {
            return x;
        }

        double pow = myPow(x, n / 2);
        if (n % 2 == 0) {
            return pow * pow;
        }
        if (n > 0) {
            return pow * pow * x;
        }
        return pow * pow /x;
    }

    public static void main(String[] args) {
        Solution50 so = new Solution50();
        //System.out.println(so.myPow(2.00000, 10));
        //System.out.println(so.myPow(2.10000, 3));
        System.out.println(so.myPow(1.00000, 2147483647));
        //输入：x = 2.00000, n = -2
        //输出：0.25000
    }
}
//leetcode submit region end(Prohibit modification and deletion)
