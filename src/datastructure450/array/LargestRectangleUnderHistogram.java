package datastructure450.array;

import java.util.Stack;

public class LargestRectangleUnderHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(arr, arr.length));
    }

    // O(n) time complexity and O(n) time complexity
    private static int getMaxArea(int[] hist, int n) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int tp;
        int area_with_top;

        int i = 0;
        while (i < n) {
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);
            else {
                tp = s.pop();
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
        while (!s.empty()) {
            tp = s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }
}
