package datastructure450.linkedlist;

// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

public class DetectAndDeleteLoopInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        deleteLoop(head);
    }

    // O(n) time complexity
    private static void deleteLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        if(fast==null || fast.next==null)
            System.out.println("No Loop exists");
        slow=head;
        if(slow != fast){
            while(slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
        }else{
            while(fast.next!=slow){
                fast=fast.next;
            }
        }
        fast.next=null;
        System.out.println("loop removed");
        print(head);
    }

    private static void print(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
