package datastructure450.string;

// https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/

public class MinimumSwapsForBracketBalancing {
    public static void main(String[] args) {
        String str = "[]][][";
        System.out.println(minimumNumberOfSwaps(str, str.length()));
    }

    // O(n) time complexity
    private static int minimumNumberOfSwaps(String str, int n) {
        int swap = 0, imbalanced = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '[') {
                left++;
                if (imbalanced > 0) {
                    swap += imbalanced;
                    imbalanced--;
                }
            } else {
                right++;
                imbalanced = right - left;
            }
        }
        return swap;
    }
}
