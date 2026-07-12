package leetcode.easy;

public class MirrorDistanceOfInteger {
    //problem: You are given an integer n.
    //
    //Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the integer formed by reversing the digits of n.
    //Return an integer denoting the mirror distance of n.
    //abs(x) denotes the absolute value of x
    public static void main(String[] args) {
        System.out.println(mirrorDistance(25)); //output: 27
    }

    public static int mirrorDistance(int n) {
        int n2 = n;
        int r = 0;

        while (n2 > 0){
            r = r * 10 + (n2 % 10);
            n2 /= 10;
        }

        return Math.abs(r-n);
    }
}
