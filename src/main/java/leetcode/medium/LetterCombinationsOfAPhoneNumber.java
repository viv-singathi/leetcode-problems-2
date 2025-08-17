package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        List<String> combinations = letterCombinations("23");

        System.out.println(combinations.toString());

        //output: [ad, ae, af, bd, be, bf, cd, ce, cf]

    }

    static char map[][] = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<String>();

        if (digits.length() == 0){
            return res;
        }

        combine(res, digits.toCharArray(), new char[digits.length()], 0);

        return res;
    }

    public static void combine(List<String> l, char digits[], char current_combination[], int idx){
        if (idx >= digits.length){
            l.add(new String(current_combination));
            return;
        }

        char possbible_chars[] = map[digits[idx] - '2'];

        for (int i = 0; i < possbible_chars.length; i++){
            current_combination[idx] = possbible_chars[i];
            combine(l, digits, current_combination, idx+1);
        }

    }
}
