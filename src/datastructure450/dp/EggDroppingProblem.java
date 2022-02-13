package datastructure450.dp;

// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/

public class EggDroppingProblem {
    public static void main(String[] args) {
        int noOfEggs = 2;
        int noOfFloors = 10;
        System.out.println(noOfTrails(noOfEggs, noOfFloors));
        System.out.println(noOfTrailsDP(noOfEggs, noOfFloors));
    }

    // O(n*k^2) time complexity and O(n*k) space complexity
    private static int noOfTrailsDP(int noOfEggs, int noOfFloors) {
        int[][] dp = new int[noOfEggs + 1][noOfFloors + 1];
        for (int i = 1; i <= noOfEggs; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int i = 1; i <= noOfFloors; i++)
            dp[1][i] = i;
        for (int i = 2; i <= noOfEggs; i++) {
            for (int j = 2; j <= noOfFloors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    if (res < dp[i][j])
                        dp[i][j] = res;
                }
            }
        }
        return dp[noOfEggs][noOfFloors];
    }

    // time complexity is exponential O(k*2^k) where k is no of floors
    private static int noOfTrails(int noOfEggs, int noOfFloors) {
        if (noOfFloors == 0 || noOfFloors == 1)
            return noOfFloors;
        if (noOfEggs == 1)
            return noOfFloors;
        int res, min = Integer.MAX_VALUE;
        for (int i = 1; i <= noOfFloors; i++) {
            res = Math.max(noOfTrails(noOfEggs - 1, i - 1),
                    noOfTrails(noOfEggs, noOfFloors - i));
            if (res < min)
                min = res;
        }
        return min + 1;
    }
}
