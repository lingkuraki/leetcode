package com.kuraki.algorithms.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Climb {

    // 可以看成是斐波那契数列
    public int climbStairs(int n) {
        int[] dp = new int[3];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        return dp[n % 3];
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        return climb_Stairs(0, n);
    }

    private int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
