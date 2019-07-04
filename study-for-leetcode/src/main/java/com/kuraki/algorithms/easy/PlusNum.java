package com.kuraki.algorithms.easy;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusNum {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 如果所求结果为0，就继续循环；否则，直接返回这个数组
            if (digits[i] != 0) return digits;
        }
        // 针对类似[9,9],[9,9,9]的数组
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test() {
        int[] a1 = new int[]{8, 9};
        System.out.println(Arrays.toString(plusOne(a1)));
    }
}
