package datastructure450.linkedlist;

import java.util.*;

public class RemoveDuplicateElementFromSortedLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(5);
        print(head);
        System.out.println();
        removeDuplicate(head);
        print(head);
        System.out.println();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next.next.next.next = new ListNode(5);
        removeDuplicateRecursive(head);
        print(head);
    }

    // O(n) time complexity
    private static void removeDuplicateRecursive(ListNode head) {
        if (head == null)
            return;
        if (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                removeDuplicateRecursive(head);
            }
            removeDuplicateRecursive(head.next);
        }
    }

    // O(n) time complexity
    private static void removeDuplicate(ListNode head) {
        while (head != null && head.next != null) {
            if (head.val == head.next.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
    }

    // O(n) time complexity
    private static void print(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
