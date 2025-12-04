package com.src.main.leetcode.problems;

/**
 * 9. Palindrome Number
 */

public class LC9 {

    static class Solution {

        public boolean isPalindrome(int x) {

            if (x < 0) return false;

            int original = x;
            long reversed = 0;   // long to avoid overflow

            while (x > 0) {
                int digit = x % 10;
                reversed = reversed * 10 + digit;
                x /= 10;
            }

            return original == reversed;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int num1 = 121;
        int num2 = -121;
        int num3 = 10;
        int num4 = 1221;

        System.out.println(num1 + " is palindrome? " + solution.isPalindrome(num1)); // true
        System.out.println(num2 + " is palindrome? " + solution.isPalindrome(num2)); // false
        System.out.println(num3 + " is palindrome? " + solution.isPalindrome(num3)); // false
        System.out.println(num4 + " is palindrome? " + solution.isPalindrome(num4)); // true
    }
}
