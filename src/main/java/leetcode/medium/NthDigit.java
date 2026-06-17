package leetcode.medium;

public class NthDigit {
    //problem: Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]
    public static void main(String[] args) {
        System.out.println(findNthDigit(13)); //output 1
    }

    public static int findNthDigit(int n) {
        if (n < 10){return n;}
        long r = 9;
        long digits = 1;

        while (n - digits*r > 0){
            n -= digits*r;
            r *= 10;
            digits++;
        }

        r = 9;
        for (int i = 1; i < digits-1; i++){
            r = r * 10 + 9;
        }

        r += (n / digits);

        if (n%digits == 0){
            return (int) r % 10;
        }

        r++;

        for (int i = 0; i < (digits - (n % digits)); i++){
            r /= 10;
        }

        return (int) r % 10;
    }
}
