package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedStringInSequence {
    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println(secFrequent(arr, arr.length));
    }

    // O(n) time complexity and O(n) space complexity
    private static String secFrequent(String[] arr, int n) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val > first) {
                second = first;
                first = val;
            } else if (val > second && val != first)
                second = val;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == second)
                return entry.getKey();
        }
        return null;
    }
}
