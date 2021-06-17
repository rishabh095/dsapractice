package datastructure450.string;

// https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
// https://leetcode.com/problems/shortest-palindrome/submissions/

public class MinimumCharactersToBeAddedAtFrontToMakeStringPalindrome {
    public static void main(String[] args) {
        String str = "abcd";//"ABC";//"BABABAA";
        System.out.println(convertIntoPalindrome(str, str.length()));
        System.out.println(convertIntoPalindromeBetterSolutionWithLPS(str, str.length()));
    }

    // O(n) time complexity and O(n) space complexity
    private static String convertIntoPalindromeBetterSolutionWithLPS(String str, int n) {
        if (n <= 1)
            return str;
        StringBuilder sb = new StringBuilder(str).append("#");
        sb.reverse();
        String rebuildString = str + sb;
        int[] lps = new int[rebuildString.length()];
        int len = 0;
        int i = 1;
        while (i < rebuildString.length()) {
            if (rebuildString.charAt(i) == rebuildString.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else
                    len = lps[len - 1];
            }
        }
        int end = lps[rebuildString.length() - 1];
        return sb.substring(1, n - end + 1) + str;
    }

    // O(n*n) time complexity and O(1) space complexity
    private static String convertIntoPalindrome(String str, int n) {
        int count = 0;
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (isPalindrome(str, i)) {
                flag = true;
                break;
            } else
                count++;
        }
        if (flag)
            System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(str.charAt(n - 1 - i));

        return sb.append(str).toString();
    }

    private static boolean isPalindrome(String str, int n) {
        int low = 0;
        while (low < n) {
            if (str.charAt(low) != str.charAt(n))
                return false;
            low++;
            n--;
        }
        return true;
    }
}
