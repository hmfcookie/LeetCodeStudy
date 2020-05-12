package com.mfcookie.recursion;

public class LeetCode0805 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Solution0805 s = new Solution0805();
        int multiply = s.multiplyBit(-56, 895111);
        System.out.println("multiply = " + multiply);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }
}

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * A * B = A * (B/2) * 2 = A * (B/2) + A * (B/2)
 * f(A,B) = f(A, B/2) + f(A, B/2)
 */
class Solution0805 {
    /**
     * @param a
     * @param b
     * @return
     */
    public int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == 1) {
            return max;
        }
        if (min < 0) {
            return -multiply(max, -min);
        }
        if (min % 2 == 0) {
            return multiply(max, min / 2) + multiply(max, min / 2);
        } else {
            return multiply(max, min / 2) + multiply(max, min / 2) + max;
        }
    }

    /**
     * 利用位运算
     *
     * @param a
     * @param b
     * @return
     */
    public int multiplyBit(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == 1) {
            return max;
        }
        if (min < 0) {
            return -multiply(max, -min);
        }
        if (min == 2) {
            return max << 1;
        }
        return multiplyBit(2, max) + multiplyBit(min - 2, max);
    }

}