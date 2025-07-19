package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int n[] = {1,2,3};
        List<List<Integer>> permutations = permute(n);

        for (List<Integer> l : permutations){
            System.out.println(l.toString());
        }

        //output:
        //[1, 2, 3]
        //[1, 3, 2]
        //[2, 1, 3]
        //[2, 3, 1]
        //[3, 1, 2]
        //[3, 2, 1]

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations =  new ArrayList<List<Integer>>();
        int perm[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            perm[i] = -11;
        }

        permuteList(nums, permutations, perm, 0);

        return permutations;
    }

    public static void permuteList(int nums[], List<List<Integer>> permuatations, int[] current_permutation, int idx) {

        if (idx >= nums.length) {
            List<Integer> copy = new ArrayList<Integer>();
            for (int i = 0; i < current_permutation.length; i++) {
                copy.add(current_permutation[i]);
            }
            permuatations.add(copy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            boolean inList = false;

            for (int j = 0; j < nums.length; j++) {
                if (current_permutation[j] == nums[i]) {
                    inList = true;
                    break;
                }
            }

            if (inList) {
                continue;
            }

            current_permutation[idx] = nums[i];
            permuteList(nums, permuatations, current_permutation, idx + 1);
            current_permutation[idx] = -11;
        }
    }
}
