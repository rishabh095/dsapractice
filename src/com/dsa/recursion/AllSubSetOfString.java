package com.dsa.recursion;

public class AllSubSetOfString {
    public static void main(String[] args) {
        String s = "abc";
        printSubset(s, "", 0);
    }

    private static void printSubset(String s, String curr, int index) {
        if (s.length() == index) {
            System.out.print(curr + " ");
            return;
        }
        printSubset(s, curr, index + 1);
        printSubset(s, curr + s.charAt(index), index + 1);
    }
}
