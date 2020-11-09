package com.mfcookie.leetcode.editor.cn;

//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 185 👎 0


import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random rand = new Random();

        public int[][] kClosest(int[][] points, int K) {
            int n = points.length;
            random_select(points, 0, n - 1, K);
            return Arrays.copyOfRange(points, 0, K);
        }

        public void random_select(int[][] points, int left, int right, int K) {
            int pivotId = left + rand.nextInt(right - left + 1);
            int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
            swap(points, right, pivotId);
            int i = left - 1;
            for (int j = left; j < right; ++j) {
                int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
                if (dist <= pivot) {
                    ++i;
                    swap(points, i, j);
                }
            }
            ++i;
            swap(points, i, right);
            // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
            if (K < i - left + 1) {
                random_select(points, left, i - 1, K);
            } else if (K > i - left + 1) {
                random_select(points, i + 1, right, K - (i - left + 1));
            }
        }

        public void swap(int[][] points, int index1, int index2) {
            int[] temp = points[index1];
            points[index1] = points[index2];
            points[index2] = temp;
        }

        // 优先队列 占用更少的空间
        public int[][] kClosest3(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((array1, array2) -> array2[0] - array1[0]);

            for (int i = 0; i < K; i++) {
                int[] point = points[i];
                int a = point[0], b = point[1];
                pq.offer(new int[]{a * a + b * b, i});
            }
            for (int i = K; i < points.length; i++) {
                int[] point = points[i];
                int i1 = point[0] * point[0] + point[1] * point[1];
                int[] peek = pq.peek();
                if (i1 < peek[0]) {
                    pq.poll();
                    pq.offer(new int[]{i1, i});
                }
            }
            int[][] result = new int[K][2];
            for (int i = 0; i < K; i++) {
                int[] poll = pq.poll();
                result[i] = points[poll[1]];
            }
            return result;
        }

        // 优先队列
        public int[][] kClosest2(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                int a = point[0], b = point[1];
                pq.offer(new int[]{a * a + b * b, i});
            }
            int[][] result = new int[K][2];
            for (int i = 0; i < K; i++) {
                int[] poll = pq.poll();
                result[i] = points[poll[1]];
            }
            return result;
        }

        // 排序
        public int[][] kClosest1(int[][] points, int K) {
            Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
            return Arrays.copyOfRange(points, 0, K);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}