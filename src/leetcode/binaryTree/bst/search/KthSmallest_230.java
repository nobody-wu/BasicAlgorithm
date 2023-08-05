package leetcode.binaryTree.bst.search;

import leetcode.binaryTree.TreeNode;

/**
 * leetCode第230题：二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author qingtong
 * @since 2023-08-05 16:24
 **/
public class KthSmallest_230 {

    /**
     * 利用中序遍历的升序排列来解决，时间复杂度O(n)
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);

        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    public void traverse(TreeNode root, int k) {

        traverse(root.left, k);

        /** 中序遍历 */
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        /***********/

        traverse(root.right, k);

    }



}
