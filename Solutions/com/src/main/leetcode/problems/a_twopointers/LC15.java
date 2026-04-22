package com.src.main.leetcode.problems.a_twopointers;

import java.util.*;

// 15. 3Sum
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-1, 0, 1, 2, -1, -4]
        // 1. Sort the array so we can use two pointers: [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // 2. Iterate through the array (the "Leader" i)
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // Skip duplicates for the leader
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, res);                               // [-4, -1, -1, 0, 1, 2]
                                                                    //   x   -            -
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];

            if (sum < 0) {
                // Sum is too small, we need a bigger number (move right)
                low++;
            } else if (sum > 0) {
                // Sum is too big, we need a smaller number (move left)
                high--;
            } else {
                // Perfect match!
                res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));

                // Skip duplicate for low and high
                while (low < high && nums[low] == nums[low - 1]) low++;
                while (low < high && nums[high] == nums[high + 1]) high--;
            }
        }
    }

    // MAIN FUNCTION TO TEST THE CODE
    public static void main(String[] args) {
        LC15 sol = new LC15();

        // Example Input
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums));
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println("Unique Triplets: " + result);
    }
}


/*
Skip duplicates: [-2, 0, 0, 2, 2]
          index: [ 0, 1, 2, 3, 4]
                   x  -        -

1. Leader (i) is -2
   low is 0 (index 1), high is 2 (index 4)
   Sum is 0! Triplet [-2, 0, 2] is added
4. low moves to index 2 (another 0), high moves to index 3 (another 2)
5. while loop 1: It sees nums[2] is still 0. It executes low++ to skip it
   while loop 2: It sees nums[3] is still 2. It executes high-- to skip it
6. The pointers have now crossed, and the loop finishes cleanly without adding the same [-2, 0, 2] a second time
*/
