package datastructure450.array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    // O(n) time complexity
    private static int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
