package leetcode.hard;

public class SumOfKDigitNumbersInRange {
    //problem: You are given three integers l, r, and k.
    //
    //Consider all possible integers consisting of exactly k digits, where each digit is chosen independently from the
    // integer range [l, r] (inclusive). If 0 is included in the range, leading zeros are allowed.
    //Return an integer representing the sum of all such numbers.Since the answer may be very large, return it modulo 10^9 + 7

    public static void main(String[] args) {
        System.out.println(sumOfNumbers(1, 2, 2)); //output: 66
    }

    public static int sumOfNumbers(int l, int r, int k) {
        long s = (l+r) * (r - l + 1) / 2;
        long p = fpow(r - l + 1, k-1);
        long res = fpow(10, k);
        res = res -  1 > 0 ? res - 1 : 1000000006;
        res = (res * 111111112) % 1000000007; // 9^-1 = 111111112 mod 1000000007

        res = res * p % 1000000007;
        res = res * s % 1000000007;

        return (int) res;
    }

    public static long fpow(long x, long n){
        if (n == 0) { return 1;}
        long r = fpow(x, n/2);
        return n % 2 == 0 ? r * r % 1000000007 : (x * (r * r % 1000000007)) % 1000000007;
    }
}
