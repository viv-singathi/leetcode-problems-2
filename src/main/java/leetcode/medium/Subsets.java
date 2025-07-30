package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int nums[] = {1, 2, 3};

        List<List<Integer>> P = subsets(nums);

        for (List<Integer> l : P){
            System.out.println(l.toString());
        }

        //output:
        //[]
        //[1]
        //[2]
        //[3]
        //[1, 2]
        //[1, 3]
        //[2, 3]
        //[1, 2, 3]

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> P = new ArrayList<List<Integer>>();
        P.add(new ArrayList<Integer>());

        for (int i = 1; i <= nums.length; i++){
            subsetsOfSizeN(nums, i, P, new ArrayList<Integer>(i), 0);
        }

        return P;
    }

    public static void subsetsOfSizeN(int nums[], int n, List<List<Integer>> P, List<Integer> current_subset , int idx){
        if (current_subset.size() >= n){
            List<Integer> copy = new ArrayList<Integer>();

            for (Integer num : current_subset){
                copy.add(num);
            }

            P.add(copy);
            return;
        }

        for (int i = idx; i < nums.length; i++){
            current_subset.add(nums[i]);
            subsetsOfSizeN(nums, n, P, current_subset, i+1);
            current_subset.remove(current_subset.size() - 1);
        }
    }
}
