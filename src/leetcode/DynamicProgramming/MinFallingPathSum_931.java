package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * leetCode第931题：下降路径最小和
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * @author qingtong
 * @since 2023-08-26 21:27
 **/
public class MinFallingPathSum_931 {

    // 使用备忘录，用空间换时间：解决重复性问题
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];

        // 初始化数据
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 66666);
        }

        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i > matrix.length || j > matrix[0].length) {
            return 99999;
        }

        if (i == 0) {
            return matrix[0][j];
        }

        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        return matrix[i][j] +
                min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
