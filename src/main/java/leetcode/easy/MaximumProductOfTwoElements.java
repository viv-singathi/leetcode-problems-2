package leetcode.easy;

public class MaximumProductOfTwoElements {
    //problem: Given the array of integers nums, you will choose two different indices i and j of that array.
    // Return the maximum value of (nums[i]-1)*(nums[j]-1)
    public static void main(String[] args) {
        int arr[] = {3,4,5,2};
        System.out.println(maxProduct(arr)); //output: 12
    }

    public static int maxProduct(int[] nums) {
        int max1 = Math.max(nums[0], nums[1]);
        int max2 = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            if (nums[i] >= max1){
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2){
                max2 = nums[i];
            }
        }

        return (max1 - 1) * (max2 - 1);
    }


}
