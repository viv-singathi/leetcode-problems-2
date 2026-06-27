package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ValidElementsInArray {
    //problem: You are given an integer array nums.
    //An element nums[i] is considered valid if it satisfies at least one of the following conditions:
    //
    //It is strictly greater than every element to its left.
    //It is strictly greater than every element to its right.
    //The first and last elements are always valid.
    //
    //Return an array of all valid elements in the same order as they appear in nums

    public static void main(String[] args) {
        int arr[] = {1,2,4,2,3,2};
        System.out.println(findValidElements(arr));
    }

    public static List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        res.add(nums[0]);
        if (nums.length == 1){ return res; }

        int rightMax[] = new int[nums.length];

        rightMax[rightMax.length-1] = nums[rightMax.length-1];

        for (int i = rightMax.length-2; i >= 0; i--){
            rightMax[i] = Math.max(nums[i], rightMax[i+1]);
        }

        int leftMax = nums[0];

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i] > rightMax[i+1] || nums[i] > leftMax){
                res.add(nums[i]);
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        res.add(nums[nums.length-1]);

        return res;
    }
}
