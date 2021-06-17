package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/word-break1352/1

import pos.Second;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String str = "iloveicecreamandmango";
        List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "love", "ice", "cream");
        Set<String> wordDict = new HashSet<>(dict);
        System.out.println(wordBreak(str, str.length(), wordDict));
        System.out.println(wordBreakDP(str, str.length(), wordDict));
        wordBreakPrint(str, str.length(), wordDict, "");
    }

    // O(n*n) time complexity and O(n) space complexity
    private static boolean wordBreakDP(String str, int n, Set<String> wordDict) {
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

    // O(n^n) time complexity and O(n^2) space complexity for recursion stack
    private static boolean wordBreak(String str, int n, Set<String> wordDict) {
        if (n == 0)
            return true;
        for (int i = 1; i <= n; i++) {
            if (wordDict.contains(str.substring(0, i)) && wordBreak(str.substring(i, n), n - i, wordDict))
                return true;
        }
        return false;
    }

    // O(n^n) time complexity and O(n^2) space complexity for recursion stack
    private static void wordBreakPrint(String str, int n, Set<String> wordDict, String ans) {
        for (int i = 1; i <= n; i++) {
            String prefix = str.substring(0, i);
            if (wordDict.contains(prefix)) {
                if (i == n) {
                    ans += prefix;
                    System.out.println(ans);
                    return;
                }
                wordBreakPrint(str.substring(i, n), n - i, wordDict, ans + prefix + " ");
            }
        }
    }
}
