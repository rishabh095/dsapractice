package com.dsa.array;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int sum = 12;
        ArrayList<Integer> integers = subArraySum(arr, sum);
        System.out.println(integers);
    }

     // O(n) time complexity
    private static ArrayList<Integer> subArraySum(int[] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int currSum = arr[0];
        int start = 0;
        int last = 0;
        int n = arr.length;

        while (currSum != sum) {
            if (currSum > sum)
                currSum -= arr[start++];
            else {
                last++;
                if (last < n)
                    currSum += arr[last];
                else
                    break;
            }
        }
        if (currSum != sum)
            result.add(-1);
        else {
            result.add(++start);
            result.add(++last);
        }
        return result;
    }
}
