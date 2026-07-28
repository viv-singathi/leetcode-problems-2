package leetcode.easy;

import java.util.Arrays;

public class DistributeElementsIntoTwoArrays {

    //problem:
    //You are given a 1-indexed array of distinct integers nums of length n.
    //You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations.
    // In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:
    //If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2.
    //The array result is formed by concatenating the arrays arr1 and arr2.
    //Return the array result
    public static void main(String[] args) {
        int nums[] = {2,1,3};
        System.out.println(Arrays.toString(resultArray(nums))); //output: [2, 3, 1]
    }

    public static int[] resultArray(int[] nums) {
        int nums1[] = new int[nums.length];
        int nums2[] = new int [nums.length];
        int n1 = 0;
        int n2 = 0;
        nums1[n1++] = nums[0];
        nums2[n2++] = nums[1];

        for (int i = 2; i < nums.length; i++){
            if (nums1[n1-1] > nums2[n2-1]){
                nums1[n1++] = nums[i];
            } else {
                nums2[n2++] = nums[i];
            }
        }

        for (int i = 0; i < n2; i++){
            nums1[n1++] = nums2[i];
        }

        return nums1;
    }
}
