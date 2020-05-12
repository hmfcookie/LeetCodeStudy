package com.mfcookie.recursion;


public class LeetCode687 {
    public static void main(String[] args) {

        /**
         *               1
         *              / \
         *             4   5
         *            / \   \
         *           4   4   5
         */
        Solution687 s = new Solution687();
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node.left = node1;

        TreeNode node4 = new TreeNode(5);
        node.right = node4;

        TreeNode node5 = new TreeNode(5);
        node4.right = node5;

        int res = s.longestUnivaluePath(node);
        System.out.println("res = " + res);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 */
class Solution687 {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        doSomething(root);
        return res;
    }

    public int doSomething(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        int sonLeft = doSomething(root.left);
        int sonRight = doSomething(root.right);
        if (root.left != null && root.left.val == root.val) {
            left = sonLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = sonRight + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}