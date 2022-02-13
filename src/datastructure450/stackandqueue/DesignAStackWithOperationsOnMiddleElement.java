package datastructure450.stackandqueue;

// https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

class MyStack {
    DoublyLinkedList head;
    DoublyLinkedList mid;
    int count;

}

public class DesignAStackWithOperationsOnMiddleElement {
    static MyStack stack;

    public static void main(String[] args) {
        stack = new MyStack();
        stack.count = 0;
        push(11);
        push(22);
        push(33);
        push(44);
        push(55);
        push(66);
        push(77);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(middle());
    }

    private static void push(int data) {
        DoublyLinkedList node = new DoublyLinkedList(data);
        node.prev = null;
        node.next = stack.head;
        stack.count++;
        if (stack.count == 1)
            stack.mid = node;
        else {
            stack.head.prev = node;
            if (stack.count % 2 != 0)
                stack.mid = stack.mid.prev;
        }
        stack.head = node;
    }

    private static int pop() {
        if (stack.count == 0)
            return -1;
        DoublyLinkedList node = stack.head;
        int result = node.val;
        stack.head = node.next;
        if (stack.head != null)
            stack.head.prev = null;
        stack.count--;
        if (stack.count % 2 == 0)
            stack.mid = stack.mid.next;
        return result;
    }

    private static int middle() {
        if (stack.count == 0)
            return -1;
        return stack.mid.val;
    }
}
