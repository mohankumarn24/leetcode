package com.src.main.leetcode;

public class LC28 {

    private static class Solution {

        public int strStr(String haystack, String needle) {

            if (needle.isEmpty()) return 0;

            // strstr(hello, ll)
            int m = haystack.length();  // 5
            int n = needle.length();    // 2

            // 5 - 2 = 3
            for (int i = 0; i <= m - n; i++) {
                int j;
                for (j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == n) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(String.format("strstr(hello, ll)  : %d", solution.strStr("hello", "ll")));     // 2
        System.out.println(String.format("strstr(aaaaa, bba) : %d", solution.strStr("aaaaa", "bba")));    // -1
        System.out.println(String.format("strstr(abc, \"\")    : %d", solution.strStr("abc", "")));       // 0
    }
}
