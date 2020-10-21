package com.mfcookie.leetcode.editor.cn;

//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 252 👎 0


import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        boolean isomorphic = solution.isIsomorphic("paper", "title");
        System.out.println("isomorphic = " + isomorphic);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            int[] mapS = new int[128];
            int[] mapT = new int[128];

            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (mapS[c1] != mapT[c2]) {
                    return false;
                } else {
                    if (mapS[c1] == 0) {
                        mapS[c1] = i + 1;
                        mapT[c2] = i + 1;
                    }
                }
            }
            return true;
        }


        public boolean isIsomorphic1(String s, String t) {
            return isIsomorphicHelper1(s, t) && isIsomorphicHelper1(t, s);
        }

        private boolean isIsomorphicHelper1(String s, String t) {
            int n = s.length();
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (map.containsKey(c1)) {
                    if (c2 != map.get(c1)) {
                        return false;
                    }
                } else {
                    map.put(c1, c2);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}