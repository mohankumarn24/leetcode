package com.src.main.leetcode.problems;

/**
 * 643. Maximum Average Subarray I
 */
public class LC643 {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double windowSum = 0;

        // Step 1: Calculate sum of first k elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: Return average
        return maxSum / k;
    }

    public static void main(String[] args) {
        
        LC643 sol = new LC643();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = sol.findMaxAverage(nums, k);
        System.out.println("Maximum average subarray = " + result);
    }
}

