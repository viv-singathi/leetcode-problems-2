package leetcode.medium;

public class PaintFence {
    //problem: You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
    //Every post must be painted exactly one color.
    //There cannot be three or more consecutive posts with the same color.
    //Given the two integers n and k, return the number of ways you can paint the fence.
    public static void main(String[] args) {
        System.out.println(numWays(7, 2));//output: 42
    }

    public static int numWays(int n, int k) {
        if (n == 1){return k;}
        if (n == 2) {return k * k;}

        int ways[] = new int[n];
        ways[0] = k;
        ways[1] = k * ways[0];
        ways[2] = (k-1) * ways[0] + ways[0] * (k-1) * k;

        for (int f = 3; f < n; f++){
            ways[f] = (k-1) * (k-1) * ways[f-3] + ways[f-2] * (k-1) * k;
        }

        return ways[n-1];
    }
}
