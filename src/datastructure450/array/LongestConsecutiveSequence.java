package datastructure450.array;

// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr, arr.length));
    }

    // O(n) time complexity O(n) space complexity
    private static int longestConsecutive(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);
        int longestStreak = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currStreak = 1;
                int currNum = num;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}
