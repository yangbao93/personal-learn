package com.personal.codelearn.algorithm;

/**
 * @author ：yangbao
 * @description：求数组内的平方,共有多少个不重复的数字
 * @version: $
 * @date ：Created in 2020/7/21 3:48 下午
 * @modified By：
 */
public class AbsLearn {

    public static void abs(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start <= end) {
            int sAbs = Math.abs(arr[start]);
            int eAbs = Math.abs(arr[end]);
            if (sAbs > eAbs) {
                count++;
                while (start <= end && Math.abs(arr[start]) == sAbs) {
                    start++;
                }
            } else if (sAbs < eAbs) {
                count++;
                while (start <= end && Math.abs(arr[end]) == eAbs) {
                    end--;
                }
            } else {
                count++;
                while (start <= end && Math.abs(arr[start]) == sAbs) {
                    start++;
                }
                while (start <= end && Math.abs(arr[end]) == eAbs) {
                    end--;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 3, -3};
        abs(arr);
    }

}
