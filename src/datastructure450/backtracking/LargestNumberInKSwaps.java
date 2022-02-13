package datastructure450.backtracking;

// https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
// https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
class Max {
    String max;
}

public class LargestNumberInKSwaps {
    public static void main(String[] args) {
        String str = "129814999";//"1234567";
        int k = 4;
        System.out.println(findMaximumNumber(str, k));
        System.out.println(1<<3);
    }

    // O((n)^k) time complexity and O(n) space complexity to store output string
    private static String findMaximumNumber(String str, int k) {
        Max max = new Max();
        max.max = str;
        findMaximumNumberUtil(str.toCharArray(), k, max);
        return max.max;
    }

    private static void findMaximumNumberUtil(char[] arr, int k, Max max) {
        if (k == 0)
            return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                    if (String.valueOf(arr).compareTo(max.max) > 0)
                        max.max = String.valueOf(arr);
                    findMaximumNumberUtil(arr, k - 1, max);
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
