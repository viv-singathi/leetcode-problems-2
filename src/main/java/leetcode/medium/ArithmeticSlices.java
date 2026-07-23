package leetcode.medium;

public class ArithmeticSlices {
    //An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
    //For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    //Given an integer array nums, return the number of arithmetic subarrays of nums.
    //A subarray is a contiguous subsequence of the array.
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(arr)); //output: 3

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {return 0;}
        int res = 0;

        int l = 0;
        int u = 0;
        int diff = -1;

        while (u < nums.length){
            if (u == l && u+1 < nums.length){
                u++;
                diff = nums[u] - nums[l];
            } else {
                u++;
                if (u >= nums.length || nums[u] - nums[u-1] != diff){
                    int n = u - l;
                    if (u <  nums.length){
                        l = --u;
                    }
                    if (n >= 3){
                        res += (n-2) * (n-1) / 2;
                    }
                }
            }
        }

        return res;

    }
}
