package com.mfcookie.stack;

import java.util.Stack;

public class LeetCode224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        Solution224 solution224 = new Solution224();
        int calculate = solution224.calculate(s);
        System.out.println("calculate = " + calculate);
    }
}

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格' '。
 * <p>
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * <p>
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * <p></p>
 * 说明：<p>
 * 你可以假设所给定的表达式都是有效的。<p>
 * 请不要使用内置的库函数 eval。<p>
 * <p><p>
 * 来源：力扣（LeetCode）<p>
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution224 {
    public int calculate(String s) {
        Stack<Boolean> stack = new Stack<>();
        int res = 0;
        // 运算符
        Character opr = null;
        // 被操作的数
        int op = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (opr == null) {
                    res = op;
                } else {
                    res = cal(opr, res, op);
                }
                if (stack.isEmpty()) {
                    opr = c;
                } else {
                    opr = swap(stack.peek(), c);
                }
                op = 0;
            } else if (c == '(') {
                stack.push(opr != null && opr == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c)) {
                op = op * 10 + (c - '0');
            }
        }
        if (opr != null) {
            return cal(opr, res, op);
        }
        return res;
    }

    private Character swap(Boolean peek, char c) {
        if (peek) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(Character opr, int res, int op) {
        switch (opr) {
            case '-':
                return res - op;
            default:
                return res + op;
        }
    }
}