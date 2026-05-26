package leetcode.easy;

public class PrimeInDiagonal {
    //problem:
    // You are given a 0-indexed two-dimensional integer array nums.
    //Return the largest prime number that lies on at least one of the diagonals of nums.
    // In case, no prime is present on any of the diagonals, return 0.
    public static void main(String[] args) {
        int m[][] = {
                {1,2,3},
                {5,6,7},
                {9,10,11}
        };

        System.out.println(diagonalPrime(m)); //output: 11

    }

    public static int diagonalPrime(int[][] nums) {
        int p = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (isPrime(nums[i][i]) && nums[i][i] > p){
                p = nums[i][i];
            }
        }

        for (int i = 0; i < n; i++){
            if (isPrime(nums[i][n - i - 1]) && nums[i][n - i - 1] > p){
                p = nums[i][n - i - 1];
            }
        }

        return p;
    }

    public static boolean isPrime(int n){
        if (n < 2) {return false;}
        int sqrtn = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtn; i++){
            if (n % i == 0) {return false;}
        }
        return true;
    }
}
