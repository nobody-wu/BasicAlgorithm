package leetcode.binaryTree.structure;

import leetcode.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode第106题：根据前序和后序遍历构造二叉树
 *
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *
 * @author qingtong
 * @since 2023-08-05 00:46
 **/
public class BuildTree_889 {

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        int index = map.get(leftRootVal);
        int leftSize = index - postStart + 1;

        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        rootNode.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return rootNode;
    }
}
