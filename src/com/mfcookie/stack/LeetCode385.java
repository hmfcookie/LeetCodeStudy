package com.mfcookie.stack;

import java.util.List;
import java.util.Stack;

public class LeetCode385 {
    public static void main(String[] args) {

    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
class NestedInteger385 {
    private Integer value;
    // Constructor initializes an empty nested list.
    public NestedInteger385(){};
    // Constructor initializes a single integer.
    public NestedInteger385(int value){this.value = value;};
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return false;};
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return value;};
    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger385 ni){};
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger385> getList(){return null;};
}

class Solution385 {
    public NestedInteger385 deserialize(String s) {
        if (!s.contains("[")) {
            return new NestedInteger385(Integer.valueOf(s));
        }
        NestedInteger385 result = new NestedInteger385();
        Stack<NestedInteger385> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ('['):
                    NestedInteger385 node = new NestedInteger385();
                    if (!stack.isEmpty()) {
                        stack.peek().add(node);
                    }
                    stack.push(node);
                    break;
                case (']'):
                    result = stack.pop();
                    break;
                case (','):
                    break;
                default:
                    String intStr = "";
                    int j = i;
                    for (; j < s.length(); j++) {
                        if (s.charAt(j) == ',' || s.charAt(j) == ']') {
                            break;
                        }
                        intStr += s.charAt(j);
                    }
                    if (']' == s.charAt(j)) {
                        i = j - 1;
                    } else {
                        i = j;
                    }

                    NestedInteger385 n = new NestedInteger385(Integer.valueOf(intStr));
                    if (stack.isEmpty()) {
                        stack.push(n);
                    } else {
                        stack.peek().add(n);
                    }
            }
        }
        return result;
    }
}
