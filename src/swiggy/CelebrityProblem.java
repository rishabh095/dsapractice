package swiggy;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(celebrity(arr, arr.length));
        System.out.println(celebrityTwoPointer(arr, arr.length));
    }

    // O(n) time complexity and O(1) space complexity
    private static int celebrityTwoPointer(int[][] arr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            if (isKnow(arr, low, high))
                low++;
            else
                high--;
        }
        int celebrity = low;
        for (int i = 0; i < n; i++) {
            if (i != celebrity && (isKnow(arr, celebrity, i) || !isKnow(arr, i, celebrity)))
                return -1;
        }
        return celebrity;
    }

    // O(n) time complexity and O(n) space complexity
    private static int celebrity(int[][] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            stack.push(i);
        while (stack.size() > 1) {
            int first = stack.pop();
            int second = stack.pop();
            if (isKnow(arr, first, second))
                stack.push(second);
            else
                stack.push(first);
        }
        if (stack.isEmpty())
            return -1;
        int last = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != last && (isKnow(arr, last, i) || !isKnow(arr, i, last)))
                return -1;
        }
        return last;
    }

    private static boolean isKnow(int[][] arr, int first, int second) {
        return arr[first][second] == 1;
    }
}
