package com.mfcookie.tree;

/**
 * @author hmfcookie
 * @date 2020/5/19
 */
public class LeetCode96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int i = solution96.numTrees2(10);
        System.out.println("i = " + i);
    }
}

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *      i=1
 * G(n)= ∑ G(i−1)⋅G(n−i)
 *       n
 */
class Solution96 {
    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // 方法二：数学演绎法 卡塔兰数
    public int numTrees2(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
}
