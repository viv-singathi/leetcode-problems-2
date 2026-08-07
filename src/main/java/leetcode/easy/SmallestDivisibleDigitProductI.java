package leetcode.easy;

public class SmallestDivisibleDigitProductI {
    //problem: You are given two integers n and t. Return the smallest number greater than or equal to n
    // such that the product of its digits is divisible by t
    public static void main(String[] args) {
        System.out.println(smallestNumber(15, 3)); //output: 16
    }

    public static int smallestNumber(int n, int t) {
        for (int i = n; i <= n + 9; i++){
            int p = (i %10);
            int tmp = i / 10;

            while (tmp > 0){
                p *= (tmp % 10);
                tmp /= 10;
            }

            if (p % t == 0){return i;}
        }

        return -1;
    }
}
