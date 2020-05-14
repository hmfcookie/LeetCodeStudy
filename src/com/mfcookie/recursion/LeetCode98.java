package com.mfcookie.recursion;

/**
 * @author hmfcookie
 * @date 2020/5/14
 */
public class LeetCode98 {
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

        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(node);
        System.out.println("validBST = " + validBST);

        Solution98_1 solution98_1 = new Solution98_1();
        boolean validBST1 = solution98_1.isValidBST(node);
        System.out.println("validBST1 = " + validBST1);
    }
}
/**
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * 前序递归
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue) {
            return false;
        }
        if (root.val >= maxValue) {
            return false;
        }
        if (!dfs(root.left, minValue, root.val)) {
            return false;
        }
        if (!dfs(root.right, root.val, maxValue)) {
            return false;
        }
        return true;
    }
}

/**
 * 前序递归的花稍写法
 */
class Solution98_1 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        return root == null || root.val > minValue && root.val < maxValue && dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }
}