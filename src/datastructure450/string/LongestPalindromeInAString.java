package datastructure450.string;

// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

import java.util.Arrays;

public class LongestPalindromeInAString {
    public static void main(String[] args) {
        String str = "kjqlrzzfmlvyoshiktodnsjjp";//"forgeeksskeegfor";
        System.out.println(longestPalindromeSubString(str));
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int longestPalindromeSubString(String str) {
        int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;
        for (int i = 1; i < len; i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength);

        return maxLength;
    }

    private static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high));
    }
}
