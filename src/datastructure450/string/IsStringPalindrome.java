package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
public class IsStringPalindrome {
    public static void main(String[] args) {
        String str = "abba";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
