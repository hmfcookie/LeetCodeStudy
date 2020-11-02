package com.mfcookie.leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 273 👎 0


import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = solution.intersection(nums1, nums2);
        System.out.println("intersection = " + Arrays.toString(intersection));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int index = 0, index1 = 0, index2 = 0;
            int[] result = new int[Math.min(nums1.length, nums2.length)];
            while (index1 < nums1.length && index2 < nums2.length) {
                int a = nums1[index1], b = nums2[index2];
                if (a == b) {
                    if (index == 0 || result[index - 1] != a) {
                        result[index++] = a;
                    }
                    index1++;
                    index2++;
                } else if (a < b) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOfRange(result, 0, index);
        }

        public int[] intersection3(int[] nums1, int[] nums2) {
            Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            Set<Integer> set1, set2 = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int i : nums1) {
                list.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }
            list.retainAll(set2);
            set1 = new HashSet<>(list);
            return set1.stream().mapToInt(i -> i).toArray();
        }

        public int[] intersection1(int[] nums1, int[] nums2) {
            Set<Integer> result = new HashSet<>();
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }

            Iterator<Integer> iterator = set1.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (set2.contains(next)) {
                    result.add(next);
                }
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}