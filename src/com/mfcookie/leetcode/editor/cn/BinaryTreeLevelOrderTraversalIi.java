package com.mfcookie.leetcode.editor.cn;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 347 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        /**
         *                 1
         *              /     \
         *             3       5
         *            / \     / \
         *           4   7   6   9
         */
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node.left = node1;

        TreeNode node4 = new TreeNode(5);
        node.right = node4;

        TreeNode node5 = new TreeNode(9);
        node4.right = node5;

        TreeNode node6 = new TreeNode(6);
        node4.left = node6;

        List<List<Integer>> lists = solution.levelOrderBottom(node);
        System.out.println("lists = " + lists);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> levelOrder = new LinkedList<>();
            if (root == null) {
                return levelOrder;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        level.add(node.val);
                        TreeNode left = node.left, right = node.right;
                        if (left != null) {
                            queue.offer(left);
                        }
                        if (right != null) {
                            queue.offer(right);
                        }
                    }
                }
                levelOrder.add(0, level);
            }
            return levelOrder;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}