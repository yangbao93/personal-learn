package com.personal.codelearn.leetcode;

public class CountAndSay38 {

    public String countAndSay(int n) {
        if (n > 30 || n < 1) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        return say("1", n - 1);
    }

    private String say(String str, int times) {
        if (times == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int mark = 1;
        for (int i = 0; i < str.length(); i++) {
            // 当最后一个的时候,需要处理
            if (i + 1 >= str.length()) {
                sb.append(mark).append(str.charAt(i));
                break;
            }
            if (str.charAt(i) == str.charAt(i + 1)) {
                mark++;
            }
            if (str.charAt(i) != str.charAt(i + 1)) {
                sb.append(mark).append(str.charAt(i));
                mark = 1;
            }
        }
        return say(sb.toString(), times - 1);
    }

    public static void main(String[] args) {
        CountAndSay38 s = new CountAndSay38();
        System.out.println(s.countAndSay(4));
        //String str = "111221";
        //StringBuilder sb = new StringBuilder();
        //int mark = 1;
        //for (int i = 0; i < str.length(); i++) {
        //    // 当最后一个的时候,需要处理
        //    if (i + 1 >= str.length()) {
        //        sb.append(mark).append(str.charAt(i));
        //        break;
        //    }
        //    if (str.charAt(i) == str.charAt(i + 1)) {
        //        mark++;
        //    }
        //    if (str.charAt(i) != str.charAt(i + 1)) {
        //        sb.append(mark).append(str.charAt(i));
        //        mark = 1;
        //    }
        //}
        //System.out.println(sb.toString());
    }
}
