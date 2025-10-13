package com.src.main.leetcode.slidingwindow;

/**
 * 643. Maximum Average Subarray I
 */
public class LC643 {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;

        // Compute initial sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        // Maximum average
        return (double) maxSum / k;
    }

    // Main method to test
    public static void main(String[] args) {

        LC643 solution = new LC643();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(solution.findMaxAverage(nums, k)); // Output: 12.75
    }
}
