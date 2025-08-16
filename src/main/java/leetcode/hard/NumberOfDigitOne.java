package leetcode.hard;

public class NumberOfDigitOne {

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(1000));

        //output:
        // 6
        // 301

    }

    public static int countDigitOne(int n) {
        if (n <= 0){ return 0; }
        if (n <= 9){ return 1; }

        int ones = 0;
        int num_digits = (int) Math.log10(n) + 1;
        int pow10 = (int) Math.pow(10, num_digits-1);
        int first_digit = n / pow10;

        if (first_digit > 1){
            ones += pow10;
            ones += countDigitOne(n - first_digit * pow10);
        } else {
            ones += n - pow10 + 1;
            ones += countDigitOne(n - pow10);
        }

        ones += first_digit * (pow10 / 10 * (num_digits-1));

        return ones;
    }
}
