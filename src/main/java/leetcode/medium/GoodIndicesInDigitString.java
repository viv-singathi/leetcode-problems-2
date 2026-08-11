package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GoodIndicesInDigitString {
    //problem: You are given a string s consisting of digits.
    //An index i is called good if there exists a substring of s that ends at index i and is equal to the decimal representation of i.
    //Return an integer array of all good indices in increasing order
    public static void main(String[] args) {
        System.out.println(goodIndices("0234567890112")); //output: [0, 11, 12]
    }

    public static List<Integer> goodIndices(String s) {
        List<Integer> res = new ArrayList<Integer>();
        char str[] = s.toCharArray();

        if (str[0] == '0'){
            res.add(0);
        }

        for (int i = 1; i < str.length; i++){
            int n = i;
            int d = str[i] - '0';
            int t = 1;

            while (n % 10 == d && n > 0){
                d = str[i-t++] - '0';
                n /= 10;
            }

            if (n == 0 && i != 0){
                res.add(i);
            }
        }

        return res;
    }
}
