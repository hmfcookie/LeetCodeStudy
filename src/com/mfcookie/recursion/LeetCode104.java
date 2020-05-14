package com.mfcookie.recursion;

/**
 * @author hmfcookie
 * @date 2020/5/14
 */
public class LeetCode104 {
    public static void main(String[] args) {
        /**
         *               9
         *              / \
         *             4   10
         *            / \   \
         *           3   5   15
         *                    \
         *                    2
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

        TreeNode node6 = new TreeNode(2);
        node5.right = node6;

        Solution104 solution104 = new Solution104();
        int i = solution104.maxDepth(node);
        System.out.println("i = " + i);
    }
}

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
class Solution104 {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return i;
        }
        int left = dfs(root.left, i + 1);
        int right = dfs(root.right, i + 1);
        return Math.max(left, right);
    }

}