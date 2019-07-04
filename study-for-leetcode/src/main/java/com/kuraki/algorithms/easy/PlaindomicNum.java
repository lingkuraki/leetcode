package com.kuraki.algorithms.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PlaindomicNum {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int length = str.length();
        int right = length / 2;
        int left = length % 2 == 0 ? length / 2 - 1 : length / 2;
        while (left >= 0 && right < length) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
