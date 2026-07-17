package leetcode.easy;

public class MinimumOperationsToMakeArrayIncreasing {
    //problem: You are given an integer array nums (0-indexed). In one operation,
    // you can choose an element of the array and increment it by 1.
    //Return the minimum number of operations needed to make nums strictly increasing
    public static void main(String[] args) {
        int nums[] = {1,5,2,4,1};
        System.out.println(minOperations(nums)); //output: 14
    }

    public static int minOperations(int[] nums) {
        int oper = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++){

            if (nums[i] <= prev){
                oper += 1 + prev - nums[i];
                nums[i] = 1 + prev;
            }

            prev = nums[i];

        }

        return oper;
    }
}
