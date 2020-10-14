package com.mfcookie.leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 282 👎 0


public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        boolean race_a_car = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("race_a_car = " + race_a_car);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome1(String s) {
            char[] chars = s.toCharArray();
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetterOrDigit(chars[i])) {
                    s1.append(Character.toLowerCase(chars[i]));
                }
            }
            return s1.toString().equals(s1.reverse().toString());
        }

        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0, j = chars.length - 1;
            while (i < j) {
                char a, b;
                if (Character.isLetterOrDigit(chars[i])) {
                    a = chars[i];
                    i++;
                } else {
                    i++;
                    continue;
                }
                if (Character.isLetterOrDigit(chars[j])) {
                    b = chars[j];
                    j--;
                } else {
                    j--;
                    i--;
                    continue;
                }
                if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}