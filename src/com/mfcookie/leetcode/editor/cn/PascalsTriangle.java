package com.mfcookie.leetcode.editor.cn;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 362 👎 0


import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();

        List<List<Integer>> generate = solution.generate(5);
        System.out.println("generate = " + generate);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            if (numRows == 0) {
                return triangle;
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            triangle.add(list);
            for (int i = 1; i < numRows; i++) {
                List<Integer> th = new ArrayList<>();
                th.add(1);

                List<Integer> pre = triangle.get(i - 1);

                for (int j = 1; j < pre.size(); j++) {
                    th.add(pre.get(j - 1) + pre.get(j));
                }
                th.add(1);
                triangle.add(th);
            }
            return triangle;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}