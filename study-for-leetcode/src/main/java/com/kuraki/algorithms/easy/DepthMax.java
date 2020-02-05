package com.kuraki.algorithms.easy;

import com.kuraki.algorithms.common.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class DepthMax {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        depth = countDepth(root.left, root.right, depth);
        return depth;
    }

    private int countDepth(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) return depth;
        depth++;
        if (left == null) {
            depth = countDepth(right.left, right.right, depth);
        } else if (right == null) {
            depth = countDepth(left.left, left.right, depth);
        } else {
            depth = Math.max(countDepth(right.left, right.right, depth), countDepth(left.left, left.right, depth));
        }
        return depth;
    }

    // 官方解答
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth1(root.left);
            int right_height = maxDepth1(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}
