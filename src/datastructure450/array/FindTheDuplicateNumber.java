package datastructure450.array;

// https://leetcode.com/problems/find-the-duplicate-number/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateUsingSetSorting(arr));
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateUsingSet(arr1));
        System.out.println(findDuplicateBestSolution(arr1));
    }

    // Floyd's Tortoise and Hare (Cycle Detection)
    // O(n) time complexity
    private static int findDuplicateBestSolution(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
    }

    // O(n) time complexity and O(n) space complexity
    private static int findDuplicateUsingSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    // O(n log n) time complexity
    private static int findDuplicateUsingSetSorting(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
