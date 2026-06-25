package leetcode.easy;

public class ArrangingCoins {
    //problem: You have n coins and you want to build a staircase with these coins.
    // The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
    //Given the integer n, return the number of complete rows of the staircase you will build.

    public static void main(String[] args) {
        System.out.println(8); //ouput: 3
    }

    public static int arrangeCoins(int n) {
        long l = 1;
        long u = n;

        while (l <= u){
            long m = (l+u)/2;

            long coins = m * (m+1)/2;
            long prevCoins = (m-1) * m /2;

            if (coins >= n && prevCoins <= n){
                return (int) (coins == n ? m : m-1);
            }

            if (coins < n){
                l = m+1;
            } else {
                u = m-1;
            }
        }

        return -1;
    }}
