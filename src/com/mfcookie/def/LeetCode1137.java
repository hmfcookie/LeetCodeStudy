package com.mfcookie.def;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1137 {
    public static void main(String[] args) {
        Solution1137 solution1137 = new Solution1137();
        int tribonacci = solution1137.tribonacci(25);
        System.out.println("tribonacci = " + tribonacci);
    }
}

/**
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1137 {
    Map<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        Integer integer = map.get(n);
        if (integer != null){
            return integer;
        }
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int i = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        map.put(n,i);
        return i;
    }
}
