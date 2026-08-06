package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {
    //problem: You are given an integer array nums consisting of unique integers.
    //Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
    //The smallest and largest integers of the original range are still present in nums.
    //Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list
    public static void main(String[] args) {
        int nums[] = {5,1};
        System.out.println(findMissingElements(nums)); //output:[2, 3, 4]
    }

    public static List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>(nums[nums.length-1] - nums[0] - nums.length + 1);

        for (int i = 0; i < nums.length - 1; i++){
            for (int n = nums[i] + 1; n < nums[i+1]; n++){
                res.add(n);
            }
        }

        return res;
    }
}
