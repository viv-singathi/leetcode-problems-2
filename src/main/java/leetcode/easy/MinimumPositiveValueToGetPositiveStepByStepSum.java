package leetcode.easy;

public class MinimumPositiveValueToGetPositiveStepByStepSum {
    //problem:
    //Given an array of integers nums, you start with an initial positive value startValue.
    //In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
    //Return the minimum positive value of startValue such that the step by step sum is never less than 1.
    public static void main(String[] args) {
        int arr[] = {-3,2,-3,4,2};
        System.out.println(minStartValue(arr));//5
    }

    public static int minStartValue(int[] nums) {
        int s = 0;
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++){
            s += nums[i];
            if (s < minSum){
                minSum = s;
            }
        }

        return minSum < 1 ? -minSum + 1 : 1;
    }
}
