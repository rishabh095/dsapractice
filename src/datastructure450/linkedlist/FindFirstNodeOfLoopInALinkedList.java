package datastructure450.linkedlist;

// https://leetcode.com/problems/linked-list-cycle-ii/
// https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/

public class FindFirstNodeOfLoopInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(firstNodeInLoop(head));
    }

    // O(n) time complexity
    private static int firstNodeInLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return -1;
        slow = head;
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        } else {
            while (fast.next != slow)
                fast = fast.next;
        }
        return fast.next.val;
    }
}
