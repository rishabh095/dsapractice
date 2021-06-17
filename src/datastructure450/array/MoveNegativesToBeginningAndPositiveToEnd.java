package datastructure450.array;

import java.util.Arrays;

public class MoveNegativesToBeginningAndPositiveToEnd {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr));
        moveUsingLomutoPartitionProcessQuicksort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int[] arr1 = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr1));
        moveUsingTwoPointerApproach(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // O(n) time complexity
    private static void moveUsingTwoPointerApproach(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            if (arr[low] < 0 && arr[high] < 0)
                low++;
            else if (arr[low] < 0 && arr[high] > 0) {
                low++;
                high--;
            } else if (arr[low] > 0 && arr[high] > 0)
                high--;
            else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }

        }
    }

    // O(n) time complexity
    private static void moveUsingLomutoPartitionProcessQuicksort(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; i++) {
            if (arr[i] < 0) {
                if (i != low)
                    swap(arr, i, low);
                low++;
            }
        }
    }

    private static void swap(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }
}
