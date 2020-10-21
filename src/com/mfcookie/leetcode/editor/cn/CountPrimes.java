package com.mfcookie.leetcode.editor.cn;

//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 459 👎 0


public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        int i = solution.countPrimes(50);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 厄拉多塞筛法
        public int countPrimes(int n) {
            int result = 0;
            boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
            if(2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数

            for(int i = 3; i < n; i += 2){  // 从 3 开始遍历，且只遍历奇数
                if(!b[i]){  // 是质数
                    for(int j = 3; i * j < n; j += 2){
                        b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                    }
                    result++;   // 质数个数 +1
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}