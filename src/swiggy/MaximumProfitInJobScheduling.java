package swiggy;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.*;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(jobScheduling(startTime, endTime, profit));
        System.out.println(jobSchedulingOtherSolution(startTime, endTime, profit));
    }

    // O(n log n) time complexity
    private static int jobSchedulingOtherSolution(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++)
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        jobs.sort(Comparator.comparingInt(o -> o.start));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfit(jobs, dp, 0);
    }

    private static int maxProfit(List<Job> jobs, int[] dp, int index) {
        int n = jobs.size();
        if (index == n || index == -1)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int maxProfit;
        int workProfit = jobs.get(index).profit + maxProfit(jobs, dp, nextIndex(jobs, index + 1, jobs.get(index).end));
        int skipProfit = maxProfit(jobs, dp, index + 1);
        maxProfit = Math.max(workProfit, skipProfit);
        dp[index] = maxProfit;
        return maxProfit;
    }

    private static int nextIndex(List<Job> jobs, int start, int target) {
        int high = jobs.size() - 1;
        int result = -1;
        while (start <= high) {
            int mid = start + (high - start) / 2;
            if (jobs.get(mid).start < target)
                start = mid + 1;
            else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    // O(n log n) time complexity
    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length, res = 0;
        int[][] mat = new int[n][3];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            mat[i][0] = startTime[i];
            mat[i][1] = endTime[i];
            mat[i][2] = profit[i];
        }
        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int sum = mat[i][2];
            for (int j = 0; j < i; j++)
                if (mat[j][1] <= mat[i][0])
                    sum = Math.max(sum, dp[j] + mat[i][2]);
            dp[i] = sum;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
