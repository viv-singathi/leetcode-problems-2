package leetcode.medium;

public class JumpGameII {
    //problem: You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
    //
    //Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i,
    // you can jump to any index (i + j) where: 0 <= j <= nums[i] and i + j < n
    //Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(jump(arr)); //output: 2
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1){return 0;}
        int next_idx = nums[0] < nums.length ? nums[0] : nums.length-1;
        int i = 0;
        int jumps = 0;

        while (i < nums.length){
            int next_jump = i + nums[i];

            for (; i <= next_idx; i++){
                if (i + nums[i] > next_jump){
                    next_jump = i + nums[i];
                }
            }

            next_idx = next_jump < nums.length ? next_jump : nums.length-1;
            jumps++;
        }

        return jumps;
    }
}
