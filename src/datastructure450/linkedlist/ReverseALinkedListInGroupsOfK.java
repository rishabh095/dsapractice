package datastructure450.linkedlist;

public class ReverseALinkedListInGroupsOfK {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        int k=3;
        print(node);
        ListNode listNode = reverseInGroup(node, k);
        System.out.println();
        print(listNode);
        System.out.println();

    }

    // O(n) time complexity
    private static ListNode reverseInGroup(ListNode node, int k) {
        ListNode next=null,prev=null,curr=node;
        int count=0;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null)
            node.next=reverseInGroup(next,k);
        return prev;
    }

    private static void print(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
