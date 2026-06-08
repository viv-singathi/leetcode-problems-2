package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    //problem:
    //Given an integer array nums of length n where all the integers of nums are in the range [1, n]
    // and each integer appears at most twice, return an array of all the integers that appears twice.
    public static void main(String[] args) {
        int arr[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr)); //output: [3, 2]
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++){
            while (nums[nums[i]-1] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i+1){
                res.add(nums[i]);
            }
        }

        return res;
    }
}
