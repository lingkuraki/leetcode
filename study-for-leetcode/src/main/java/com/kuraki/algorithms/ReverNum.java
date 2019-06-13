package com.kuraki.algorithms;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class ReverNum {

    public int reverse(int x) {
        boolean flag = x > 0;
        x = Math.abs(x);
        String str = String.valueOf(x);
        str = new StringBuilder(str).reverse().toString();
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            parseInt = 0;
        }
        return flag ? parseInt : -parseInt;
    }

    // 官方标准答案
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
