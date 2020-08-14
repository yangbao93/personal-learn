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

    public static void abs2(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int count = 0;
        while (start <= end) {
            int absStart = Math.abs(a[start]);
            int absEnd = Math.abs(a[end]);
            count++;
            while (start <= end && absStart == Math.abs(a[start])) {
                start++;
            }
            while (start <= end && absEnd == Math.abs(a[end])) {
                end--;
            }
        }
        count++;
        System.out.println(count);
    }

    public static void printLeftFirst(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i]) {
                    System.out.println(String.format("%s左边第一个大于它的数是%s", a[i], a[j]));
                    break;
                }
            }
        }
    }

    public static void hourMin() {
        for (int i = 0; i < 24 * 60; i++) {
            double min = 6 * i;
            double hour = 0.5 * i;
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-1, 0, 1, 3, -3};
//        int[] arr = new int[]{-1, 0};
//        int[] arr = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr = new int[]{0, 7, 2, 4, 3, 5, 8};
        abs(arr);
        abs2(arr);
        printLeftFirst(arr);
    }

}
