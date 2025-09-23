package com.src.main.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 20. Valid Parentheses
 */
public class LC20 {

    static class Solution {

        public boolean isValid(String s) {

            Map<Character, Character> map = Map.of(
                    ')', '(',
                    '}', '{',
                    ']', '['
            );

            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                // its closing bracket
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || map.get(c) != stack.pop()) {
                        return false;
                    }
                } else {
                    // its opening bracket
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test cases
        String[] tests = {
                "()",        // true
                "()[]{}",    // true
                "(]",        // false
                "([)]",      // false
                "{[]}",      // true
                "",          // true
                "(((((",     // false
        };

        for (String test : tests) {
            System.out.println("Input: " + test + " → " + solution.isValid(test));
        }
    }
}

