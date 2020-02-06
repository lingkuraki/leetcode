package com.kuraki.algorithms.binarytree;

import com.kuraki.algorithms.common.TreeNode;

/**
 * @author 凌波
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
