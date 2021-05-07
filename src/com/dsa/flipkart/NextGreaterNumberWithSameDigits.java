package com.dsa.flipkart;

import java.util.Arrays;

public class NextGreaterNumberWithSameDigits {
    public static void main(String[] args) {
        String str = "218765";
        findNextGreaterNumber(str);
    }

    private static void findNextGreaterNumber(String str) {
        int n = str.length();
        int i;
        for (i = n - 1; i > 0; i--) {
            if (str.charAt(i) > str.charAt(i - 1))
                break;
        }
        if (i == 0) {
            System.out.println("Not possible");
            return;
        }
        int minNumber = str.charAt(i - 1), min = i;
        for (int j = i + 1; j < n; j++) {
            if (str.charAt(j) > minNumber && str.charAt(j) < str.charAt(min))
                min = j;
        }
        char[] strChar = swap(str, i - 1, min);
        Arrays.sort(strChar,i,n);
        System.out.println("Next greater no is :");
        for(char ch:strChar)
            System.out.print(ch);
    }

    private static char[] swap(String str, int i, int min) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[min];
        chars[min] = temp;
        return chars;
    }
}
