package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/palindromic-array-1587115620/1

public class PalindromicArray {
    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444, 555};
        System.out.println(palindromeArray(arr, arr.length));
    }

    // O(n*n) time complexity and O(1) space complexity
    private static boolean palindromeArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean ans = isPalindrome(arr[i]);
            if (!ans)
                return false;
        }
        return true;
    }

    static boolean isPalindrome(int val) {
        String str = "" + val;
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
}

