package leetcode.medium;

public class MonotoneIncreaseingDigits {
    //Problem:
    //An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
    //Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332)); //output: 299
    }

    public static int monotoneIncreasingDigits(int n) {
        int digits = (int) (Math.log10(n) + 1);
        int div = (int) (Math.pow(10, digits-1));
        int res = 0;

        int n2 = n;
        int prevDigit = n2 % 10;
        int replacedDigit = 0;
        int lastChange = 0;

        for (int i = 1; i < digits; i++){
            n2 /= 10;
            int d = n2 % 10;

            if (d <= prevDigit){
                prevDigit = d;
            } else {
                prevDigit = d-1;
                replacedDigit = d-1;
                lastChange = i;
            }
        }

        if (lastChange == 0){lastChange = -1;}

        for (int i = 0; i < digits - lastChange - 1; i++){
            int d = (n / div) % 10;
            res = res * 10 + d;
            div /= 10;
        }

        if (lastChange != -1){
            res = res * 10 + replacedDigit;
        }

        for (int i = 0; i < lastChange; i++){
            res = res * 10 + 9;
        }

        return res;
    }
}
