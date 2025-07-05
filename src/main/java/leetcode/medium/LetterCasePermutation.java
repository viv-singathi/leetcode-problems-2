package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String args[]){
        List<String> permutations = letterCasePermutation("a1b2");

        for (int i = 0; i < permutations.size(); i++){
            System.out.println(permutations.get(i));
        }

        //output: a1b2, a1B2, A1b2, A1B2
    }

    public static List<String> letterCasePermutation(String s) {
        char characters[] = s.toCharArray();
        List<String> permutations = new ArrayList<String>();

        permuteCase(permutations, characters, 0);

        return permutations;
    }

    public static void permuteCase(List<String> permutations, char current_permutation[], int idx){
        if (idx >= current_permutation.length){
            permutations.add(new String(current_permutation));
            return;
        }

        if (current_permutation[idx] >= 'A' && current_permutation[idx] <= 'Z'){

            permuteCase(permutations, current_permutation, idx + 1);
            current_permutation[idx] += 32;

            permuteCase(permutations, current_permutation, idx + 1);
            current_permutation[idx] -= 32;

        } else if ( current_permutation[idx] >= 'A' && current_permutation[idx] <= 'z'){

            permuteCase(permutations, current_permutation, idx + 1);
            current_permutation[idx] -= 32;

            permuteCase(permutations, current_permutation, idx + 1);
            current_permutation[idx] += 32;

        } else {
            permuteCase(permutations, current_permutation, idx + 1);
        }

    }
}
