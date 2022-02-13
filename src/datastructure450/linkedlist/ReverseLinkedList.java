package datastructure450.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        print(node);
        ListNode reverse = reverseRecursive(node);
        System.out.println();
        print(reverse);
        System.out.println();
        reverseRecursive(reverse); // to make head start with 1
        ListNode listNode = reverseListIterative(node);
        print(listNode);
    }

    // O(n) time complexity
    private static ListNode reverseListIterative(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null, next, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // O(n) time complexity
    private static ListNode reverseRecursive(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode rest = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    private static void print(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
