package leetcode.binaryTree.bst.search;

import leetcode.binaryTree.TreeNode;

/**
 * 剑指Offer_054
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * @author qingtong
 * @since 2023-08-05 22:31
 **/
public class KthLargest_offer054 {

    public int kthLargest(TreeNode root, int k) {
        // 同230
        traverse(root, k);
        return res;
    }

    int rank = 0;
    int res = 0;
    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.right, k);

        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }

        traverse(root.left, k);
    }
}
