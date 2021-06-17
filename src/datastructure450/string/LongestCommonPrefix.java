package datastructure450.string;

// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flowere", "flower"};//{"flower", "flow", "flight"};
        System.out.println(horizontalScanning(strs));
        System.out.println(verticalScanning(strs));
        System.out.println(BinarySearch(strs));
    }

    private static String BinarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    // Time complexity : O(S * log m) log m iteration
    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    // but in best case O(minLen) is the length of the shortest string in the array.
    private static String verticalScanning(String[] strs) {
        if (strs.length == 0)
            return "No Solution";
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    private static String horizontalScanning(String[] strs) {
        if (strs.length == 0)
            return "No Solution";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "No Solution";
            }
        }
        return prefix;
    }
}
