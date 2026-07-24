package leetcode.medium;

public class NumberOfSmoothDescentPeriodsOfStock {
    //problem: You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
    //A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1.
    // The first day of the period is exempted from this rule.
    //Return the number of smooth descent periods

    public static void main(String[] args) {
        int arr[] = {3,2,1,4};
        System.out.println(getDescentPeriods(arr)); //output: 7
    }

    public static long getDescentPeriods(int[] prices) {
        long res = 0;

        int l = 0;
        int u = 0;

        while (u < prices.length){
            u++;
            if (u >= prices.length || prices[u] - prices[u-1] != -1){
                long n = u - l;

                if (u <  prices.length){
                    l = u;
                }

                res += n * (n+1) / 2;

            }
        }

        return res;
    }
}
