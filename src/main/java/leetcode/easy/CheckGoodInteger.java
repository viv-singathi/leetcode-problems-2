package leetcode.easy;

public class CheckGoodInteger {
    //problem: You are given a positive integer n.
    //Let digitSum be the sum of the digits of n, and let squareSum be the sum of the squares of the digits of n.
    //An integer is called good if squareSum - digitSum >= 50
    public static void main(String[] args) {
        System.out.println(checkGoodInteger(1000));//output: false
    }

    public static boolean checkGoodInteger(int n) {
        int s = 0;

        while (n > 0){
            s += (n % 10) * ((n % 10) - 1);
            n /= 10;
        }

        return s >= 50;
    }
}
