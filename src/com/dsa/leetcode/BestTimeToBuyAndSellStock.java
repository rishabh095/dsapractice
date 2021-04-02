package com.dsa.leetcode;

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitEfficientSolution(prices));
    }

    private static int maxProfitEfficientSolution(int[] prices) {
        int maxProfit=0,minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit=prices[j]-prices[i];
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }
}
