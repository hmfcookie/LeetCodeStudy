package com.mfcookie.leetcode.editor.cn;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 391 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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

        List<String> strings = solution.binaryTreePaths(node);
        System.out.println("strings = " + strings);
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

        // 广度优先 BFS
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null) {
                return paths;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<String> pathQueue = new LinkedList<>();

            nodeQueue.offer(root);
            pathQueue.offer(Integer.toString(root.val));

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                String path = pathQueue.poll();

                if (node.left == null && node.right == null) {
                    paths.add(path);
                } else {
                    if (node.left != null) {
                        nodeQueue.offer(node.left);
                        pathQueue.offer(path + "->" + node.left.val);
                    }

                    if (node.right != null) {
                        nodeQueue.offer(node.right);
                        pathQueue.offer(path + "->" + node.right.val);
                    }
                }
            }
            return paths;
        }


        // 深度优先 DFS
        public List<String> binaryTreePaths1(TreeNode root) {
            List<String> answer = new ArrayList<>();
            helper(root, "", answer);
            return answer;
        }

        private void helper(TreeNode root, String path, List<String> paths) {
            if (root != null) {
                StringBuilder stringBuilder = new StringBuilder(path);
                stringBuilder.append(root.val);
                if (root.left == null && root.right == null) {
                    paths.add(stringBuilder.toString());
                } else {
                    stringBuilder.append("->");
                    helper(root.left, stringBuilder.toString(), paths);
                    helper(root.right, stringBuilder.toString(), paths);
                }
            }
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