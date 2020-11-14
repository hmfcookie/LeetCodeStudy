package com.mfcookie.leetcode.editor.cn;

//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 104 👎 0


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hmfcookie
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] ints = solution.relativeSortArray(arr1, arr2);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public static final int MAX_VALUE = 1001;

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> numPositions = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[i], i -> i));
            return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
                int a1 = numPositions.getOrDefault(o1, MAX_VALUE);
                int a2 = numPositions.getOrDefault(o2, MAX_VALUE);
                if (a1 != MAX_VALUE || a2 != MAX_VALUE) {
                    return a1 - a2;
                }
                return o1 - o2;
            }).mapToInt(o -> o).toArray();
        }

        public int[] relativeSortArray1(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>(arr1.length);
            List<Integer> list = new ArrayList<>();
            for (int num : arr1) {
                list.add(num);
            }
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            list.sort((x, y) -> {
                if (map.containsKey(x) || map.containsKey(y)) {
                    return map.getOrDefault(x, MAX_VALUE) - map.getOrDefault(y, MAX_VALUE);
                }
                return x - y;
            });
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = list.get(i);
            }
            return arr1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}