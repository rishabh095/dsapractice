package datastructure450.backtracking;

// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfAGivenString {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(findPermutation(s));
    }

    // O(n!) time complexity
    private static List<String> findPermutation(String s) {
        List<String> list = new ArrayList<>();
        findPermutation(s, 0, s.length() - 1, list);
        Collections.sort(list);
        return list;
    }

    private static void findPermutation(String s, int start, int end, List<String> list) {
        if (start == end) {
            list.add(s);
            return;
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s.toCharArray(), start, i);
                findPermutation(s, start + 1, end, list);
                s = swap(s.toCharArray(), start, i);
            }
        }
    }

    private static String swap(char[] strArray, int start, int end) {
        char temp = strArray[start];
        strArray[start] = strArray[end];
        strArray[end] = temp;
        return String.valueOf(strArray);
    }
}
