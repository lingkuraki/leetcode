package com.kuraki.algorithms.hard;

import java.util.*;

/**
 * @author kuraki
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 1.分隔时可以重复使用字典中的单词。
 * 2.你可以假设字典中没有重复的单词。
 */
public class WordSegmentation3 {

    private List<String> ans;
    /**
     * 长度种类
     */
    private Set<Integer> lenSet;
    /**
     * 单词的字典，方便查询
     */
    private Set<String> wordSet;
    private String s;
    /**
     * 进行记忆化剪枝的数组
     */
    private int[][] dp;

    private String gen(List<String> str) {
        //生成给定的输出模型
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : str) {
            if (first) {
                first = false;
                sb.append(s);
            } else {
                sb.append(" ").append(s);
            }
        }
        return sb.toString();
    }

    private int helper(List<String> temp, int start) {
        if (start == s.length()) {
            //能够正确拆分单词，返回1
            ans.add(gen(temp));
            return 1;
        }
        //标记
        boolean ok = false;
        for (int len : lenSet) {
            if (start + len <= s.length()) {
                String st = s.substring(start, start + len);
                //如果已经不可拆分，直接剪枝
                if (wordSet.contains(st) && dp[start][len] != -1) {
                    temp.add(st);
                    dp[start][len] = helper(temp, start + len);
                    if (dp[start][len] == 1) ok = true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return ok ? 1 : -1;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        lenSet = new HashSet<>();
        wordSet = new HashSet<>();
        this.s = s;
        int max = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            max = Math.max(max, wordDict.get(i).length());
            lenSet.add(wordDict.get(i).length());
            wordSet.add(wordDict.get(i));
        }
        dp = new int[s.length() + 1][max + 1];
        helper(new ArrayList<String>(), 0);
        return ans;
    }
}
