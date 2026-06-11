package leetcode.medium;

public class MinimumAverageDifference {
    //problem: You are given a 0-indexed integer array nums of length n.
    //The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
    //Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
    public static void main(String[] args) {
        int nums[] = {2,5,3,9,5,3};
        System.out.println(minimumAverageDifference(nums)); //output: 3
    }

    public static int minimumAverageDifference(int[] nums) {
        if (nums.length == 1){return 0;}

        long totalSum = 0;

        for (int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        long currentSum = nums[0];
        long min = Math.abs(currentSum - (totalSum - currentSum) / (nums.length-1));
        int idx = 0;

        for (int i = 1; i < nums.length-1; i++){
            currentSum += nums[i];
            long diff = Math.abs((currentSum / (i + 1)) - (totalSum - currentSum) / (nums.length-1-i));
            if (diff < min){
                min = diff;
                idx = i;
            }

        }

        if (Math.abs(totalSum/nums.length) < min){
            idx = nums.length-1;
        }

        return idx;
    }
}
