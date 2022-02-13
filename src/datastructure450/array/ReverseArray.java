package datastructure450.array;

// https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        System.out.println(Arrays.toString(array1));
        reverseArrayIterative(array1, array1.length - 1);
        System.out.println(Arrays.toString(array1));
        System.out.println();
        int[] array2 = {4, 5, 1, 2};
        System.out.println(Arrays.toString(array2));
        reverseArrayRecursive(array2,0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }

    // O(n) time complexity
    private static void reverseArrayRecursive(int[] array, int start,int last) {
        if(start>=last)
            return;
        swap(start,last,array);
        reverseArrayRecursive(array,start+1,last-1);
    }

    // O(n) time complexity
    private static void reverseArrayIterative(int[] array, int n) {
        int start=0,last=n;
        while(start<last) {
            swap(start, last, array);
            start++;
            last--;
        }
    }

    private static void swap(int start, int last, int[] array) {
        int temp=array[last];
        array[last]=array[start];
        array[start]=temp;
    }
}
