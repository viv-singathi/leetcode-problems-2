package leetcode.medium;

public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(5));

        //output:
        // 91
        // 32491

    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0){ return 1; }

        int res = 10;
        int prod = 9;

        for (int i = 0; i < n-1; i++){
            prod = prod * (9 - i);
            res += prod;
        }

        return res;
    }
}
