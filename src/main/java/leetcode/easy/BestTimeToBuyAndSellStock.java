package leetcode.easy;

public class BestTimeToBuyAndSellStock {
    //problem: You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    // future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); //output: 5
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1){return 0;}

        int max = prices[1] - prices[0];
        int min = prices[0];

        for (int i = 1; i < prices.length; i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max > 0 ? max : 0;
    }

}
