package com.kuraki.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }


    public static int[] twoSums(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            // 防止重复利用同一个元素
            if (integer != null && integer != i) {
                arr[0] = i;
                arr[1] = integer;
                return arr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int[] ints = twoSums(arr, 6);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
