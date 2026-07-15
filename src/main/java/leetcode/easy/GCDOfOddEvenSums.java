package leetcode.easy;

public class GCDOfOddEvenSums {

    public static void main(String[] args) {
        System.out.println(gcdOfOddEvenSums(5)); //output: 5
    }

    public static int gcdOfOddEvenSums(int n) {
        return gcd(n*n + n, n*n);
    }

    public static int gcd(int x, int y){
        if (y == 1){return 1;}
        if (x % y == 0){return y;}
        return gcd(y, x%y);
    }
}
