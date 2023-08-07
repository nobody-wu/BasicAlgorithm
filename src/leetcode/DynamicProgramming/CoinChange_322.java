package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author qingtong
 * @since 2023-08-07 01:21
 **/
public class CoinChange_322 {

    /**
     * 暴力解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int[] memo;

    /**
     * 备忘录解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }

        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * dp table解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
