package com.mfcookie.recursion;

/**
 * @author hmfcookie
 * @date 2020/5/14
 */
public class LeetCode112 {
    public static void main(String[] args) {
        /**
         *               9
         *              / \
         *             4   10
         *            / \   \
         *           3   5   15
         */
        TreeNode node = new TreeNode(9);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node.left = node1;

        TreeNode node4 = new TreeNode(10);
        node.right = node4;

        TreeNode node5 = new TreeNode(15);
        node4.right = node5;

        Solution112 solution112 = new Solution112();
        boolean b = solution112.hasPathSum(node, 18);
        System.out.println("b = " + b);

    }
}


/**
 * 112. 路径总和
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}

