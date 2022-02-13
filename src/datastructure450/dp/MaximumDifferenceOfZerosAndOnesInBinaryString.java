package datastructure450.dp;

// https://www.geeksforgeeks.org/maximum-difference-zeros-ones-binary-string/

public class MaximumDifferenceOfZerosAndOnesInBinaryString {
    public static void main(String[] args) {
        String str = "011111010011";//"11000010001";
        System.out.println(maxSubstring(str, str.length()));
        System.out.println(maxSubstringBetterSolution(str, str.length()));
    }

    // idea is to use kadane's algorithm
    // O(n) time complexity and O(1) space complexity
    private static int maxSubstringBetterSolution(String str, int n) {
        int currSum = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            currSum += str.charAt(i) == '0' ? 1 : -1;
            if (currSum < 0)
                currSum = 0;
            sum = Math.max(currSum, sum);
        }
        return sum == 0 ? -1 : sum;
    }

    private static int maxSubstring(String str, int n) {
        int res = -1;
        for (int i = 0; i < n; i++) {
            int noOfZero = 0, noOfOne = 0;
            int count;
            for (int j = i; j < n; j++) {
                if (str.charAt(j) == '0')
                    noOfZero++;
                else
                    noOfOne++;
                count = noOfZero - noOfOne;
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
