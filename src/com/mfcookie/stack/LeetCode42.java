package com.mfcookie.stack;

import java.util.Stack;

public class LeetCode42 {

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = solution42.trap(a);
        System.out.println("trap = " + trap);
    }
}

class Solution42 {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack();
        int result = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                Integer pop = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                Integer peek = stack.peek();
                int h = Math.min(height[peek], height[current]) - height[pop];
                int a = current - peek - 1;
                result += a * h;
            }
            stack.push(current++);
        }
        return result;
    }
}