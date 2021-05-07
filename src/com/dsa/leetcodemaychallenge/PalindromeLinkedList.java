package com.dsa.leetcodemaychallenge;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(2);
        node.next.next.next.next.next=new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=reverse(slow);
        while(head !=null && mid !=null){
            if(head.data !=mid.data)
                return false;
            head=head.next;
            mid=mid.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode slow) {
        ListNode head=null;
        while (slow !=null){
            ListNode temp=head;
            head=new ListNode(slow.data);
            head.next=temp;
            slow=slow.next;
        }
        return head;
    }
}
