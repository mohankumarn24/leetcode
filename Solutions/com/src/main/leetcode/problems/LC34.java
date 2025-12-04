package com.src.main.leetcode.problems;

import java.util.Arrays;

public class LC34 {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int second = findSecond(nums, target);
        return new int[]{first, second};
    }

    private int findFirst(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                pos = mid;
                high = mid - 1;
            }
        }
        return pos;
    }

    private int findSecond(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        LC34 sol = new LC34();
        int[] result = sol.searchRange(nums, target);

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(result));
    }
}
