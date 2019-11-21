package com.kuraki.algorithms.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author kuraki
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class CharUniqFirst {

    /**
     * LinkedHashMap算法
     */
    public int firstUniqCharByHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /**
     * 字符数组
     */
    public int firstUniqCharByArr(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == '\0') break;
                if (arr[j] == arr[i]) {
                    arr[j] = '\0';
                    count++;
                }
                if (j == arr.length - 1 && count == 0) {
                    return i;
                }
            }
        }
        return arr[arr.length - 1] == '\0' ? -1 : arr.length - 1;
    }

    /**
     * 查找法
     */
    public int firstUniqChar(String s) {
        int index = -1;
        //反过来，只有26个字符
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }

    @Test
    public void test() {
        firstUniqCharByArr("aadadaad");
    }
}
