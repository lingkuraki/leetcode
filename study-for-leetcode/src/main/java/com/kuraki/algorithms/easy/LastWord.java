package com.kuraki.algorithms.easy;

import org.junit.Test;

/**
 * 给定一个仅包含大小写字母和空格' '的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串
 */
public class LastWord {

    // 最简单的解法
    public int lengthOfLastWord(String s) {

        String[] s1 = s.split(" ");
        if (s1.length == 0) return 0;
        return s1[s1.length - 1].length();
    }

    // 效率较高的解法
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        if ("".equals(s)) return 0;

        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return j - i;
            }
        }
        return s.length();
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord1("a     "));
    }
}
