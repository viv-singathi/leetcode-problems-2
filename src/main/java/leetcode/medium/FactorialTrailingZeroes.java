package leetcode.medium;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(24));
        //output:
        // 1
        // 4

    }

    public static int trailingZeroes(int n) {

        int factors_of_5 = 0;
        int base = 5;

        while (n/base > 0){
            factors_of_5 += n/base;
            base *= 5;
        }

        return factors_of_5;
    }
}
