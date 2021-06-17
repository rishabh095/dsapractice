package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        List<List<Integer>> lists = stockBuySell(arr, arr.length);
        for (List<Integer> list : lists)
            System.out.println(list);
    }

    private static List<List<Integer>> stockBuySell(int[] arr, int length) {
        List<List<Integer>> result = new ArrayList<>();
        List<StockInterval> solution = new ArrayList<>();
        int i = 0;
        int count = 0;
        while (i < length - 1) {
            while (i < length - 1 && arr[i + 1] <= arr[i])
                i++;
            if (i == length - 1)
                break;
            StockInterval sol = new StockInterval();
            sol.buy = i++;
            while (i < length - 1 && i < length && arr[i] >= arr[i-1])
                i++;
            sol.sell = i - 1;
            solution.add(sol);
            System.out.println(sol.buy + " " + sol.sell);
            count++;
        }
        if (count != 0) {
            for (int j = 0; j < solution.size(); j++) {
                result.add(new ArrayList<>());
                result.get(j).add(0, solution.get(j).buy);
                result.get(j).add(1, solution.get(j).sell);
            }
        }
        return result;
    }
}
