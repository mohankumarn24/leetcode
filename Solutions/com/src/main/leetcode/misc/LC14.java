package com.src.main.leetcode.misc;

public class LC14 {

    private static class Solution {

        // Function to find the longest common prefix
        public String longestCommonPrefix(String[] strs) {

            if (strs == null || strs.length == 0) return "";

            // Start with the first string as prefix
            String prefix = strs[0];

            // Compare with each string
            for (int i = 1; i < strs.length; i++) {
                // Reduce prefix until it matches the start of strs[i]
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strs1 = {"flower", "flow", "flight"};
        // String[] strs2 = {"dog", "racecar", "car"};

        System.out.println("Longest Common Prefix of strs1: " + solution.longestCommonPrefix(strs1));
        // System.out.println("Longest Common Prefix of strs2: " + solution.longestCommonPrefix(strs2));
    }
}

/**
 * String str = "hello world";
 * System.out.println(str.indexOf("world")); // 6
 * System.out.println(str.indexOf('o'));     // 4
 * System.out.println(str.indexOf("z"));     // -1
 */