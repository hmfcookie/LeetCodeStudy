package com.mfcookie.leetcode.editor.cn;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 556 👎 0


import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] ints = solution.plusOne(new int[]{9, 9, 9, 9});
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}