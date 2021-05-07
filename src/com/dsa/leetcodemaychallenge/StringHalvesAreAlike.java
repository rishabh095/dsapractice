package com.dsa.leetcodemaychallenge;

// https://leetcode.com/problems/determine-if-string-halves-are-alike/

public class StringHalvesAreAlike {
    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    private static boolean halvesAreAlike(String s) {
        int len = s.length();
        int counter = 0;
        String vow = "aeiouAEIOU";
        for (int i = 0; i < len / 2; i++) {
            if (vow.indexOf(s.charAt(i)) != -1)
                counter++;
        }
        for (int i = len / 2; i < len; i++) {
            if (vow.indexOf(s.charAt(i)) != -1)
                counter--;
        }
        return counter == 0;
    }
}
