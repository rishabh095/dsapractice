package datastructure450.array;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {48, 24, 99, 51, 33, 39, 29, 83, 74, 72, 22, 46, 40, 51, 67, 37, 78, 76, 26, 28, 76,
                25, 10, 65, 64, 47, 34, 88, 26, 49, 86, 73, 73, 36, 75, 5, 26, 4, 39, 99, 27, 12, 97,
                67, 63, 15, 3, 92, 90};//{1, 5, 7, 1};
        int n = arr.length, k = 50;//6;
        System.out.println(getPairsCount(arr, n, k));
        System.out.println(getPairsCountBetterSolution(arr, n, k));
    }

    private static int getPairsCountBetterSolution(int[] arr, int n, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
//            if (!map.containsKey(arr[i]))
//                map.put(arr[i], 0);
//            map.put(arr[i], map.get(arr[i]) + 1);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i]))
                count += map.get(k - arr[i]);
            if (k - arr[i] == arr[i])
                count--;
        }
        return (count) / 2;
    }

    // O(n*n) time complexity
    private static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k)
                    count++;
            }
        }
        return count;
    }
}
