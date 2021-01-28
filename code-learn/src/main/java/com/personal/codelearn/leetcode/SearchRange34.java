package com.personal.codelearn.leetcode;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置 时间复杂度为O(logN)
 *
 * @author yangbao
 */
public class SearchRange34 {

    /**
     * 由于需要logN的时间复杂度,所以优先使用二分法进行查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        // 位置的结果集合
        List<Integer> targetPos = new ArrayList<>();
        // 二分查找
        binarySearch(0, nums.length - 1, nums, target, targetPos);
        // 对比结果
        if (targetPos == null || targetPos.size() == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{Collections.min(targetPos), Collections.max(targetPos)};
    }

    void binarySearch(int low, int high, int[] nums, int target, List<Integer> posList) {
        // 边界值问题
        if (low >= high) {
            // 防止出现[]的情况
            if (nums != null && nums.length > 0 && nums[low] == target) {
                posList.add(low);
            }
            return;
        }
        int mid = (low + high) / 2;
        // 先查左边
        binarySearch(low, mid, nums, target, posList);
        // 再查右边
        binarySearch(mid + 1, high, nums, target, posList);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums2 = new int[]{};
        SearchRange34 searchRange34 = new SearchRange34();
        System.out.println(JSON.toJSONString(searchRange34.searchRange(nums, 8)));
        System.out.println(JSON.toJSONString(searchRange34.searchRange(nums, 6)));
        System.out.println(JSON.toJSONString(searchRange34.searchRange(nums2, 6)));
    }


}
