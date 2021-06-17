package datastructure450.string;

// https://leetcode.com/problems/reverse-string/

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(str));
        System.out.println("----------------------");
        reverseString(str);
        System.out.println(Arrays.toString(str));
    }

    private static void reverseString(char[] str) {
        int low = 0, high = str.length - 1;
        while (low < high) {
            char temp = str[low];
            str[low++] = str[high];
            str[high--] = temp;
        }
    }
}
