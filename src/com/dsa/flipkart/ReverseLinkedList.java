package com.dsa.flipkart;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode listNode = reverseList(head);
        System.out.println();
        printList(listNode);
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev=null,next,curr=head;
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static void printList(ListNode head) {
        if (head == null)
            return;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        return;
    }
}
