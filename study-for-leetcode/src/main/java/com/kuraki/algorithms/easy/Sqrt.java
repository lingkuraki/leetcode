package com.kuraki.algorithms.easy;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Sqrt {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x * 1.0);
    }

    // 官方标准答案
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long l = 1;
        long r = x / 2;
        while (l < r) {
            // 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            long mid = l + (r - l + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }
}
