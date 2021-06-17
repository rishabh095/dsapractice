package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, 0, arr.length - 1));
    }

    // O(n log n) time complexity and O(1) space complexity
    private static int inversionCount(int[] arr, int start, int end) {
        int res = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            res += inversionCount(arr, start, mid);
            res += inversionCount(arr, mid + 1, end);
            res += merge(arr, start, mid, end);
        }
        return res;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[start + i];
        for (int i = 0; i < n2; i++)
            right[i] = arr[mid + 1 + i];
        int res = 0, i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                res += (n1 - i);
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
        return res;
    }
}
