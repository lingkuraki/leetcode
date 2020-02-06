package com.kuraki.algorithms.binarytree;

import com.kuraki.algorithms.common.TreeNode;

/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * @author 凌波
 */
public class PruningBinaryTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 如果当前节点存储的值为0并且左右子节点均为null，则将当前节点置为null
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
