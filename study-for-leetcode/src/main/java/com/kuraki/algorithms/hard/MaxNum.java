package com.kuraki.algorithms.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kuraki
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class MaxNum {

    /**
     * Java8 Stream流处理
     */
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .forEach(sb::append);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    /**
     * 传统处理方式
     */
    private static class LargerNumberComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    public String largestNumber2(int[] nums) {
        // 将int数组转为String数组
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        // 对数组进行排序
        Arrays.sort(strArr, new LargerNumberComparator());
        if ("0".equals(strArr[0])) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
