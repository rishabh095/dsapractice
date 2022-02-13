package datastructure450.heap;

// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        int k = 3;
        ListNode[] arr = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        ListNode head = mergeKSortedLists(arr, k - 1);
        printList(head);
        System.out.println();
        ListNode[] arr1 = new ListNode[k];

        arr1[0] = new ListNode(1);
        arr1[0].next = new ListNode(3);
        arr1[0].next.next = new ListNode(5);
        arr1[0].next.next.next = new ListNode(7);

        arr1[1] = new ListNode(2);
        arr1[1].next = new ListNode(4);
        arr1[1].next.next = new ListNode(6);
        arr1[1].next.next.next = new ListNode(8);

        arr1[2] = new ListNode(0);
        arr1[2].next = new ListNode(9);
        arr1[2].next.next = new ListNode(10);
        arr1[2].next.next.next = new ListNode(11);
        ListNode head1 = mergeKSortedListsHeap(arr1, k);
        printList(head1);
    }

    // O(n * k * log k) time complexity and O(k) space complexity
    private static ListNode mergeKSortedListsHeap(ListNode[] arr, int k) {
        ListNode head = null, last = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (curr.next != null)
                pq.add(curr.next);
            if (head == null) {
                head = curr;
                last = curr;
            } else {
                last.next = curr;
                last = curr;
            }
        }
        return head;
    }

    // merged sort used
    // n*k is total no of elements so O(n*k log k) time complexity O(n*k) space complexity
    private static ListNode mergeKSortedLists(ListNode[] arr, int k) {
        while (k != 0) {
            int i = 0, j = k;
            while (i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j)
                    k = j;
            }
        }
        return arr[0];
    }

    private static ListNode sortedMerge(ListNode first, ListNode second) {
        ListNode result;
        if (first == null)
            return second;
        else if (second == null)
            return first;
        if (first.val <= second.val) {
            result = first;
            result.next = sortedMerge(first.next, second);
        } else {
            result = second;
            result.next = sortedMerge(first, second.next);
        }
        return result;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
