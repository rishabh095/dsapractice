package datastructure450.backtracking;

// https://www.geeksforgeeks.org/combinational-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};//{7, 2, 6, 5};
        int sum = 5;//16;
        List<List<Integer>> lists = combinationSum(arr, sum);
        for (List<Integer> list : lists)
            System.out.println(list);
    }

    // O(k * n^sum) where k is the length of solution and O(2^n) space complexity
    private static List<List<Integer>> combinationSum(int[] arr, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // remove duplicates if have
        Arrays.sort(arr);
        combinationSumUtil(arr, sum, ans, temp, 0);
        return ans;
    }

    private static void combinationSumUtil(int[] arr, int sum, List<List<Integer>> ans,
                                           List<Integer> temp, int index) {
        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (sum - arr[i] >= 0) {
                temp.add(arr[i]);
                combinationSumUtil(arr, sum - arr[i], ans, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
