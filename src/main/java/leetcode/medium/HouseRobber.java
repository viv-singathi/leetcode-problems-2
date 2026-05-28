package leetcode.medium;

public class HouseRobber {
    //problem:
    // You are a professional robber planning to rob houses along a street.
    // Each house has some money stashed. Adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into.
    // Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob without alerting the police.

    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        System.out.println(rob(nums)); //output: 12
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        if (nums.length == 2) { return (nums[0] > nums[1] ? nums[0] : nums[1]); }

        int res[] = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[1];
        res[2] = Math.max(res[1], res[0] + nums[2]);

        for (int i = 3; i < nums.length; i++){
            res[i] = Math.max(Math.max(res[i-1], res[i-2] + nums[i]), res[i-3] + nums[i]);
        }

        return res[nums.length-1];
    }
}
