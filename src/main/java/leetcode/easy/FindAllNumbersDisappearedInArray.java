package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    //problem: Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in nums

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums)); //output: [5, 6]
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++){
            while (nums[nums[i]-1] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;
            }
        }


        for (int i = 0; i < nums.length; i++){
            if (nums[i] != (i+1)){
                res.add(i+1);
            }
        }

        return res;
    }
}
