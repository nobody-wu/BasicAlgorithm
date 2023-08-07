package leetcode.BinaryTree.bst.valid;

import leetcode.BinaryTree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * @author qingtong
 * @since 2023-08-05 23:11
 **/
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && min.val >= root.val) {
            return false;
        }

        if (max != null && max.val <= root.val) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);

    }
}
