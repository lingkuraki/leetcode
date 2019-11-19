package com.kuraki.algorithms.easy;

/**
 * @author kuraki
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = (max + min) / 2;
        while (nums[mid] != target) {
            if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            if (min <= max) {
                mid = (max + min) / 2;
            } else {
                break;
            }
        }
        return nums[mid] == target ? mid : -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(arr, 9));
    }
}
