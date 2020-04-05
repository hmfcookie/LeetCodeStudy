package com.mfcookie.stack;

import java.util.Stack;

public class LeetCode84 {
    public static void main(String[] args) {
        int[] array =  {2,1,5,5,6,2,3};
        Solution84 solution84 = new Solution84();
        int i = solution84.largestRectangleArea(array);
        System.out.println("i = " + i);
    }
}

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }

        /**
         * 哨兵
         */
        int[] newArray = new int[length + 2];
        newArray[0] = 0;
        newArray[length+1] = 0;
        System.arraycopy(heights, 0, newArray, 1, length);

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < newArray.length; i++) {
            while (!stack.isEmpty() && newArray[i] < newArray[stack.peek()]){
                int height = newArray[stack.pop()];
                int width = i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }
            stack.push(i);
        }
        return result;
    }
}