package datastructure450.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInCircular {
    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(nextGreater(arr, arr.length)));
    }

    private static int[] nextGreater(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentIndex = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[currentIndex])
                stack.pop();
            result[currentIndex] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[currentIndex]);
        }
        return result;
    }
}
