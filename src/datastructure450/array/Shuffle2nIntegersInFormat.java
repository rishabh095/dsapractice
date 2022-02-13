package datastructure450.array;

// https://www.geeksforgeeks.org/shuffle-2n-integers-format-a1-b1-a2-b2-a3-b3-bn-without-using-extra-space/

import java.util.Arrays;

public class Shuffle2nIntegersInFormat {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(shuffle(arr, arr.length / 2)));
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        shuffleArray(arr1,0, arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void shuffleArray(int[] arr, int start, int end) {
        if(start>=end)
            return;
        if(end-start==1)
            return;
        int mid=(start+end)/2;
        int temp=mid+1;
        int mmid=(start+mid)/2;
        for(int i=mmid+1;i<=mid;i++){
            int temp1 = arr[i];
            arr[i] = arr[temp];
            arr[temp++] = temp1;
        }
        shuffleArray(arr,start,mid);
        shuffleArray(arr,mid+1,end);
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int[] shuffle(int[] arr, int n) {
        for (int i = 0, j = 1, k = n; i < n; i++, j++, k++) {
            for (int l = k; l > i + j; l--) {
                int temp = arr[l - 1];
                arr[l - 1] = arr[l];
                arr[l] = temp;
            }
        }
        return arr;
    }
}
