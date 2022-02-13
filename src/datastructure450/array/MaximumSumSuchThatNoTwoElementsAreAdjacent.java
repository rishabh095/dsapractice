package datastructure450.array;

// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(maxWithNoAdjacent(arr, arr.length));
    }

    private static int maxWithNoAdjacent(int[] arr, int n) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int include = arr[0];
        int exclude = 0, newExclude;
        for (int i = 1; i < n; i++) {
            newExclude = Math.max(exclude, include);
            include = exclude + arr[i];
            exclude = newExclude;
        }
        return Math.max(exclude, include);
    }
}
