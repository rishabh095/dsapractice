package datastructure450.string;

// https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/

import java.util.Arrays;

public class PrintConcatenationOfZigZagStringInNRows {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int n = 3;
        printZigZagConcat(str, n);
    }

    // O(len of str) time complexity and O(row) space complexity
    private static void printZigZagConcat(String str, int n) {
        if (n == 1) {
            System.out.println(str);
            return;
        }
        int len = str.length();
        String[] resultArray = new String[n];
        Arrays.fill(resultArray, "");
        boolean down = true;
        int row = 0;
        for (int i = 0; i < len; i++) {
            resultArray[row] += str.charAt(i);
            if (row == n - 1)
                down = false;
            else if (row == 0)
                down = true;
            if (down)
                row++;
            else
                row--;
        }
        for (int i = 0; i < n; i++)
            System.out.print(resultArray[i]);
    }
}
