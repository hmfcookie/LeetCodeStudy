package com.mfcookie.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hmfcookie
 * @date 2020/5/29
 */
public class LeetCode99 {
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

        Solution99 solution99 = new Solution99();
        solution99.recoverTree(node);

    }
}

/**
 * 通过Morris算法中序遍历二叉树，可以实现空间O(1)，时间O(n)复杂度。
 * 由于二叉搜索树中序遍历结果为有序数组，在中序遍历过程中判断相邻两个节点是否倒序，即可找到交换位置的两个节点
 */
class Solution99_1 {
    public void recoverTree(TreeNode root) {
        TreeNode before = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null) {
            //当左子树不为null，寻找左子树的最右节点，该节点为中序遍历中的前一个节点
            if (root.left != null) {
                TreeNode pre = getPredecessor(root);
                //pre节点没被修改，则修改右节点为root，以便后续循环中能通过pre.right回到root节点
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                    //继续遍历左子树
                    continue;
                } else if (pre.right == root) {
                    //将修改后的pre节点恢复原样
                    pre.right = null;
                }
            }
            //当左子树为null，或者pre.right为root时，先判断before节点和root节点是否倒序，然后再遍历右子树
            if (first == null && before != null && before.val > root.val)
                first = before;
            if (first != null && before != null && before.val > root.val)
                second = root;
            before = root;
            root = root.right;
        }
        swap(first, second);
    }
    //寻找一个节点的左子树的最右节点
    private TreeNode getPredecessor(TreeNode n) {
        TreeNode pre = n;
        if (n.left != null) {
            pre = pre.left;
            while (pre.right != null && pre.right != n) {
                pre = pre.right;
            }
        }
        return pre;
    }
    //交换两个节点
    private void swap(TreeNode first, TreeNode second) {
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}

class Solution99 {
    void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        mid(root, nums);
        int[] swap = findSwap(nums);
        recover(root, 2, swap[0], swap[1]);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
            if (--count == 0) {
                return;
            }
        }
        recover(root.left, count, x, y);
        recover(root.right, count, x, y);
    }

    private void mid(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        mid(root.left, nums);
        nums.add(root.val);
        mid(root.right, nums);
    }

    private int[] findSwap(List<Integer> nums) {
        if (nums == null) {
            return new int[]{};
        }
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }
}