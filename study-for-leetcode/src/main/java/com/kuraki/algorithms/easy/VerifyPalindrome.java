package com.kuraki.algorithms.easy;

/**
 * @author kuraki
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class VerifyPalindrome {

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            // 过滤掉非字母和数字的字符
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(str.charAt(j))) j--;
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}
