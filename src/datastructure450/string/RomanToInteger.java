package datastructure450.string;

// https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<Character, Integer> roman;

    public static void main(String[] args) {
        String str = "IX";
        System.out.println(romanToInt(str));
    }

    // O(n) time complexity
    private static int romanToInt(String str) {
        roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && roman.get(str.charAt(i)) < roman.get(str.charAt(i + 1))) {
                res += roman.get(str.charAt(i + 1)) - roman.get(str.charAt(i));
                i++;
            } else
                res += roman.get(str.charAt(i));
        }
        return res;
    }
}
