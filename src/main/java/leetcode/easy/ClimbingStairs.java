package leetcode.easy;

public class ClimbingStairs {

//    problem:
//    You are climbing a staircase. It takes n steps to reach the top.
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


    public static void main(String[] args) {
        System.out.println(climbStairs(3)); //output: 3
    }

    public static int climbStairs(int n) {
        int ways = 0;
        int prevWays = 1;
        int pPrevWays = 0;

        for (int i = 0; i < n ; i++){
            ways = prevWays + pPrevWays;
            pPrevWays = prevWays;
            prevWays = ways;
        }

        return ways;
    }
}
