package com.src.main.leetcode.misc;

public class LC27 {

    private static class Solution {
        public int removeElement(int[] nums, int val) {
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[++index] = nums[i];
                }
            }
            return index + 1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 4};
        int val = 2 ;

        int newLength = solution.removeElement(nums, val);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nNew length: " + newLength);
    }
}
