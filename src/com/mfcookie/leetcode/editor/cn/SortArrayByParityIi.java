package com.mfcookie.leetcode.editor.cn;

//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 165 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
        int[] a = {4, 2, 5, 7};
        solution.sortArrayByParityII(a);
        System.out.println("a = " + Arrays.toString(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        public int[] sortArrayByParityII(int[] A) {
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                if (A[i] % 2 == 0) {
                    i += 2;
                } else if (A[j] % 2 != 0) {
                    j += 2;
                } else {
                    swap(A, i, j);
                    i += 2;
                    j += 2;
                }
            }
            return A;
        }

        public int[] sortArrayByParityII2(int[] A) {
            Stack<Integer> stackEven = new Stack<>();
            Stack<Integer> stackOdd = new Stack<>();
            for (int i = 0; i < A.length; i++) {
                if (i % 2 == 0 && A[i] % 2 != 0) {
                    if (!stackEven.isEmpty()) {
                        swap(A, stackEven.pop(), i);
                    } else {
                        stackOdd.push(i);
                    }
                }
                if (i % 2 != 0 && A[i] % 2 == 0) {
                    if (!stackOdd.isEmpty()) {
                        swap(A, stackOdd.pop(), i);
                    } else {
                        stackEven.push(i);
                    }
                }
            }
            return A;
        }

        public int[] sortArrayByParityII1(int[] A) {
            List<Integer> even = new ArrayList<>();//不符合的奇数
            List<Integer> odd = new ArrayList<>();//不符合的偶数
            for (int i = 0; i < A.length; i++) {
                if (i % 2 == 0 && A[i] % 2 != 0) {
                    odd.add(i);
                }
                if (i % 2 != 0 && A[i] % 2 == 0) {
                    even.add(i);
                }
            }
            for (int i = 0; i < even.size(); i++) {
                swap(A, even.get(i), odd.get(i));
            }
            return A;
        }

        private void swap(int[] a, int index1, int index2) {
            int temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}