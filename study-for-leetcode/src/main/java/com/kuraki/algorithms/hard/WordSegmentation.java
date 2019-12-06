package com.kuraki.algorithms.hard;

import java.util.*;

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

    /**
     * 宽度优先搜索
     */
    public boolean wordBreakByPriority(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    /**
     * 动态规划法
     */
    public boolean wordBreakByDynamic(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
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
        String[] arr = {"cat", "cats", "and", "sand", "dog"};
        System.out.println(word.wordBreakByPriority("catsanddog", Arrays.asList(arr)));
    }
}
