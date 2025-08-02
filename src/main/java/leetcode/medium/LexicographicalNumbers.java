package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        List<Integer> r = lexicalOrder(13);

        System.out.println(r.toString());
        //output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]

    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>(n);
        int len = flog10(n) + 1;

        for (int i = 1; i <= Math.min(9, n); i++){

            generateNumbers(res, len, n, i);
        }

        return res;
    }

    public static void generateNumbers(List<Integer> l, int max_len, int max_number, int currentNumber){

        l.add(currentNumber);

        for (int i = 0; i < 10; i++){
            if (currentNumber * 10 + i > max_number){
                return;
            }
            generateNumbers(l, max_len, max_number, currentNumber * 10 + i);
        }

    }

    public static int flog10(int n){
        int r = 0;

        while (n / 10 > 0){
            r++;
            n /= 10;
        }

        return r;
    }
}
