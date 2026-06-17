package leetcode.easy;

public class CountDigitsThatDivideN {
    //problem: Given an integer num, return the number of digits in num that divide num.
    public static void main(String[] args) {
        System.out.println(countDigits(121)); //output: 2
    }

    public static int countDigits(int num) {
        int y = num;
        int r = 0;

        while (y > 0){
            r += (num % (y % 10) == 0) ? 1 : 0;
            y /= 10;
        }

        return r;
    }
}
