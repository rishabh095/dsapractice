package datastructure450.linkedlist;

class DoublyNode {
    int data;
    DoublyNode next, prev;

    DoublyNode(int d) {
        data = d;
    }
}

public class REVERSEDoublyLinkedList {
    static DoublyNode head;

    public static void main(String[] args) {
        push(2);
        push(4);
        push(8);
        push(10);

        System.out.println("Original linked list ");
        printList(head);

        reverse();
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        printList(head);
    }

    private static void reverse() {
        DoublyNode temp = null, curr = head;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null)
            head = temp.prev;
    }

    static void push(int data) {
        DoublyNode new_node = new DoublyNode(data);
        new_node.prev = null;
        new_node.next = head;
        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
    }

    static void printList(DoublyNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
