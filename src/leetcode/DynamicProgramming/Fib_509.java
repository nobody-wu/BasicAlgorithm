package leetcode.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 *
 * @author qingtong
 * @since 2023-08-06 23:04
 **/
public class Fib_509 {

    /**
     * 暴力解法：带来动态规划问题的第一个性质：重叠子问题
     * 存在大量重复计算，这个算法十分低效
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    /**
     * 带备忘录的递归解法：针对重叠子问题的优化（空间换时间）
     *
     * @param n
     * @return
     */
    Map<Integer, Integer> res = new HashMap<>();
    public int fib_optimize_v1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int n1 = 0;
        int n2 = 0;
        if (res.containsKey(n - 1)) {
            n1 = res.get(n - 1);
        } else {
            res.put(n - 1, fib_optimize_v1(n - 1));
            n1 = fib_optimize_v1(n - 1);
        }

        if (res.containsKey(n - 2)) {
            n2 = res.get(n - 2);
        } else {
            res.put(n - 2, fib_optimize_v1(n - 2));
            n2 = fib_optimize_v1(n - 2);
        }

        return n1 +n2;
    }

    /**
     * 备忘录更优解法
     *
     * @param n
     * @return
     */
    public int fib_optimize_v2(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dp(memo, n - 1) + dp(memo, n - 2); // 这俩dp会有重复的情况
        return memo[n];
    }

}
