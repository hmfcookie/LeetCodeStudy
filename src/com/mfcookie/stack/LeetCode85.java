package com.mfcookie.stack;

public class LeetCode85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        Solution85 solution85 = new Solution85();
        int i = solution85.maximalRectangle(matrix);
        System.out.println("i = " + i);

    }
}

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;

        if (matrix.length == 0) {
            return result;
        }

        Solution84 solution84 = new Solution84();
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else if (matrix[i][j] == '0') {
                    heights[j] = 0;
                }
            }
            result = Math.max(result, solution84.largestRectangleArea(heights));
        }
        return result;
    }
}
