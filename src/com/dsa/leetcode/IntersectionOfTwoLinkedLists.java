package com.dsa.leetcode;

// 160. Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        ListNode list = new ListNode(8);
        list.next = new ListNode(4);
        list.next.next = new ListNode(5);
        head1.next.next = list;
        printList(head1);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next = list;
        System.out.println();
        printList(head2);
        System.out.println();
        ListNode intersectionNode = getIntersectionNode(head1, head2);
        System.out.println(intersectionNode.data);
    }

    private static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int count1 = 0, count2 = 0;
        ListNode temp1=head1,temp2=head2;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                count1++;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                count2++;
                temp2 = temp2.next;
            }
        }
        if (count1 < count2) {
            for (int i = 0; i < count2 - count1; i++)
                head2 = head2.next;
        }else{
            for (int i = 0; i < count1 - count2; i++)
                head1 = head1.next;
        }
        while(head1 !=head2){
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }

    private static void printList(ListNode head) {
        if (head == null)
            return;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
