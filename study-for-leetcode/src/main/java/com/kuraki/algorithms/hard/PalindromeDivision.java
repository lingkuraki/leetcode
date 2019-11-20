package com.kuraki.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuraki
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 */
public class PalindromeDivision {

    public List<List<String>> partition(String s) {
        return partitionHelper(s, 0);
    }

    private List<List<String>> partitionHelper(String s, int start) {
        // 递归的出口
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        // 判断截取后剩下的字符串是否回文
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                String left = s.substring(start, i + 1);
                // 遍历后面的字符串的所有结果，将当前的字符串加到头部
                for (List<String> list : partitionHelper(s, i + 1)) {
                    list.add(0, left);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabb";
        PalindromeDivision palindromeDivision = new PalindromeDivision();
        System.out.println(palindromeDivision.partition(str));
    }
}
