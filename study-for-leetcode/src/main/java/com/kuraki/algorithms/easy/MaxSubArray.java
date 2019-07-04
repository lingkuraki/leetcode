package com.kuraki.algorithms.easy;

/**
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    public int searchMaxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = nums[0], anx = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 获取最大的子序列；当某元素大于累积和时，重新计算。
            sum = Math.max(nums[i], sum + nums[i]);
            // 存储每次的累积和，也就是sum。最后留下的就是最大的
            anx = Math.max(anx, sum);
        }
        return anx;
    }

    public int searchMaxSubArray1(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0, ans = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
