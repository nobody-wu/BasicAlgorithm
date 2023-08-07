package leetcode.BinaryTree.bst.operate;

import leetcode.BinaryTree.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *   首先找到需要删除的节点；
 *   如果找到了，删除它。
 *
 * @author qingtong
 * @since 2023-08-06 00:44
 **/
public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            // 情况一：如果是叶子节点，直接删除
            // 情况二：如果是父节点，则将子节点进行替换
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 情况三：如果是祖父以上的节点被删除，则需要找到其右子树最小节点进行删除，或者其左子树最大节点进行删除，这样才保证不改变其树结构
            // 这里选择右子树最小节点
            TreeNode minNode = getMin(root.right);

            // 删除其右子树最小节点
            root.right = deleteNode(root.right, minNode.val);

            // 左右子树替换
            minNode.left = root.left;
            minNode.right = root.right;

            // 节点替换
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

}
