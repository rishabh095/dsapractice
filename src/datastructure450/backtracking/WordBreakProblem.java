package datastructure450.backtracking;

// https://practice.geeksforgeeks.org/problems/word-break-part-23249/1#

import java.util.*;

public class WordBreakProblem {
    static List<String> result;

    public static void main(String[] args) {
        result = new ArrayList<>();
        String str = "iloveicecreamandmango";
        List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "love", "ice", "cream");
        Set<String> wordDict = new HashSet<>(dict);
        breakIntoWords(str, str.length(), wordDict, "");
        System.out.println(result);
        System.out.println(isWordBreak(str, str.length(), wordDict));
        System.out.println(isWordBreakDP(str, str.length(), wordDict));
    }

    private static void breakIntoWords(String str, int n, Set<String> wordDict, String ans) {
        for (int i = 1; i <= n; i++) {
            String prefix = str.substring(0, i);
            if (wordDict.contains(prefix)) {
                if (i == n) {
                    ans += prefix;
                    result.add(ans);
                    return;
                }
                breakIntoWords(str.substring(i, n), n - i, wordDict, ans + prefix + " ");
            }
        }
    }

    private static boolean isWordBreak(String str, int n, Set<String> wordDict) {
        if (n == 0)
            return true;
        for (int i = 1; i <= n; i++) {
            if (wordDict.contains(str.substring(0, i)) && isWordBreak(str.substring(i, n), n - i, wordDict))
                return true;
        }
        return false;
    }

    private static boolean isWordBreakDP(String str, int n, Set<String> wordDict) {
        List<Boolean> dp = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++)
            dp.add(i, false);
        dp.add(0, true);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp.get(j) && wordDict.contains(str.substring(j, i))) {
                    dp.add(i, true);
                    break;
                }
            }
        }
        return dp.get(n);
    }
}
