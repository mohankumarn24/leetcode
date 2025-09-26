package com.src.main.leetcode;

public class LC24 {

    /**
     *  dummy | a  b | c  d | e  f | null
     *  dummy -> b > a and so on
     */
    static class Solution {

        public ListNode swapPairs(ListNode head) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.next != null) {
                ListNode first = prev.next;
                ListNode second = prev.next.next;

                // Swapping
                first.next = second.next;
                second.next = first;
                prev.next = second;

                // Move prev two nodes ahead
                prev = first;
            }

            return dummy.next;
        }
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);

        ListNode swapped = solution.swapPairs(head);

        // 2 -> 1 -> 4 -> 3
        System.out.println("\nAfter swapping in pairs:");
        printList(swapped);
    }
}

