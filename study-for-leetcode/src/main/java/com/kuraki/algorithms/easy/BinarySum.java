package com.kuraki.algorithms.easy;

import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0
 */
public class BinarySum {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            int num = a1 + b1 + flag;
            flag = num >= 2 ? 1 : 0;
            num = num >= 2 ? num % 2 : num;
            sb.append(num);
        }
        sb = flag == 1 ? sb.append(flag) : sb;
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        String a = "101";
        String b = "0101";
        System.out.println(addBinary(a, b));
    }

    // 标准答案，思路其实与上面一致
    public String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

}
