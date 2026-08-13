package leetcode.easy;

public class HarshadNumber {
    //problem: An integer divisible by the sum of its digits is said to be a Harshad number. You are given an integer x.
    // Return the sum of the digits of x if x is a Harshad number, otherwise, return -1
    public static void main(String[] args) {
        System.out.println(sumOfTheDigitsOfHarshadNumber(18)); //output: 9
    }

    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0;
        int t = x;

        while (t > 0){
            s += t % 10;
            t /= 10;
        }

        return (x % s == 0 ? s : -1);
    }
}
