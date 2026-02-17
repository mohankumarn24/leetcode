package com.src.main.leetcode.problems.a_twopointers;

public class LC148 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Sort List using Merge Sort (recursive)
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split list into two halves
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // Merge sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Find middle node using slow/fast pointers
    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // Utility method to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        // Create list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Before sort: ");
        printList(head);

        head = sortList(head);

        System.out.print("After sort:  ");
        printList(head);
    }
}
