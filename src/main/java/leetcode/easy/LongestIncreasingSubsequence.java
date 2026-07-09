package leetcode.easy;

public class LongestIncreasingSubsequence {
    //problem: Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray).
    // The subsequence must be strictly increasing.
    //
    //A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is
    // [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1]
    public static void main(String[] args) {
        int nums[] = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums)); //output: 3
    }

    public static int findLengthOfLCIS(int[] nums) {
        int l = 0;
        int u = 0;
        int longest = 1;

        while (u+1 < nums.length){
            if (nums[u+1] > nums[u]){
                u++;
                longest = Math.max(longest, 1 + u-l);
            } else {
                u++;
                l = u;
            }
        }

        return longest;
    }
}
