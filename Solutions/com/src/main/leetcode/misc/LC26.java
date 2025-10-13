package com.src.main.leetcode.misc;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class LC26 {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0; // pointer for last unique element
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) { // found a new unique element
                    nums[++index] = nums[i]; // place it next to the last unique one
                }
            }
            return index + 1; // total count = last index + 1
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = new int[]{1, 1, 2, 2, 3, 4};
        int k = solution.removeDuplicates(nums);

        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nUnique count: " + k);
    }
}
