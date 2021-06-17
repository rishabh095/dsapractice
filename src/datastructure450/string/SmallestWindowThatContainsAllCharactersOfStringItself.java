package datastructure450.string;

// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestWindowThatContainsAllCharactersOfStringItself {
    public static void main(String[] args) {
        String str = "AABBBCBB";//"GEEKSGEEKSFOR";//"aabcbcdbca";
        System.out.println(findSmallestSubString(str, str.length()));
        System.out.println(findSmallestSubStringBetterSolution(str, str.length()));
    }

    // O(n) time complexity and O(n) space complexity
    private static String findSmallestSubStringBetterSolution(String str, int n) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            charSet.add(str.charAt(i));
        int distinctCount = charSet.size();
        int start = 0, startIndex = -1;
        int size = Integer.MAX_VALUE;
        int count = 0;
        int[] currCount = new int[256];
        for (int j = 0; j < n; j++) {
            currCount[str.charAt(j)]++;
            if (currCount[str.charAt(j)] == 1)
                count++;
            if (count == distinctCount) {
                while (currCount[str.charAt(start)] > 1) {
                    if (currCount[str.charAt(start)] > 1)
                        currCount[str.charAt(start)]--;
                    start++;
                }
                int currWindowLength = j - start + 1;
                if (size > currWindowLength) {
                    size = currWindowLength;
                    startIndex = start;
                }
            }
        }
        return str.substring(startIndex, startIndex + size);
    }

    // O(n*n) time complexity and O(n) space complexity
    private static String findSmallestSubString(String str, int n) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            charSet.add(str.charAt(i));
        int distinctCount = charSet.size();
        String result = "";
        int size = Integer.MAX_VALUE;
        boolean[] visited = new boolean[256];
        for (int i = 0; i < n; i++) {
            int count = 0;
            StringBuilder subRes = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (!visited[str.charAt(j)]) {
                    count++;
                    visited[str.charAt(j)] = true;
                }
                subRes.append(str.charAt(j));
                if (count == distinctCount)
                    break;
            }
            if (subRes.length() < size && distinctCount == count) {
                result = subRes.toString();
                size = subRes.length();
            }
            Arrays.fill(visited, false);
        }
        return result;
    }
}
