package com.dsa.flipkart;

public class RotateRight {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        printList(head);
        System.out.println();
        ListNode rotate = rotate(head, 2);
        printList(rotate);
    }

    private static ListNode rotate(ListNode head,int k) {
        if(head ==null || k==0)
            return head;
        int length=0;
        ListNode curr=head;
        while(curr.next !=null){
            length++;
            curr=curr.next;
        }
        length++;
        curr.next=head;
        int rotatePoint = length - k % length;
        curr = head;
        while(rotatePoint-- > 1)
            curr = curr.next;
        head = curr.next;
        curr.next = null;
        return head;
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
