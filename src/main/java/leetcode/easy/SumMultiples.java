package leetcode.easy;

public class SumMultiples {
    //problem: Given a positive integer n, find the sum of all integers in the range [1, n] inclusive that are divisible by 3, 5, or 7.
    //Return an integer denoting the sum of all numbers in the given range satisfying the constraint
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7)); //output: 21
    }

    public static int sumOfMultiples(int n) {
        // sum 3 + sum 5 + sum 7 - sum of 3 * 5  - sum of 3 * 7 - sum 5 * 7 + sum 3 * 5 * 7
        int s3 = 3 * (n/3) * (n/3 + 1) / 2;
        int s5 = 5 * (n/5) * (n/5 + 1) / 2;
        int s7 = 7 * (n/7) * (n/7 + 1) / 2;

        int s15 = 15 * (n / 15) * (n / 15 + 1) / 2;
        int s21 = 21 * (n / 21) * (n / 21 + 1) / 2;
        int s35 = 35 * (n / 35) * (n / 35 + 1) / 2;

        int s105 = 105 * (n / 105) * (n / 105 + 1) / 2;

        return s3 + s5 + s7 - s15 - s21 - s35 + s105;
    }
}
