package leetcode.BinaryTree.structure;

import leetcode.BinaryTree.TreeNode;

/**
 * leetCode第654题：最大二叉树
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class MaximumBinaryTree_456 {

    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 1. 找出nums中的最大值
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode treeNode = new TreeNode(maxVal);

        // 2. 递归遍历左子树
        treeNode.left = build(nums, left, index - 1);

        // 3. 递归遍历右子树
        treeNode.right = build(nums, index + 1, right);

        return treeNode;
    }

}