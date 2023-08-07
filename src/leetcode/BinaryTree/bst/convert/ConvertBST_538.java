package leetcode.BinaryTree.bst.convert;

import leetcode.BinaryTree.TreeNode;

/**
 * leetCode第538题：转换累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * @author qingtong
 * @since 2023-08-05 22:08
 **/
public class ConvertBST_538 {

    /**
     * 还是利用中序遍历解题
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 因为右子树小于左子树，所以这里不同于正常的中序遍历，要先遍历右子树
        traverse(root.right);

        // 维护累加和
        sum+=root.val;

        // 将BST转换成累加树
        root.val = sum;

        traverse(root.left);
    }
}
