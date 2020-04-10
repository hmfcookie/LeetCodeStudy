package com.mfcookie.stack;

import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        String[] a = {"2", "1", "+", "3", "*"};
        int i = solution150.evalRPN(a);
        System.out.println("i = " + i);
    }
}

/**
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int cal = cal(token, stack.pop(), stack.pop());
                stack.push(cal);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int cal(String token, Integer pop, Integer pop1) {
        if (token.equals("+")) {
            return pop1 + pop;
        }
        if (token.equals("-")) {
            return pop1 - pop;
        }
        if (token.equals("*")) {
            return pop1 * pop;
        }
        if (token.equals("/")) {
            return pop1 / pop;
        }
        return 0;
    }
}
