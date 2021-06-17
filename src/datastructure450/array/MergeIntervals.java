package datastructure450.array;

// https://leetcode.com/problems/merge-intervals/

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = mergeIntervals(intervals);
        for (int[] in : ints)
            System.out.println(Arrays.toString(in));
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        //Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][0] = Math.min(intervals[index][0], intervals[i][0]);
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }
        int[][] result = new int[index+1][2];
        for (int i = 0; i <= index; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }
}
