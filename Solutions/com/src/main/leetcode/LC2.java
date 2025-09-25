package com.src.main.leetcode;

/**
 * 2. Add Two Numbers
 */
public class LC2 {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            int carry = 0;

            while (l1 != null || l2 != null || carry > 0) {
                int sum = carry;
                if (l1 != null) {
                    sum = sum + l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum = sum + l2.val;
                    l2 = l2.next;
                }

                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        // Example: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = sol.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" -> ");
            result = result.next;
        }
    }
}
