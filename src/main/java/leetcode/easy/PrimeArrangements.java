package leetcode.easy;

public class PrimeArrangements {
    //problem: Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
    //(Recall that an integer is prime if and only if it is greater than 1,
    // and cannot be written as a product of two positive integers both smaller than it.)
    //Since the answer may be large, return the answer modulo 10^9 + 7

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(5)); //output: 12
    }

    public static int numPrimeArrangements(int n) {
        int prime = 0;
        long res = 1;

        for (int i = 2; i <= n; i++){
            if (isPrime(i)){
                prime++;
            }
        }

        n -= prime;

        for (int i = 0; i < n; i++){
            res = res * (n-i) % 1000000007;
        }

        for (int i = 0; i < prime; i++){
            res = res * (prime-i) % 1000000007;
        }

        return (int) res;
    }

    public static boolean isPrime(int n){
        if (n == 1){return false;}
        int sqrtn = 1 + (int) Math.sqrt(n);
        for (int i = 2; i < sqrtn; i++){
            if (n % i == 0){return false;}
        }

        return true;
    }
}
