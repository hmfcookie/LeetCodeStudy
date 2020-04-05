package com.mfcookie.stack;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        boolean valid = solution.isValid("(])");
        System.out.println("valid = " + valid);
    }
}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution20 {
    private HashMap<Character, Character> mapping;

    public Solution20() {
        mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        char[] chars = s.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            if (mapping.containsKey(chars[i])) {

                Character character = mapping.get(chars[i]);
                Character o = stack.isEmpty() ? '#' : stack.pop();

                if (character != o) {
                    return false;
                }
            }else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}


