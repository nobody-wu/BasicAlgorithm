package leetcode.binaryTree.bst.search;

import leetcode.binaryTree.TreeNode;

/**
 * 你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * @author qingtong
 * @since 2023-08-06 01:10
 **/
public class CountNodes_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 先搞清楚是完全二叉树、还是满二叉树，再看咋技术
        int lh = 0;
        TreeNode lroot = root;
        while (lroot.left != null) {
            lroot = lroot.left;
            lh++;
        }
        int rh = 0;
        TreeNode rroot = root;
        while (rroot.right != null) {
            rroot = rroot.right;
            rh++;
        }

        if (lh == rh) {
            // 说明是满二叉树
            return (int) (Math.pow(2, lh) - 1);
        }

        // 普通二叉树算法
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
