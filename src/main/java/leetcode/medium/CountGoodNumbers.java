package leetcode.medium;

public class CountGoodNumbers {
    //problem:
    //A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
    //For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
    //Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
    //A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50)); //output: 564908303
    }

    public static int countGoodNumbers(long n) {

        if (n <= 0) {return 0;}

        long even_indexes = (n+1)/2;
        long odd_indexs = n - even_indexes;
        long res = 5;

        long pow5 = fast_exp(5, even_indexes-1);
        long pow4 = fast_exp(4, odd_indexs);

        res = res * pow5 % 1000000007;
        res = res * pow4 % 1000000007;

        return (int) res ;
    }

    public static long fast_exp(long x, long n){
        if (n == 0){return 1;}
        if (n % 2 == 1){
            return x * fast_exp(x, n-1) % 1000000007;
        }

        long r = fast_exp(x, n / 2);

        return r * r % 1000000007;
    }
}
