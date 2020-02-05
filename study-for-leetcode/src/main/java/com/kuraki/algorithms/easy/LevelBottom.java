package com.kuraki.algorithms.easy;

import com.kuraki.algorithms.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;
        if (depth + 1 > res.size())
            res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        if (root.left != null) helper(root.left, depth + 1, res);
        if (root.right != null) helper(root.right, depth + 1, res);
    }

    /*public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();

        if (root.left != null && root.right != null) {
            queryLevelItem(root.left, list);
            queryLevelItem(root.right, list);
        } else {
            queryLevelItem(root, list);
        }


    }

    private List<Integer> queryLevelItem(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        if (root.right == null) {
            list.add(root.left.val);
        } else if (root.left == null) {
            list.add(root.right.val);
        } else {
            list.add(root.left.val);
            list.add(root.right.val);
        }
        return list;
    }*/
}
