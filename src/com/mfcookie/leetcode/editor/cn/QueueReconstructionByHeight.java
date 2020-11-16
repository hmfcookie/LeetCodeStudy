package com.mfcookie.leetcode.editor.cn;

//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//
// Related Topics 贪心算法
// 👍 651 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hmfcookie
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        int[][] a = {{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};
        int[][] ints = solution.reconstructQueue(a);
        for (int[] anInt : ints) {
            System.out.println(" " + Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (person1, person2) -> {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            });
            List<int[]> result = new ArrayList<>();
            for (int[] person : people) {
                if (person[1] >= result.size()) {
                    result.add(person);
                } else {
                    result.add(person[1], person);
                }
            }
            return result.toArray(new int[people.length][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}