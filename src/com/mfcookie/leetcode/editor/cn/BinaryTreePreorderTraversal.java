package com.mfcookie.leetcode.editor.cn;

//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 413 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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

        List<Integer> list = solution.preorderTraversal(node);
        System.out.println("list = " + list);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        // 迭代
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    result.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            return result;
        }

        //递归
        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            helper(root, list);
            return list;
        }

        private void helper(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}