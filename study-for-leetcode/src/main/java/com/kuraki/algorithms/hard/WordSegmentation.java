package com.kuraki.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author kuraki
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 1.拆分时可以重复使用字典中的单词。
 * 2.你可以假设字典中没有重复的单词。
 */
public class WordSegmentation {

    /**
     * 记忆回溯法
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, HashSet<String> dict, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && wordBreak(s, dict, end, memo)) {
                return true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        WordSegmentation word = new WordSegmentation();
        String[] arr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        word.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList(arr));
    }
}
