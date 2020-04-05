package com.mfcookie.stack;

import java.util.Stack;

public class LeetCode71 {
    public static void main(String[] args) {

        String s = "/a/../../b/../c//.//";
        Solution71 solution71 = new Solution71();
        String s1 = solution71.simplifyPath(s);
        System.out.println(s1);
    }
}

/**
 * 简化路径
 * <p>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
class Solution71 {
    public String simplifyPath(String path) {
        String[] chars = path.split("/");
        Stack<String> stack = new Stack<>();
        if (chars.length == 0) {
            return "/";
        }
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && chars[i].equals("..")) {
                stack.pop();
            } else if (!chars[i].equals(".") && !chars[i].equals("") && !chars[i].equals("..")) {
                stack.push(chars[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append("/");
            result.append(stack.get(i));
        }
        return result.toString();
    }
}