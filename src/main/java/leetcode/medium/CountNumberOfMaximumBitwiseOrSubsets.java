package leetcode.medium;

public class CountNumberOfMaximumBitwiseOrSubsets {
    //problem: Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different
    // non-empty subsets with the maximum bitwise OR.
    //An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
    // Two subsets are considered different if the indices of the elements chosen are different.
    public static void main(String[] args) {
        int nums[] = {3,2,1,5};
        System.out.println(countMaxOrSubsets(nums)); //output: 6
    }

    public static int countMaxOrSubsets(int[] nums) {
        int m = 0;

        for (int i = 0; i < nums.length; i++){
            m = m | nums[i];
        }

        return checkSubsets(0, m, nums, 0);
    }

    public static int checkSubsets(int current, int  m, int nums[], int i){
        int total = 0;

        if (current == m){
            total = (1 << (nums.length - i));
        } else {
            for (; i < nums.length; i++){
                total += checkSubsets(current | nums[i], m, nums, i+1);
            }
        }
        return total;
    }
}
