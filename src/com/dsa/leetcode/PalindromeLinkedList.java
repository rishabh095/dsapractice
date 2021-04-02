package com.dsa.leetcode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        printList(head);
        System.out.println();
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast !=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=reverse(slow);
        while(head!=null && mid!=null){
            if(head.data !=mid.data)
                return false;
            head=head.next;
            mid=mid.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode slow) {
        ListNode head=null;
        while(slow !=null){
            ListNode temp=head;
            head=new ListNode(slow.data);
            head.next=temp;
            slow=slow.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
