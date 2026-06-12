package leetcode.medium;

public class HouseRobberII {
    //problem:
    //You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
    // All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
    // Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
    //Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));//output: 4
    }

    public static int rob(int[] nums) {
        if (nums.length == 1){return nums[0];}
        if (nums.length == 2){return Math.max(nums[0], nums[1]);}
        if (nums.length == 3){return Math.max(Math.max(nums[0], nums[1]), nums[2]);}

        int robFirst3 = nums[0];
        int robFirst2 = 0;
        int robFirst1 = robFirst3 + nums[2];

        int skipFirst3 = 0;
        int skipFirst2 = nums[1];
        int skipFirst1 = nums[2];

        for (int i = 3; i < nums.length-1; i++){
            int robFirstNext = Math.max(Math.max(robFirst1, robFirst2 + nums[i]), robFirst3 + nums[i]);
            int skipFirstNext = Math.max(Math.max(skipFirst1, skipFirst2 + nums[i]), skipFirst3 + nums[i]);

            robFirst3 = robFirst2;
            robFirst2 = robFirst1;
            robFirst1 = robFirstNext;

            skipFirst3 = skipFirst2;
            skipFirst2 = skipFirst1;
            skipFirst1 = skipFirstNext;
        }

        skipFirst1 = Math.max(skipFirst1,
                Math.max(skipFirst2 + nums[nums.length-1], skipFirst3 + nums[nums.length-1]));
        robFirst1 = Math.max(robFirst1, Math.max(robFirst2, robFirst3));

        return Math.max(skipFirst1, robFirst1);
    }
}
