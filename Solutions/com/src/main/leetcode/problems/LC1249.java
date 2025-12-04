package com.src.main.leetcode.problems;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class LC1249 {

    // a)(b(c)d -> Output: a(bc)d
    static class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder();
            int open = 0;

            // a)(b(c)d -> a(b(c)d
            // First pass: remove invalid ')'
            // for (char c : s.toCharArray()) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    open++;
                    sb.append(c);
                } else if (c == ')') {
                    if (open > 0) {
                        open--;
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }

            // // a)(b(c)d -> a(b(c)d -> a(bc)d
            // Second pass: remove extra '(' from the end
            StringBuilder result = new StringBuilder();
            for (int i = sb.length() - 1; i >= 0; i--) {
                char c = sb.charAt(i);
                if (c == '(') {
                    if (open > 0) {
                        open--;
                        continue; // skip extra '('
                    }
                }
                result.append(c);
            }

            return result.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "a)(b(c)d";
        String s2 = "a)b(c)d";
        String s3 = "))((";
        String s4 = "(a(b(c)d)";

        System.out.println("Input: " + s1 + " -> Output: " + solution.minRemoveToMakeValid(s1));
        System.out.println("Input: " + s2 + " -> Output: " + solution.minRemoveToMakeValid(s2));
        System.out.println("Input: " + s3 + " -> Output: " + solution.minRemoveToMakeValid(s3));
        System.out.println("Input: " + s4 + " -> Output: " + solution.minRemoveToMakeValid(s4));
    }
}

