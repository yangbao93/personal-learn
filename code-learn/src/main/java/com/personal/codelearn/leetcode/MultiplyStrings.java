package com.personal.codelearn.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    //给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2 的乘积，它们的乘积也表示为字符串形式。
    //
    //示例 1:
    //
    //输入: num1 = "2", num2 = "3"
    //输出: "6"
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/multiply-strings
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String multiply(String num1, String num2) {
        // 边界问题处理
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // 乘数的每一位都与被乘数相乘,获得每个结果,这个结果集相加就是最终的结果
        List<String> partString = new ArrayList<>();
        // 分组相乘(需要倒序)
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            // 高位需要补0(乘数的最后一位不用补0,倒数第二位补1个0,...)
            for (int k = 0; k < (num2.length() - 1) - i; k++) {
                sb.append("0");
            }
            // 注意进位问题,此处默认进0
            int highLevel = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int x = (num1.charAt(j) - '0');
                int y = (num2.charAt(i) - '0');
                int xy = x * y + highLevel;
                highLevel = xy / 10;
                sb.append(xy % 10);
            }
            // 防止出现最高位需要进位,但是没有处理的问题
            if (highLevel != 0) {
                sb.append(highLevel);
            }
            partString.add(sb.reverse().toString());
        }
        List<BigInteger> part2 = new ArrayList<>();
        BigInteger a = new BigInteger("0");
        for (String ins : partString) {
            BigInteger valueOf = new BigInteger(ins);
            a = a.add(valueOf);
            part2.add(a);
        }
        // 对进行两两相加
        String resultStr = partString.get(0);
        for (int i = 1; i < partString.size(); i++) {
            resultStr = stringAdd(resultStr, partString.get(i));
        }
        return resultStr;
    }

    public String stringAdd(String a1, String a2) {
        Stack<Character> a1Stack = new Stack<>();
        for (int i = 0; i < a1.length(); i++) {
            a1Stack.push(a1.charAt(i));
        }
        Stack<Character> a2Stack = new Stack<>();
        for (int i = 0; i < a2.length(); i++) {
            a2Stack.push(a2.charAt(i));
        }
        int highLevel = 0;
        StringBuilder sb = new StringBuilder();
        while ((!a2Stack.isEmpty()) && (!a1Stack.isEmpty())) {
            int x = a1Stack.pop() - '0';
            int y = a2Stack.pop() - '0';
            int xy = x + y + highLevel;
            sb.append(xy % 10);
            highLevel = xy / 10;
        }
        // 处理a1
        while (!a1Stack.isEmpty()) {
            int x = a1Stack.pop() - '0';
            int xy = x + highLevel;
            highLevel = xy / 10;
            sb.append(xy % 10);
        }
        // 处理a2
        while (!a2Stack.isEmpty()) {
            int x = a2Stack.pop() - '0';
            int xy = x + highLevel;
            highLevel = xy / 10;
            sb.append(xy % 10);
        }
        // 处理最终的进位
        if (highLevel != 0) {
            sb.append(highLevel);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String nums1 = "123456789";
        String nums2 = "987654321";
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply(nums1, nums2));
        //ms.stringAdd("1123", "321");
    }
}
