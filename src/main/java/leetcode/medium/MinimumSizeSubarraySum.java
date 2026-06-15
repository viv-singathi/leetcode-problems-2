package leetcode.medium;

public class MinimumSizeSubarraySum {
    //problem: Given an array of positive integers nums and a positive integer target, return the minimal length of a
    // subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums)); //output: 2
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int s = 0;

        int min_len = nums.length+1;;

        while (i < nums.length && j < nums.length){
            if (s < target || j == i){
                s += nums[j++];
            } else {
                s -= nums[i++];
            }

            if (s >= target && (j - i) < min_len){
                min_len = j - i;
            }
        }

        while (s >= target && i < nums.length){
            s -= nums[i++];
            if (s >= target && (j - i) < min_len){
                min_len = j - i;
            }
        }

        return min_len <= nums.length ? min_len : 0;
    }
}
