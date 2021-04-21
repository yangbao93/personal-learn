package com.personal.codelearn.leetcode.leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 725 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null) {
            return res;
        }
        Map<char[], List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char[] keyList = str.toCharArray();
            Arrays.sort(keyList);
            if (resMap.containsKey(keyList)) {
                List<String> list = resMap.get(keyList);
                list.add(str);
                resMap.put(keyList, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                resMap.put(keyList, list);
            }
        }
        res.addAll(resMap.values());
        return res;
    }

    //public static void main(String[] args) {
    //    String[] s = new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
    //    //String[] s = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    //    Solution49 so = new Solution49();
    //    System.out.println(JSON.toJSONString(so.groupAnagrams(s)));
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
