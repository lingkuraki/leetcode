package com.kuraki.algorithms;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanInt {

    @Test
    public void test(){
        int toInt = romanToInt("LVIII");
        System.out.println("toInt = " + toInt);
    }

    public int romanToInt(String s) {
        Map<String, Integer> romanMap = romanMap();
        // 两个字符的优先级高于单个字符
        int num = 0;
        for (int i = 0; i < s.length();) {
            if (i + 2 < s.length() && romanMap.containsKey(s.substring(i, i + 3))) {
                num += romanMap.get(s.substring(i, i + 3));
                i += 3;
            } else if (i + 1 < s.length() && romanMap.containsKey(s.substring(i, i + 2))) {
                num += romanMap.get(s.substring(i, i + 2));
                i += 2;
            } else {
                num += romanMap.get(s.substring(i, i + 1));
                i++;
            }
        }
        return num;
    }

    private Map<String, Integer> romanMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("III", 3);
        map.put("II", 2);
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        return map;
    }


}
