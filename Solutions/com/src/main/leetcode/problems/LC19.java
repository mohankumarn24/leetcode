package com.src.main.leetcode.problems;

public class LC19 {

    // ListNode definition
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Two-pointer solution
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // move fast n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move both until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete the node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // helper to print list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // main function
    public static void main(String[] args) {

        // create list: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // remove 2nd node from end

        System.out.println("Original list:");
        printList(head);

        ListNode newHead = removeNthFromEnd(head, n);

        System.out.println("After removing " + n + "th node from end:");
        printList(newHead);
    }
}
