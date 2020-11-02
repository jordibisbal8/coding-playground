package com.company.exercises;

// Problem: Design an algorithm to find the maximum profit. You may complete as many transactions as you like
// (i.e., buy one and sell one share of the stock multiple times).
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.print(maxProfit(prices));
    }
}
