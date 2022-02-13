package datastructure450.backtracking;

// https://www.geeksforgeeks.org/tug-of-war/

public class TugOfWar {
    static int minDiff;

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, -3, 15, 11, 14, 13, 10, 8};//{23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        minDiff = Integer.MAX_VALUE;
        tugOfWar(arr, arr.length);
    }

    // O(2^n) time complexity
    private static void tugOfWar(int[] arr, int n) {
        boolean[] currElements = new boolean[n];
        boolean[] solution = new boolean[n];
        int sum = 0;
        for (int num : arr)
            sum += num;
        tugOfWarUtil(arr, n, sum, currElements, 0, solution, 0, 0);
        System.out.println("First SubSet is ");
        for (int i = 0; i < n; i++) {
            if (solution[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Second SubSet is ");
        for (int i = 0; i < n; i++) {
            if (!solution[i])
                System.out.print(arr[i] + " ");
        }
    }

    private static void tugOfWarUtil(int[] arr, int n, int sum, boolean[] currElements, int noOfSelectedElements,
                                     boolean[] solution, int currSum, int currPosition) {
        if (currPosition == n)
            return;
        if ((n / 2 - noOfSelectedElements) > (n - currPosition))
            return;
        tugOfWarUtil(arr, n, sum, currElements, noOfSelectedElements, solution, currSum, currPosition + 1);
        noOfSelectedElements++;
        currSum += arr[currPosition];
        currElements[currPosition] = true;
        if (noOfSelectedElements == n / 2) {
            if (Math.abs(sum / 2 - currSum) < minDiff) {
                minDiff = Math.abs(sum / 2 - currSum);
                for (int i = 0; i < n; i++)
                    solution[i] = currElements[i];
            }
        } else
            tugOfWarUtil(arr, n, sum, currElements, noOfSelectedElements, solution, currSum, currPosition + 1);
        currElements[currPosition] = false;
    }
}
