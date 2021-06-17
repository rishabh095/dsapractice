package datastructure450.array;

// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

public class MinimumSwapsAndKTogether {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;
        System.out.println(minSwap(arr, arr.length, k));
    }

    private static int minSwap(int[] arr, int n, int k) {
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current
        // window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k)
                --bad;

            // Increment count of current window
            if (arr[j] > k)
                ++bad;

            // Update ans if count of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }
}
