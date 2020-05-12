package com.mfcookie.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hmfcookie
 * @date 2020/5/11
 */
public class LeetCode0806 {
    public static void main(String[] args) {
        Solution0806 solution0806 = new Solution0806();

        List<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);
        Integer remove1 = A.remove(1);

        List<Integer> integers = Arrays.asList(4, 1);
        Integer remove2 = integers.remove(1);

        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        solution0806.hanota(A, B, C);
        System.out.println("C = " + C);
    }
}

/**
 * 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A.size(), A, B, C);
    }

    /**
     * @param n    问题的规模
     * @param from 源
     * @param help 辅助
     * @param to   目的
     */
    private void process(int n, List<Integer> from, List<Integer> help, List<Integer> to) {
        if (n == 1) {
            to.add(from.remove(from.size() - 1));
            return;
        }

        process(n - 1, from, to, help);
        to.add(from.remove(from.size() - 1));
        process(n - 1, help, from, to);
    }
}