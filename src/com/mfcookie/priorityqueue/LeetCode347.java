package com.mfcookie.priorityqueue;

import java.util.*;

/**
 * @author hmfcookie
 * @date 2020/5/7
 */
public class LeetCode347 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] ints = solution347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 5, 3, 2, 1, 3, 4}, 2);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
class Solution347 {
    int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0) {
            return result;
        }
        PriorityQueue<NumsWithFreq> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o2.freq - o1.freq);
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            NumsWithFreq numsWithFreq = new NumsWithFreq(entry.getKey(), entry.getValue());
            priorityQueue.add(numsWithFreq);
        }
        for (int i = 0; i < k; i++) {
            NumsWithFreq poll = priorityQueue.poll();
            assert poll != null;
            result[i] = poll.getNum();
        }
        return result;
    }

    static class NumsWithFreq {
        private int freq;
        private int num;

        NumsWithFreq(Integer num, Integer freq) {
            this.num = num;
            this.freq = freq;
        }

        int getNum() {
            return num;
        }
    }
}