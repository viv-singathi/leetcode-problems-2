package leetcode.medium;

public class MaxSubarray {

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        // output: 6

    }

    public static int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int current_sum = nums[0];

        for (int i = 1; i < nums.length; i++){

            if (current_sum + nums[i] < nums[i]){
                current_sum = nums[i];
            } else {
                current_sum += nums[i];
            }

            if (current_sum > max_sum){
                max_sum = current_sum;
            }
        }

        return max_sum;
    }
}
