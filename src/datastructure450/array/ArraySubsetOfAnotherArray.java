package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1#

import java.util.HashSet;
import java.util.Set;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 4};
        System.out.println(isSubset(arr1, arr1.length, arr2, arr2.length));
    }

    private static boolean isSubset(int[] arr1, int n, int[] arr2, int m) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(arr1[i]);
        for (int i = 0; i < m; i++) {
            if (!set.contains(arr2[i]))
                return false;
        }
        return true;
    }
}
