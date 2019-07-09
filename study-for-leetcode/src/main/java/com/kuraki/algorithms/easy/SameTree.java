package com.kuraki.algorithms.easy;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {

    // 明确一个节点要做的事情，然后剩下的事抛给框架(这里就是递归)。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        // 有一个为null，则结果必然为false
        if (p == null || q == null) return false;
        // 当前相同节点位置上的值不等，则也返回false
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
