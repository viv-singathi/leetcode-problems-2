package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    //problem: An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
    //Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits
    public static void main(String[] args) {
        System.out.println(sequentialDigits(1000, 13000)); //output:  [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        int max_digits = (int) Math.log10(high) + 1;
        int min_digits = (int) Math.log10(low) + 1;

        List<Integer> res = new ArrayList<Integer>();

        for (int l = min_digits; l <= max_digits; l++){
            for (int i = 1; i <= 10 - l; i++){
                int r = i;

                for (int j = i+1; j < i + l; j++){
                    r = r * 10 + j;
                }

                if (r <= high && r >= low){
                    res.add(r);
                }
            }

        }

        return res;
    }
}
