package datastructure450.string;

// https://leetcode.com/problems/construct-k-palindrome-strings/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        String str = "annabelle";
        int k = 2;
        System.out.println(canConstruct(str, k));
    }

    // O(n) time complexity and O(n) space complexity
    private static boolean canConstruct(String str, int k) {
        if (k > str.length())
            return false;
        if (k == str.length())
            return true;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0)
                count++;
        }
        if (count > k)
            return false;
        return true;
    }
}
