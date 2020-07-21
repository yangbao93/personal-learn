package com.personal.codelearn.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * @author ：yangbao
 * @description：
 * @version: $
 * @date ：Created in 2020/7/21 2:59 下午
 * @modified By：
 */
public class StackLearn {

    public static int[] findRightMaxNum(int[] arr) {
        if (arr == null) {
            return null;
        }
        int size = arr.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while (index < size) {
            if (!stack.isEmpty() && arr[index] > arr[stack.peek()]) {
                result[stack.pop()] = arr[index];
            } else {
                stack.push(index);
                index++;
            }
        }
        if (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static int[] findLeftMaxNum(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        int index = arr.length - 1;
        while (index > 0) {
            if (!stack.isEmpty() && arr[index] > arr[stack.peek()]) {
                result[stack.pop()] = arr[index];
            } else {
                stack.push(index);
                index--;
            }
        }
        if (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, -1, 3, 4, 5, 6};
        int[] rightMaxNum = findRightMaxNum(arr);
        System.out.println(JSONObject.toJSON(rightMaxNum));
        int[] leftMaxNum = findLeftMaxNum(arr);
        System.out.println(JSONObject.toJSON(leftMaxNum));
    }
}
