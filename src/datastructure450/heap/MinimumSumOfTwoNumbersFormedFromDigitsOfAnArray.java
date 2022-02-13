package datastructure450.heap;

// https://www.geeksforgeeks.org/minimum-sum-two-numbers-formed-digits-array/

import java.util.Arrays;

public class MinimumSumOfTwoNumbersFormedFromDigitsOfAnArray {
    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        System.out.println(sum(arr, arr.length));
    }

    private static String sum(int[] arr, int n) {
        Arrays.sort(arr);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                a = a * 10 + arr[i];
            else
                b = b * 10 + arr[i];
        }
        return String.valueOf(a + b);
    }
}
