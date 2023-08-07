package leetcode.BinaryTree.structure;

import leetcode.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode第105题：从前序和中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * @author qingtong
 * @since 2023-08-04 22:55
 **/
public class BuildTree_105 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 和456思路一样，现在根节点，再遍历左子树和右子树
        for (int i = 0; i <= inorder.length - 1; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[0];// 前序遍历首位就是最大值
        int inIndex = map.get(rootVal);// 找到中序遍历的索引

        int leftSize = inIndex - inStart;

        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = build(preorder, preStart, preStart + leftSize, inorder, inStart, inIndex - 1);
        rootNode.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, inIndex + 1, inEnd);
        return rootNode;
    }
}
