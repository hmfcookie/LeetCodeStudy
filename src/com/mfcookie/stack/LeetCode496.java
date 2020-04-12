package com.mfcookie.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        Solution496 solution496 = new Solution496();
        int[] ints = solution496.nextGreaterElement(nums1, nums2);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p></p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * <p>输出: [-1,3,-1]
 * <p>
 * 解释:
 * <p>对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * <p>对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * <p>对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * <p>输出: [3,-1]
 * <p>
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p></p>
 * 注意:
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 1) {
            return new int[]{-1};
        }
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
