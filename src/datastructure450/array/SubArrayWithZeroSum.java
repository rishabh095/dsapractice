package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1

import pos.Second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Pair1 {
    int first, second;

    Pair1(int a, int b) {
        first = a;
        second = b;
    }
}

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};//{4, 2, -3, 1, 6};
        System.out.println(findSum(arr));
        ArrayList<Pair1> subArrays = findSubArrays(arr, arr.length);
        for (Pair1 p : subArrays) {
            System.out.println(p.first + " " + p.second);
        }
    }

    // O(n*n) time complexity O(n) space complexity
    static ArrayList<Pair1> findSubArrays(int[] arr, int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair1> out = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0)
                out.add(new Pair1(0, i));
            ArrayList<Integer> al = new ArrayList<>();
            if (map.containsKey(sum)) {
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++) {
                    out.add(new Pair1(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }

    // O(n) time complexity O(n) space complexity
    private static boolean findSum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (num == 0 || sum == 0 || set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }
}
