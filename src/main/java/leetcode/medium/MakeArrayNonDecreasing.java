package leetcode.medium;

public class MakeArrayNonDecreasing {
    //problem: You are given an integer array nums.
    // In one operation, you can select a subarray and replace it with a single element equal to its maximum value.
    //Return the maximum possible size of the array after performing zero or more operations such that the resulting array is non-decreasing
    public static void main(String[] args) {
        int arr[] = {4,2,5,3,5};
        System.out.println(maximumPossibleSize(arr)); //output: 3
    }

    public static int maximumPossibleSize(int[] nums) {
        int s = nums.length;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < prev){
                nums[i] = prev;
                s--;
            }

            prev = nums[i];
        }

        return s;
    }
}
