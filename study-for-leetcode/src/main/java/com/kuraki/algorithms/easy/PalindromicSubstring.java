package com.kuraki.algorithms.easy;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 */
public class PalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 之所以调用过两次，是因为偶数和奇数的中心不一样
            // 奇数的中心扩散
            int len1 = expandAroundCenter(s, i, i);
            // 偶数的中心扩散
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 获取回文的起始索引
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        // 以中心向两边扩散，一直相等，一直循环
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 返回这个回文的长度
        return r - l - 1;
    }
}
