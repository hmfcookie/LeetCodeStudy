package com.mfcookie.leetcode.editor.cn;

//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 293 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        int[][] n = new int[][]{{1, 5}};
        int[] ints = new int[]{6, 8};
        int[][] insert = solution.insert(n, ints);
        System.out.println("insert = " + Arrays.toString(insert));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (newInterval.length != 2) {
                return intervals;
            }

            List<int[]> result = new ArrayList<>();
            if (intervals.length == 0) {
                result.add(newInterval);
                return result.toArray(new int[result.size()][]);
            }
            int left = newInterval[0];
            int right = newInterval[1];

            boolean added = false;
            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                int l = interval[0];
                int r = interval[1];

                if (r < left) {
                    result.add(interval);
                } else if (l > right) {
                    if (!added) {
                        result.add(new int[]{left, right});
                        added = true;
                    }
                    result.add(interval);
                } else {
                    left = Math.min(l, left);
                    right = Math.max(r, right);
                }
            }
            if (!added) {
                result.add(new int[]{left, right});
            }
            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}