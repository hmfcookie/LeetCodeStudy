package com.mfcookie.leetcode.editor.cn;

//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 369 👎 0


public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        int i = solution.trailingZeroes(1808548329);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            // n / 5 + n / 5*5 + n / 5*5*5 + n / 5*5*5*5
            int count = 0;
            while (n > 0) {
                n /= 5;
                count += n;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}