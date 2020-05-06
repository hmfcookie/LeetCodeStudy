package com.mfcookie.array;

import java.util.Arrays;

public class LeetCode242 {
    public static void main(String[] args) {
        Solution242 s = new Solution242();
        boolean anagram1 = s.isAnagram("hhby", "hhby");
        System.out.println("anagram1 = " + anagram1);
    }
}

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] tmp = new int[26];
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            tmp[c - 'a'] += 1;
        }
        for (int i = 0; i < chars1.length; i++) {
            char c = t.charAt(i);
            tmp[c - 'a'] -= 1;
        }
        for (int i : tmp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        int l1 = s.length(), l2 = t.length();

        if (l1 != l2) {
            return false;
        }
        if (l1 == 0) {
            return true;
        }

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }
}
