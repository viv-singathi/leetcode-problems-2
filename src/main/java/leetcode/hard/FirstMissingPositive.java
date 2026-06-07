package leetcode.hard;

import java.util.Arrays;

public class FirstMissingPositive {
    //problem: Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
    public static void main(String[] args) {
        int arr[] = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr)); //output: 2
    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }
}
