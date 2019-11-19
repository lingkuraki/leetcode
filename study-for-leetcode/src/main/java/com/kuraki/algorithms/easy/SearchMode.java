package com.kuraki.algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuraki
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class SearchMode {

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1));
        return map;
    }

    public int majorityElementByHash(int[] nums) {
        Map<Integer, Integer> map = countNums(nums);
        Map.Entry<Integer, Integer> mode = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (mode == null || entry.getValue() > mode.getValue()) mode = entry;
        }
        return mode.getKey();
    }

    public int majorityElement(int[] nums) {
        assert nums.length != 0;
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}
