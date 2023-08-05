package leetcode.binaryTree.bst.operate;

import leetcode.binaryTree.TreeNode;

/**
 * 在leetCode第700题上进行的扩展
 *
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * @author qingtong
 * @since 2023-08-05 23:52
 **/
public class InsertIntoBST_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 先找二叉搜索树的对应位置，再插入操作
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

}
