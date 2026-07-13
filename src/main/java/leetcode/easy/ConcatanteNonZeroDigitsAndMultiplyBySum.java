package leetcode.easy;

public class ConcatanteNonZeroDigitsAndMultiplyBySum {
    //problem: You are given an integer n.
    //Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.
    //Let sum be the sum of digits in x.
    //Return an integer representing the value of x * sum
    public static void main(String[] args) {
        System.out.println(sumAndMultiply(10203004)); //output: 12340
    }

    public static long sumAndMultiply(int n) {
        long s = 0;
        long r = 0;
        int dig = (int) (1 + Math.log10(n));
        int pow10 = (int) Math.pow(10, dig-1);
        int n2 = n;

        for (int i = 0; i < dig; i++){
            s += n % 10;
            if (((n2 / pow10) % 10) != 0){
                r = r * 10 + ((n2 / pow10) % 10) ;
            }

            pow10 /= 10;
            n /= 10;
        }

        return s * r;
    }
}
