package com.dsa.flipkart;

// https://leetcode.com/problems/reverse-nodes-in-k-group/

import java.util.List;

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        int k=2;
        printList(head);
        System.out.println();
        ListNode listNode = reverseKGroup(head, k);
        printList(listNode);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy,curr;
        int count;

        while(temp !=null){
            count=0;
            curr=temp;
            while(temp !=null && count<k){
                count++;
                temp=temp.next;
            }
            if(count==k){
                ListNode first=reverse(curr,k);
                prev.next=first;
                curr.next=temp;
                prev=curr;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode curr, int k) {
        ListNode prev=null,next;
        while(curr!=null && k-->0){
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
