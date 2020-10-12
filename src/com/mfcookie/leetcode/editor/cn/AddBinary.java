package com.mfcookie.leetcode.editor.cn;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 496 👎 0


public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();

        String a = "1010";
        String b = "1011";

        String s = solution.addBinary(a, b);
        System.out.println("s = " + s);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int n = Math.max(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            carry += (i < a.length()) ? a.charAt(a.length()-i-1) - '0' : 0;
            carry += (i < b.length()) ? b.charAt(b.length()-i-1) - '0' : 0;
            res.append((char) (carry % 2 +'0'));
            carry /= 2;
        }
        if (carry > 0) {
            res.append("1");
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}