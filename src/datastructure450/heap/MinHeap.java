package datastructure450.heap;

// https://www.geeksforgeeks.org/binary-heap/

public class MinHeap {
    static int[] arr;
    static int heapSize, capacity;

    public static void main(String[] args) {
        heapSize = 0;
        arr = new int[10];
        capacity = 10;
        insertKey(3);
        insertKey(2);
        delete(1);
        insertKey(15);
        insertKey(5);
        insertKey(4);
        insertKey(45);
        System.out.println(extractMin());
        System.out.println(getMin());
        decreaseKey(2, 1);
        System.out.println(getMin());
        insertKey(60);
    }

    private static int getMin() {
        return arr[0];
    }

    private static void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    private static void decreaseKey(int i, int newValue) {
        arr[i] = newValue;
        while (i != 0 && arr[getParent(i)] > arr[i]) {
            swap(arr, getParent(i), i);
            i = getParent(i);
        }
    }

    private static int extractMin() {
        if (heapSize <= 0)
            return Integer.MIN_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        heapify(0);
        return root;
    }

    private static void heapify(int i) {
        int smallest = i;
        int left = getLeft(i);
        int right = getRight(i);
        if (left < heapSize && arr[left] < arr[smallest])
            smallest = left;
        if (right < heapSize && arr[right] < arr[smallest])
            smallest = right;
        if (smallest != i) {
            swap(arr, i, smallest);
            heapify(smallest);
        }
    }

    private static void insertKey(int key) {
        if (heapSize == capacity)
            return;
        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;
        while (i != 0 && arr[getParent(i)] > arr[i]) {
            swap(arr, getParent(i), i);
            i = getParent(i);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    private static int getParent(int i) {
        return (i - 1) / 2;
    }

    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    private static int getRight(int i) {
        return 2 * i + 2;
    }
}
