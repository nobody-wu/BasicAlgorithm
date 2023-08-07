package leetcode.DynamicProgramming;

/**
 * 对509题使用dp 数组的迭代（递推）解法
 * <p>
 * 再Fib_509展示的带备忘录的解法是自上而下的解法，这里展示的是利用dp table自下而上的解法
 *
 * @author qingtong
 * @since 2023-08-06 23:34
 **/
public class Fib_509_opt {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 根据斐波那契数列的状态转移方程，当前状态 n 只和之前的 n-1, n-2 两个状态有关，
     * 其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
     *
     * @param n
     * @return
     */
    public int fib_opt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int dp_i_2 = 0;
        int dp_i_1 = 1;
        for (int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i_1;
    }
}
