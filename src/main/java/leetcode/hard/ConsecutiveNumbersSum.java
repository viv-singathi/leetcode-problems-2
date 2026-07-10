package leetcode.hard;

public class ConsecutiveNumbersSum {
    //problem: Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(9));
        //output: 3
        // 9 = 4 + 5 = 2 + 3 + 4
    }

    public static int consecutiveNumbersSum(int n) {
        n *= 2;

        int sqrtn = (int) (1 + Math.sqrt(n));
        int c = 0;

        for (int i = 1; i < sqrtn; i++){
            if (n % i == 0){
                if ((n / i - (i-1)) % 2 == 0){
                    c++;
                }
            }
        }

        return c;
    }
}
