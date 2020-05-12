package com.mfcookie.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hmfcookie
 * @date 2020/5/11
 */
public class LeetCode39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        List<List<Integer>> lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("lists = " + lists);
    }
}

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution39 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList();
        process(candidates, target, 0, list);
        return result;
    }

    private void process(int[] candidates, int target, int start, List<Integer> list) {
        if (candidates == null || candidates.length == 0) {
            return;
        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            // 递归
            process(candidates, target - candidates[i], i, list);
            // 回溯
            list.remove(list.size() - 1);
        }

    }
}
