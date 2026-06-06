package leetcode.easy;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    //problem: You are given a 0-indexed integer array nums of size n.
    //Define two arrays leftSum and rightSum where:
    //leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    //rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
    //Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

    public static void main(String[] args) {
        int nums[] = {10,4,8,3};
        System.out.println(Arrays.toString(leftRightDifference(nums)));//output: [15, 1, 11, 22]
    }

    public static int[] leftRightDifference(int[] nums) {
        int sums[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }

        int totalSum = sums[sums.length - 1] + nums[sums.length - 1];

        for(int i = 0; i < nums.length-1; i++){
            sums[i] = Math.abs(sums[i] - (totalSum - sums[i+1]));
        }

        return sums;
    }
}
