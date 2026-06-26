package leetcode.easy;

public class MaximumAverageSubarray {
    //problem: You are given an integer array nums consisting of n elements, and an integer k.
    //Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value
    public static void main(String[] args) {
        int arr[] = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(arr, 4)); //output: 12.75
    }

    public static double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int s = 0;

        for (int i = 0; i < k; i++){
            s += nums[i];
        }

        double max = ((double) s) / k;

        for (int i = k; i < nums.length; i++){
            s = s - nums[i-k] + nums[i];
            if (((double) s) / k > max){
                max =((double) s) / k;
            }

        }

        return max;
    }
}
