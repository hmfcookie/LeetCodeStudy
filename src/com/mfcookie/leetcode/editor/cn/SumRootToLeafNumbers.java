package com.mfcookie.leetcode.editor.cn;

//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 222 👎 0


import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
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

        int sum = 0;
        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return sum;
        }

        private void helper(TreeNode node, int res) {
            if (node != null) {
                res = res * 10 + node.val;
                if (node.left == null && node.right == null) {
                    sum += res;
                } else {
                    helper(node.left, res);
                    helper(node.right, res);
                }
            }
        }

        public int sumNumbers1(TreeNode root) {
            List<String> list = new ArrayList<>();
            helper1(root, "", list);
            int res = 0;
            for (String s : list) {
                res += Integer.parseInt(s);
            }
//            int res = list.stream().map(Integer::valueOf).mapToInt(integer -> integer).sum();
            return res;
        }

        private void helper1(TreeNode node, String path, List<String> list) {
            StringBuilder builder = new StringBuilder(path);
            if (node != null) {
                builder.append(node.val);
                if (node.left == null && node.right == null) {
                    list.add(builder.toString());
                } else {
                    helper1(node.left, builder.toString(), list);
                    helper1(node.right, builder.toString(), list);
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