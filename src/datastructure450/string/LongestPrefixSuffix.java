package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1#

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String str = "aaaab";
        System.out.println(lps(str));
    }

    private static int lps(String str) {
        int n = str.length();
        int[] lps = new int[n];
        fillLPS(str, lps);
        return lps[n - 1];
    }

    private static void fillLPS(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
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
    }
}
