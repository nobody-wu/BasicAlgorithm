package leetcode.BinaryTree.structure;

import leetcode.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode第106题：从前序和中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树
 *
 * @author qingtong
 * @since 2023-08-04 23:52
 **/
public class BuildTree_106 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int inIndex = map.get(rootVal);
        int leftSize = inIndex - inStart;
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = build(inorder, inStart, inIndex - 1, postorder, postStart, postStart + leftSize - 1);
        rootNode.right = build(inorder, inIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return rootNode;
    }
}
