package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int nums[] = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);

        for (List<Integer> l : res){
            System.out.println(l.toString());
        }
        //output:
        //[]
        //[1]
        //[1, 2]
        //[1, 2, 2]
        //[2]
        //[2, 2]

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            int min_idx = i;
            int n = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < n){
                    min_idx = j;
                    n = nums[j];
                }
            }

            nums[min_idx] = nums[i];
            nums[i] = n;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subsets(nums, res, new ArrayList<Integer>(), 0);

        return res;
    }

    public static void subsets(int nums[], List<List<Integer>> l, List<Integer> current_subset , int idx){

        l.add(new ArrayList<Integer>(current_subset));

        if (idx >= nums.length){
            return;
        }

        for (int i = idx; i < nums.length; i++){
            if (i == idx || nums[i] != nums[i-1]){
                current_subset.add(nums[i]);
                subsets(nums, l, current_subset, i+1);
                current_subset.remove(current_subset.size() - 1);
            }
        }
    }
}
