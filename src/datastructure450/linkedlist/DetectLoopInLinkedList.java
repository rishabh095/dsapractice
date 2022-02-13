package datastructure450.linkedlist;

// https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(isLoopExist(head));
    }

    // O(n) time complexity
    private static boolean isLoopExist(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
