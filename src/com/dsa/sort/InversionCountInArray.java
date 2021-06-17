package com.dsa.sort;

public class InversionCountInArray {
    public static void main(String[] args) {
        int[] arr ={468,335, 1, 170, 225 ,479 ,359, 463 ,465 ,206 ,146, 282, 328, 462, 492, 496, 443, 328, 437, 392 ,105 ,403 ,154 ,293, 383, 422 ,217 ,219 ,396 ,448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323}; //{2,5, 8, 11, 3, 6, 9, 13};
        System.out.println(countInversion(arr, 0, arr.length - 1));
        int[] arr1 = {2,5, 8, 11, 3, 6, 9, 13};
        System.out.println(countInversion(arr1, arr1.length));
    }

    //time complexity O(n*n) and space complexity O(1).
    private static int countInversion(int[] arr, int n) {
        int res=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j])
                    res++;
            }
        }
        return res;
    }

    //time complexity O(n log n) and space complexity O(n) concept of merge sort.
    private static int countInversion(int[] arr, int left, int right) {
        int res = 0;
        if (right > left) {
            int mid = left + (right - left) / 2;
            res += countInversion(arr, left, mid);
            res += countInversion(arr, mid + 1, right);
            res += mergeAndCount(arr, left, mid, right);
        }
        return res;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[i + left];
        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[i + mid + 1];
        int res = 0, i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else {
                arr[k++] = rightArr[j++];
                res += (n1 - i);
            }
        }
        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];
        return res;
    }
}
