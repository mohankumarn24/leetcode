package com.src.main.leetcode.problems;

import java.util.LinkedHashSet;
import java.util.Set;

public class LC3 {

    // Sliding Window: We expand a window using two pointers and shrink it whenever a duplicate is found.
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>(); // use HashSet<>()
        int left = 0;
        int maxLen = 0;

        // abcabcbb
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If the character I'm trying to add (c) already exists in my window, then keep shrinking the window from the left until 'c' is no longer inside
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Input: " + s);
        System.out.println("Longest substring without repeating characters length = " + result);
    }
}