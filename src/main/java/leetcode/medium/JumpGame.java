package leetcode.medium;

public class JumpGame {
    //problem:
    //You are given an integer array nums. You are initially positioned at the array's first index, and each element
    // in the array represents your maximum jump length at that position.
    //Return true if you can reach the last index, or false otherwise.
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(canJump(nums)); //output: true
    }

    public static boolean canJump(int[] nums) {
        int jumpDistance = nums[0];
        int i = 1;

        while (jumpDistance > 0 && i < nums.length){
            jumpDistance--;
            jumpDistance = Math.max(jumpDistance, nums[i]);
            i++;
        }

        return i == nums.length;
    }
}
