package com.mfcookie.recursion;

public class LeetCode779 {
    public static void main(String[] args) {
        Solution779 s = new Solution779();
        int i = s.kthGrammar(4, 5);
        System.out.println("i = " + i);

    }
}

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution779 {

    public int kthGrammar(int N, int K) {
        String a = getString(N);
        return Integer.valueOf(a.charAt(K - 1) - '0');
//        return Integer.bitCount(K - 1) % 2;
    }


    private String getString(int n) {

        if (n == 0) {
            return "";
        } else if (n >= 1) {
            String newStr = "";
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    newStr = "0";
                    continue;
                }
                String s = "";
                for (int i = 0; i < newStr.length(); i++) {
                    s += "1".equals(newStr.charAt(i)) ? "10" : "01";
                }
                newStr = s;
                System.out.println("newStr = " + newStr);
            }

            return newStr;
        }

        return "";
    }

}



