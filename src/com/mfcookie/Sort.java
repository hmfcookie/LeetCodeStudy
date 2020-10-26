package com.mfcookie;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 1, 7, 9, 5, 8};
//        Sort.insertSort(ints);
//        Sort.mergeSort(ints);
        Sort.quickSort(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 快排
     *
     * @param nums
     */
    private static void quickSort(int[] nums) {
        myQuickSort(nums, 0, nums.length - 1);
    }

    private static void myQuickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(nums, lo, hi);
        myQuickSort(nums, lo, pivot - 1);
        myQuickSort(nums, pivot + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int mark = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] < pivot) {
                // 如果比基准值小，需要将该值与基准值交换
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }

        nums[lo] = nums[mark];
        nums[mark] = pivot;
        return mark;

    }

    /**
     * 插入
     *
     * @param ints
     */
    static void insertSort(int[] ints) {
        for (int i = 1, j, current; i < ints.length; i++) {
            current = ints[i];
            for (j = i - 1; j >= 0 && ints[j] > current; j--) {
                ints[j + 1] = ints[j];
            }
            ints[j + 1] = current;
        }
    }

    /**
     * 归并
     *
     * @param nums
     */
    static void mergeSort(int[] nums) {
        myMergeSort(nums, 0, nums.length - 1);
    }

    private static void myMergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        myMergeSort(nums, lo, mid);
        myMergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy = nums.clone();

        int k = lo, i = lo, j = mid + 1;

        while (k <= hi) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > hi) {
                nums[k++] = copy[i++];
            } else if (copy[i] > copy[j]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }
}
