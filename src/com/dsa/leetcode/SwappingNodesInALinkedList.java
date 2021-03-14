package com.dsa.leetcode;

// 1721. Swapping Nodes in a Linked List
// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        int k = 2;
        swapNodes(head, k);
        //swapNodesTwoLoop(head, k);
        System.out.println();
        printList(head);
    }

    // this method is working fine.
    // O(n) time complexity and O(1) space complexity
    /*private static void swapNodesTwoLoop(ListNode head, int k) {
        int listLength = 0;
        ListNode frontNode = null, endNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            listLength++;
            if (listLength == k) {
                frontNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        int count = 0;
        currentNode = head;
        while (count != listLength - k) {
            count++;
            currentNode = currentNode.next;
        }
        endNode = currentNode;
        int tempNode = frontNode.data;
        frontNode.data = endNode.data;
        endNode.data = tempNode;
    }*/

    // O(n) time complexity and O(1) space complexity
    private static void swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        ListNode first = temp;
        temp = head;
        count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while (temp != null && i < count - k) {
            temp = temp.next;
            i++;
        }
        ListNode second = temp;
        int data = first.data;
        first.data = second.data;
        second.data = data;
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
