package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    //problem: A self-dividing number is a number that is divisible by every digit it contains.
    //For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    //A self-dividing number is not allowed to contain the digit zero.
    //Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22)); //output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>(right - left );

        for (int i = left; i<= right; i++){
            int n = i;
            boolean self_dividing = true;

            while (n > 0){
                int d = n % 10;
                if (d == 0 || i % d != 0) {
                    self_dividing = false;
                    break;
                }
                n /= 10;
            }

            if (self_dividing){
                res.add(i);
            }
        }

        return res;
    }
}
