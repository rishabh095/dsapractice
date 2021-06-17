package datastructure450.array;

// https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

import java.util.ArrayList;
import java.util.List;

public class CommonElements3SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(arr1, arr2, arr3, arr1.length, arr2.length, arr3.length));
        System.out.println(commonElementsWithDuplicate(arr1, arr2, arr3, arr1.length, arr2.length, arr3.length));
    }

    // this method will work if arr contains duplicate elements
    // O(n1+n2+n3) time complexity and O(1) space complexity
    private static List<Integer> commonElementsWithDuplicate(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int prev1 = Integer.MIN_VALUE, prev2 = Integer.MIN_VALUE, prev3 = Integer.MIN_VALUE;
        while (i < n1 && j < n2 && k < n3) {
            while (prev1 == arr1[i] && i < n1)
                i++;
            while (prev2 == arr2[j] && j < n2)
                j++;
            while (prev3 == arr3[k] && k < n3)
                k++;
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                prev1 = arr1[i];
                prev2 = arr2[j];
                prev3 = arr3[k];
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                prev1 = arr1[i];
                i++;
            } else if (arr2[j] < arr3[k]) {
                prev2 = arr2[j];
                j++;
            } else {
                prev3 = arr3[k];
                k++;
            }
        }
        return result;
    }

    // this method will not work if arr contains duplicate elements
    // O(n1+n2+n3) time complexity and O(1) space complexity
    private static List<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
        return result;
    }
}
