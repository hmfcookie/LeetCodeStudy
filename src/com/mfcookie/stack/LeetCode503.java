package com.mfcookie.stack;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {
    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] nums = {1,2,3,4,5};
        int[] ints = solution503.nextGreaterElements(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}

/**
 * 503. 下一个更大元素
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        // 默认都找不到下一个最大值
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            // 循环两边数组，取模获取下标，实现循环数组
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}
