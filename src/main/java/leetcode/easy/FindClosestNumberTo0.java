package leetcode.easy;

public class FindClosestNumberTo0 {
    //problem: Given an integer array nums of size n, return the number with the value closest to 0 in nums.
    // If there are multiple answers, return the number with the largest value.
    public static void main(String[] args) {
        int arr[] = {-4,-2,1,4,8};
        System.out.println(findClosestNumber(arr)); //output: 1
    }

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];
        int absc = Math.abs(closest);

        for (int i = 1; i < nums.length; i++){
            int absn = Math.abs(nums[i]);
            if (absn < absc || absn == absc && nums[i] > closest){
                closest = nums[i];
                absc = absn;

            }
        }

        return closest;
    }
}
