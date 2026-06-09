package leetcode.medium;

public class MaxSubarrayValueI {
    //problem:
    //You are given an integer array nums of length n and an integer k.
    //You need to choose exactly k non-empty subarrays nums[l..r] of nums. Subarrays may overlap, and the exact same subarray (same l and r) can be chosen more than once.
    //The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
    //The total value is the sum of the values of all chosen subarrays.
    //Return the maximum possible total value you can achieve.
    public static void main(String[] args) {
        int nums[] = {1,3,2};
        System.out.println(maxTotalValue(nums, 2)); //output: 4
    }

    public static long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return (long) (max - min) * k;
    }
}
