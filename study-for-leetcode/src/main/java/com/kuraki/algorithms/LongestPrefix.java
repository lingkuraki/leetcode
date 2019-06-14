package com.kuraki.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestPrefix {

    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }

    public String longestCommonPrefix(String[] strs) {
        // 数组不存在或者为空数组则返回""
        if (strs == null || strs.length == 0) return "";
        // 数组长度若为1，则返回该元素
        if (strs.length == 1) return strs[0];
        String s1 = strs[0];
        String s2 = strs[1];
        int length = s1.length() < s2.length() ? s1.length() : s2.length();
        int i = 0;
        // 先取两个元素公共的前缀
        for (; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) break;
        }
        // 获取前缀
        String prefix = s1.substring(0, i);
        for (int j = 2; j < strs.length; j++) {
            // 如果减为0，贼说明没有公共前缀，返回""
            if (i == 0) {
                return "";
            }
            // 判断是否是公共前缀
            if (!strs[j].startsWith(prefix)) {
                i--;
                j = 1;
                // 重新获取公共前缀
                prefix = s1.substring(0, i);
            }
        }
        return prefix;
    }

    // 官方标准答案之一：水平扫描
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
