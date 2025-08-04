package leetcode.hard;

public class NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        String digits1[] = {"1","3","5","7"};
        String digits2[] = {"1","4","9"};

        System.out.println(atMostNGivenDigitSet(digits1, 100));
        System.out.println(atMostNGivenDigitSet(digits2, 1000000000));

        //output:
        //20
        //29523
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        int nums[] = new int[digits.length];
        int total = 0;

        for (int i = 0; i < digits.length; i++){
            nums[i] = strToNum(digits[i]);
        }

        int max_digits = (int) (Math.log10(n)) + 1;
        int numbers_length_i = nums.length;

        for (int i = 1; i < max_digits; i++){
            total += numbers_length_i;
            numbers_length_i *= nums.length;
        }

        total += countEqualLength(n, max_digits, (int) Math.pow(10, max_digits-1), nums);

        return total;
    }

    public static int countEqualLength(int n, int digits, int d, int nums[]){
        if (d == 0){
            return 1;
        }

        int total = 0;
        int digit = (n/d) % 10;
        int nums_less = 0;
        boolean equal_exists = false;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < digit){
                nums_less++;
            } else if (nums[i] == digit){
                equal_exists = true;
            } else {
                break;
            }
        }

        total = nums_less;

        for (int i = 1; i < digits; i++){
            total *= nums.length;
        }

        if (equal_exists){
            total += countEqualLength(n - d * digit, digits-1, d/10, nums);
        }

        return total;
    }

    public static int strToNum(String s){
        int n = 0;

        for (int i = 0 ; i < s.length(); i++){
            n = n * 10 + s.charAt(i) - '0';
        }

        return n;
    }
}
