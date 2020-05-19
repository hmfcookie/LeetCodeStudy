package com.mfcookie.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hmfcookie
 * @date 2020/5/19
 */
public class LeetCode94 {
    public static void main(String[] args) {
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

        Solution94 solution94 = new Solution94();
        List<Integer> integers = solution94.inorderTraversal2(node);
        System.out.println("integers = " + integers);
    }
}

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
class Solution94 {
    // 方法一：递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            helper(root.right, result);
        }
    }

    // 方法二：基于栈的遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}

