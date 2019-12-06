package com.kuraki.algorithms.hard;

import org.junit.Test;

import java.util.*;

/**
 * @author kuraki
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 1.分隔时可以重复使用字典中的单词。
 * 2.你可以假设字典中没有重复的单词。
 */
public class WordSegmentation2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        List<List<Integer>> indexes = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexes.add(list);
            }
        }
        if (indexes.size() == 0) return null;
        String sub;
        for (int str = 0; str < indexes.size(); str++) {
            dp[0] = true;
            List<Integer> list = indexes.get(str);
            int counts = 0;
            for (int i = list.get(0); i <= s.length(); i++) {
                dp[list.get(0)] = true;
                for (int j = 0; j < i; j++) {
                    sub = s.substring(j, i);
                    if (dp[j] && dict.contains(sub)) {
                        dp[i] = true;
                        if (counts == 0) {
                            list.add(i);
                            counts++;
                        } else {
                            List<Integer> list1 = new ArrayList<>(list);
                            list1.set(list.size() - 1, i);
                            indexes.add(list1);
                        }
                    }
                }
            }
            dp = new boolean[s.length() + 1];
        }
        List<String> words = new ArrayList<>();
        indexes.forEach(list -> {
            list.add(0, 0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(s, list.get(i), list.get(i + 1)).append(" ");
            }
            words.add(sb.substring(0, sb.length() - 1));
        });
        return words;
    }

    @Test
    public void test() {
        String[] arr = {"apple", "pen", "applepen", "pine", "pineapple"};
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList(arr)));
    }

    @Test
    public void test1() {
        StringBuilder sb = new StringBuilder(100);
        System.out.println(isEmpty(sb.toString()));
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
