package com.dsa.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aAbbzZ"));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[58];
        for (char c: s.toCharArray())
            count[c-'A']++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;

    }
}
